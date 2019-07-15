package ru.santos.sweaterlearnboot.XMLParser;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

@Component
public class Parser {

    private Element elementDoc;

    public void parsOrder(String filePath) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(filePath));
        this.elementDoc = document.getDocumentElement();
        showDocument(this.elementDoc.getChildNodes());
    }

    public void showDocument(NodeList nodeList){
        String doc = "";
       for (int i = 0; i < nodeList.getLength(); i++) {
          if((((Element) nodeList.item(i)).getTagName() == "book")) doc +="<book "+1+">\n";
           if(nodeList.item(i).hasChildNodes()){

                showDocument(nodeList.item(i).getChildNodes());

            }else{
                doc +="   "+((Element) nodeList.item(i)).getTagName().trim()+" : "+ nodeList.item(i).getTextContent().trim()+"\n";

            }
           if(((Element) nodeList.item(i).getParentNode()).getTagName() == "order") doc +="</book>\n";
        }
        System.out.println(doc);
    }





}
