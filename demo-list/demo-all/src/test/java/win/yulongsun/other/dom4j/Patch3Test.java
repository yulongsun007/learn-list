package win.yulongsun.other.dom4j;

import org.junit.Test;
import win.yulongsun.demo.all.basic.reflect.dom4j.Patch3;

import java.util.ArrayList;

/**
 * Created by sunyl21830 on 2017/7/13.
 */
public class Patch3Test {
    @Test
    public void patchXml() throws Exception {
        Patch3 patch3 = new Patch3();
        String xmlPath = "./src/main/java/win/yulongsun/other/dom4j/msdsf_convert.xml";
        String newXmlPath = "./src/main/java/win/yulongsun/other/dom4j/msdsf_convert_new.xml";
        ArrayList<String> updateList = new ArrayList<String>();
        updateList.add("value");
        updateList.add("describe");
        System.out.println(patch3.patchXml(xmlPath, newXmlPath, updateList));

    }

}