package win.yulongsun.other.dom4j;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunyl21830 on 2017/7/13.
 */
public class Patch2 {

    public static void main(String[] args) throws Exception {
        SAXReader reader = new SAXReader();
        Document documentNew = reader.read("./src/main/java/win/yulongsun/other/dom4j/msdsf_convert_new.xml");
        Document document = reader.read("./src/main/java/win/yulongsun/other/dom4j/msdsf_convert.xml");
        ArrayList<String> updateList = new ArrayList<String>(); //需要更新的属性列表
        updateList.add("describe");
        /*
         功能：
         1. 更新节点[新增节点、新增子节点]
         2. 更新属性[修改指定属性的值]
         */
        List<Element> propertyNew = documentNew.getRootElement().elements();
        List<Element> property = document.getRootElement().elements();
        compare(propertyNew, property, "type", updateList);
        for (int i = 0; i < propertyNew.size(); i++) {
            List<Element> columnNewList = propertyNew.get(i).elements();
            List<Element> columnList = property.get(i).elements();
            compare(columnNewList, columnList, "name", updateList);
            for (int j = 0; j < columnNewList.size(); j++) {
                List elementNewList = columnNewList.get(j).elements();
                List elementList = columnList.get(j).elements();
                compare(elementNewList, elementList, "name", updateList);
            }
        }
        XMLWriter writer = new XMLWriter(new FileOutputStream("./src/main/java/win/yulongsun/other/dom4j/msdsf_convert.xml"), OutputFormat.createPrettyPrint());
        writer.write(document);
        writer.close();
    }


    /**
     * 比较方法
     *
     * @param elementNewList
     * @param elementList
     */
    public static void compare(List<Element> elementNewList, List<Element> elementList, String attrName, ArrayList<String> updateList) {
        if (isEmpty(elementNewList) || isEmpty(elementList) || isEmpty(updateList)) {
            return;
        }
        if (elementNewList.size() != elementList.size()) {
            //新增节点
            for (int i = 0; i < elementNewList.size(); i++) {
                Element elementNew = elementNewList.get(i);
                String attrValueNew = elementNew.attributeValue(attrName);
                //String容器,存放旧文件中的属性
                ArrayList<String> containList = new ArrayList<String>();
                for (int j = 0; j < elementList.size(); j++) {
                    String type = elementList.get(j).attributeValue(attrName);
                    containList.add(type);
                }
                //如果旧文件中不存在该属性的元素，就新增一个元素
                if (!containList.contains(attrValueNew)) {
                    // The Node already has an existing parent of "root“
                    //elementNew.clone() 只能将目标元素的内容复制过来，不能将整个元素复制
                    elementList.add(i, (Element) elementNew.clone());
                }

            }
        } else {
            //更新属性值
            for (int i = 0; i < elementNewList.size(); i++) {
                for (String updateKey : updateList) {
                    String attrNew = elementNewList.get(i).attributeValue(attrName);
                    String attr = elementList.get(i).attributeValue(attrName);
                    //如果属性名相同，但是属性值不同，则取新文件中的属性值
                    if (attr.equals(attrNew)) {
                        elementList.get(i).setAttributeValue(updateKey, elementNewList.get(i).attributeValue(updateKey));
                    }
                }

            }

        }
    }


    private static boolean isEmpty(List list) {
        return list == null || list.isEmpty();
    }

}
