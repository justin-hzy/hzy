package com.hzy.demo.xml;


        import org.dom4j.Document;
        import org.dom4j.io.OutputFormat;
        import org.dom4j.io.SAXReader;
        import org.dom4j.io.XMLWriter;


        import java.io.IOException;
        import java.io.StringReader;
        import java.io.StringWriter;

public class XmlDemo {

    public static void main(String[] args) throws Exception {

        String xml = "<class><student><firstname>cxx1</firstname><lastname>Bob1</lastname><nickname>stars1</nickname><marks>85</marks></student></class>";

        String xmlStr = formatXML(xml);

        System.out.println(xmlStr);

    }



    public static String formatXML(String inputXML) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = (Document) reader.read(new StringReader(inputXML));
        String requestXML = null;
        XMLWriter writer = null;
        if (document != null) {
            try {
                StringWriter stringWriter = new StringWriter();
                OutputFormat format = new OutputFormat(" ", true);
                writer = new XMLWriter(stringWriter, format);
                writer.write(document);
                writer.flush();
                requestXML = stringWriter.getBuffer().toString();
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
        return requestXML;
    }
}
