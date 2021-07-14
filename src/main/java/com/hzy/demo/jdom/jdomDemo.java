package com.hzy.demo.jdom;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class jdomDemo {

    static String  strXml = "<root><row><name>hzy</name></row></root>";

    public static void main(String[] args) {

        StringReader read = new StringReader(strXml);
        //创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
        InputSource source = new InputSource(read);
        //创建一个新的SAXBuilder
        SAXBuilder sb = new SAXBuilder();
        try {
            //通过输入源构造一个Document
            Document doc = sb.build(source);
            //取的根元素
            Element root = doc.getRootElement();
            //输出根元素的名称（测试）
            System.out.println(root.getName());
            //得到根元素所有子元素的集合
            List<Element> list = root.getChildren();

            Element row =  root.getChild("row");

            System.out.println("row.getName()="+row.getName());

            Element name = row.getChild("name");

            System.out.println("name.getName()="+name.getName());

            System.out.println("name.getText()="+name.getText());

            /*System.out.println("list.size()="+list.size());*/
            /*for(Element e :list){
                System.out.println(e.getName());

            }*/

        } catch (JDOMException jdomException) {
            jdomException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
