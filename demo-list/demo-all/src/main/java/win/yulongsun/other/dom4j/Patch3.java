package win.yulongsun.other.dom4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sunyl21830 on 2017/7/13.
 */
public class Patch3 {

    public static void main(String[] args) throws Exception {
        SAXReader reader = new SAXReader();
        //_* 为新文件
        // *为旧文件
        Document _document = reader.read("./src/main/java/win/yulongsun/other/dom4j/msdsf_convert_new.xml");
        Document document = reader.read("./src/main/java/win/yulongsun/other/dom4j/msdsf_convert.xml");
        ArrayList<String> updateList = new ArrayList<String>(); //需要更新的属性列表
        updateList.add("describe");
        /*
         功能：
         1. 更新节点[新增节点、新增子节点]
         2. 更新属性[修改指定属性的值]
         3. 将旧文件中没有用的元素集合删除
         */
        List<Element> _property = _document.getRootElement().elements();
        List<Element> property = document.getRootElement().elements();
        compare(_property, property, "type", updateList);
        for (int i = 0; i < _property.size(); i++) {
            List<Element> _columnList = _property.get(i).elements();
            List<Element> columnList = property.get(i).elements();
            compare(_columnList, columnList, "name", updateList);
            for (int j = 0; j < _columnList.size(); j++) {
                List _elementList = _columnList.get(j).elements();
                List elementList = columnList.get(j).elements();
                compare(_elementList, elementList, "name", updateList);
            }
        }
        XMLWriter writer = new XMLWriter(new FileOutputStream("./src/main/java/win/yulongsun/other/dom4j/msdsf_convert.xml"), OutputFormat.createPrettyPrint());
        writer.write(document);
        writer.close();
    }

    /**
     * 功能：
     * 1. 更新节点[新增节点、新增子节点]
     * 2. 更新属性[修改指定属性的值]
     * 3. 将旧文件中没有用的元素集合删除
     *
     * @param xmlPath    xml文件位置
     * @param newXmlPath 新xml文件位置
     * @param updateList 需要更新的属性列表
     * @return
     */
    public static boolean patchXml(String xmlPath, String newXmlPath, ArrayList<String> updateList) {
        //1. 将原xml文件备份为.bak
        try {
            File file = new File(xmlPath);
            if (!file.exists()) {
                System.out.println("文件不存在");
                return false;
            }
            File bakFile = new File(xmlPath + ".bak");
            if (bakFile.exists())
                bakFile.delete();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(bakFile));
            String content = "";
            while ((content = bufferedReader.readLine()) != null) {
                bufferedWriter.write(content);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            bufferedWriter.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件不存在");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件创建失败");
            return false;
        }

        //2.更新
        SAXReader reader = new SAXReader();
        Document _document = null;
        Document document = null;
        try {
            _document = reader.read(newXmlPath);
            document = reader.read(xmlPath);
            //暂时只支持更新三级
            //更新property
            List<Element> _property = _document.getRootElement().elements();
            List<Element> property = document.getRootElement().elements();
            compare(_property, property, "type", updateList);
            for (int i = 0; i < _property.size(); i++) {
                //更新column
                List<Element> _columnList = _property.get(i).elements();
                List<Element> columnList = property.get(i).elements();
                compare(_columnList, columnList, "name", updateList);
                //更新set
                for (int j = 0; j < _columnList.size(); j++) {
                    List _elementList = _columnList.get(j).elements();
                    List elementList = columnList.get(j).elements();
                    compare(_elementList, elementList, "name", updateList);
                }
            }
            XMLWriter writer = new XMLWriter(new FileOutputStream(xmlPath), OutputFormat.createPrettyPrint());
            writer.write(document);
            writer.close();
            return true;
        } catch (DocumentException e) {
            e.printStackTrace();
            System.out.println("XML文件读取失败");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 比较方法
     *
     * @param _elementList 新文件元素列表
     * @param elementList  旧文件元素列表
     * @param attrName     属性名
     * @param updateList   需要更新的属性列表
     */
    public static void compare(List<Element> _elementList, List<Element> elementList, String attrName, ArrayList<String> updateList) {
        if (isEmpty(_elementList) || isEmpty(elementList) || isEmpty(updateList)) {
            return;
        }
        int _elementListSize = _elementList.size();
        int elementListSize = elementList.size();

        //String容器,存放旧文件中的attrName属性的值集合
        ArrayList<String> attrNameVauleConatiner = new ArrayList<String>();
        attrNameVauleConatiner.clear();
        for (int j = 0; j < elementListSize; j++) {
            attrNameVauleConatiner.add(elementList.get(j).attributeValue(attrName));
        }
        for (int i = 0; i < _elementListSize; i++) {
            Element _element = _elementList.get(i);
            String _attrValue = _element.attributeValue(attrName);
            //1. 如果旧文件中不存在该属性的元素，就新增一个元素
            if (!attrNameVauleConatiner.contains(_attrValue)) {
                elementList.add(i, (Element) _element.clone());
            }

            //2. 如果旧文件中存在该属性的元素，就更新该元素的属性
            for (int j = 0; j < elementListSize; j++) {
                Element element = elementList.get(j);
                //找到该元素
                if (element != null && element.attributeValue(attrName).equals(_attrValue)) {
                    //遍历，更新属性
                    for (int k = 0; k < _element.attributeCount(); k++) {
                        Attribute attrNew = _element.attribute(k);
                        String keyNew = attrNew.getName();
                        if (updateList.contains(keyNew)) {
                            element.setAttributeValue(keyNew, attrNew.getValue());
                        }
                    }
                }
            }
        }
        //3. 将旧文件中没有用的元素集合删除
        //String容器,存放新文件中的attrName属性的值集合
        ArrayList<String> _attrNameValueConatiner = new ArrayList<String>();
        for (int j = 0; j < _elementListSize; j++) {
            _attrNameValueConatiner.add(_elementList.get(j).attributeValue(attrName));
        }
        Iterator<Element> iterator = elementList.iterator();
        while (iterator.hasNext()) {
            String attrValue = iterator.next().attributeValue(attrName);
            if (!_attrNameValueConatiner.contains(attrValue)) {
                iterator.remove();
            }
        }
    }


    private static boolean isEmpty(List list) {
        return list == null || list.isEmpty();
    }

}
