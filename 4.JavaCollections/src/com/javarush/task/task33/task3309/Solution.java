package com.javarush.task.task33.task3309;


import org.w3c.dom.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, ParserConfigurationException, IOException,  TransformerException {

        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);



        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        StringWriter wr = new StringWriter();

        marshaller.marshal(obj, doc);
        NodeList nodes = doc.getElementsByTagName(tagName);

        Comment jcomment = null;

        createCdata(doc);

        for (int i = 0; i < nodes.getLength(); i++){
            jcomment = doc.createComment(comment);
            /*nodes.item(i).getNodeType();*/
            nodes.item(i).getParentNode().insertBefore(jcomment ,nodes.item(i));
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.transform(new DOMSource(doc), new StreamResult(wr));


        return wr.toString();
    }

    private static void createCdata(Document doc){
        Node topNode = doc.getDocumentElement();
        Node currentNode = null;
        for (currentNode = topNode.getFirstChild(); currentNode != null; currentNode = currentNode.getNextSibling()){
            if (currentNode.getTextContent().matches(".*[<>&'\"].*")) {
                CDATASection cdata = doc.createCDATASection(currentNode.getTextContent());
                currentNode.replaceChild(cdata,currentNode.getFirstChild());
            }
        }
    }
    public static void main(String[] args) {

    }
}
