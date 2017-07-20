package win.yulongsun.other.dom4j;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunyl21830 on 2017/7/13.
 */
public class Patch1 {

    public static void main(String[] args) throws Exception {
        SAXReader reader = new SAXReader();
        Document documentNew = reader.read("./src/main/java/win/yulongsun/other/dom4j/default_convert_new.xml");
        Document document = reader.read("./src/main/java/win/yulongsun/other/dom4j/default_convert.xml");
        ArrayList<String> updateList = new ArrayList<String>(); //需要更新的属性列表

        /*
         功能：
         1. 更新节点[新增节点、新增子节点]
         2. 更新属性[修改属性值]
         */
        List<Element> propertyNew = documentNew.getRootElement().elements("property");
        List<Element> property = document.getRootElement().elements("property");

        compare(propertyNew, property, "type", null);
        updateList.add("describe");
        for (int i = 0; i < propertyNew.size(); i++) {
            List<Element> columnNewList = propertyNew.get(i).elements("column");
            List<Element> columnList = property.get(i).elements("column");
            compare(columnNewList, columnList, "name", updateList);
            for (int j = 0; j < columnNewList.size(); j++) {
                List elementNewList = columnNewList.get(j).elements();
                List elementList = columnList.get(j).elements();
                compare(elementNewList, elementList, "name", updateList);
            }
        }

        XMLWriter writer = new XMLWriter(new FileOutputStream("./src/main/java/win/yulongsun/other/dom4j/default_convert.xml"), OutputFormat.createPrettyPrint());
        writer.write(document);
        writer.close();
    }


    /**
     * 比较方法
     *
     * @param elementNewList
     * @param elementList
     */
    public static void compare(List<Element> elementNewList, List<Element> elementList, String value, ArrayList<String> updateList) {
        if (elementNewList.size() != elementList.size()) {
            for (int i = 0; i < elementNewList.size(); i++) {
                Element elementNew = elementNewList.get(i);
//                Iterator iterator = elementNew.attributeIterator();
//                Element element = (Element) iterator.next();
//                element.getName()
                String typeNew = elementNew.attributeValue(value);
                //String容器,存放属性
                ArrayList<String> containList = new ArrayList<String>();
                for (int j = 0; j < elementList.size(); j++) {
                    String type = elementList.get(j).attributeValue(value);
                    containList.add(type);
                }
                //新增
                if (!containList.contains(typeNew)) {
                    // The Node already has an existing parent of "root“
                    //elementNew.clone() 只能将目标元素的内容复制过来，不能将整个元素复制
                    elementList.add(i, (Element) elementNew.clone());
                }

            }
        } else {
            for (int i = 0; i < elementNewList.size(); i++) {
                if (updateList != null) {
                    //更新
                    for (String key : updateList) {
                        String attrNew = elementNewList.get(i).attributeValue(value);
                        String attr = elementList.get(i).attributeValue(value);
                        if (attr.equals(attrNew)) {
                            elementList.get(i).setAttributeValue(key, elementNewList.get(i).attributeValue(key));
                        }
                    }
                }

            }

        }


    }
}
