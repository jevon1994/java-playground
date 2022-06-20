package com.playground;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;

public class XmlStrGenTest {
    public static void main(String[] args) {
//        gen();
        "1".equals(null);
    }

    public static String gen(){
        String xmlString = "";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            document.setXmlStandalone(true);

            Element itemInfo = document.createElement("ItemInfo");
            document.appendChild(itemInfo);

            Element itemStatistics = document.createElement("ItemStatistics");
            itemStatistics.setTextContent("商品统计");
            itemInfo.appendChild(itemStatistics);

            Element items = document.createElement("Items");
            itemInfo.appendChild(items);
            // 此处可以循环添加
            Element item = document.createElement("Item");
            items.appendChild(item);

            Element itemName = document.createElement("ItemName");
            itemName.setTextContent("iPhone");
            item.appendChild(itemName);

            Element itemNum = document.createElement("ItemNum");
            itemNum.setTextContent("3");
            item.appendChild(itemNum);

            Element itemValue = document.createElement("ItemValue");
            itemValue.setTextContent("1000000");
            item.appendChild(itemValue);

            Element remark = document.createElement("Remark");
            remark.setTextContent("配送");
            itemInfo.appendChild(remark);

            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);

            // xml transform String
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            transformer.transform(domSource, new StreamResult(bos));
            xmlString = bos.toString();
            System.out.println(xmlString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlString;
    }

    static class inner{
        void take(){

        }
    }
}
