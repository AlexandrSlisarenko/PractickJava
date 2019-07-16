package ru.santos.BookkeepingSystem.XMLParser;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.ModelData.Order.Order;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class Parser {

    private Element elementDoc;
    private String strSend;
    private int countParam;


    public void parsOrder(String filePath) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(filePath));
        this.elementDoc = document.getDocumentElement();
        this.strSend = "";
        this.countParam = 0;
        pars(this.elementDoc.getChildNodes());

    }

    public String getStrSend(){
        if(this.strSend != ""){
            return this.strSend;
        }
        else return "parser not find param";
    }



    private void fillingOrder(String key,String val){
        switch (key){
            case "title":
                this.strSend +=key+"="+val+";";
                this.countParam++;
                break;
            case "author":
                this.strSend +=key+"="+val+";";
                this.countParam++;
                break;
            case "count":
                this.strSend +=key+"="+val+";";
                this.countParam++;
                break;
            case "genre":
                this.strSend +=key+"="+val+";";
                this.countParam++;
                break;
            case"price":
                this.strSend +=key+"="+val+";";
                this.countParam++;
                break;
        }

    }

    private void pars(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).hasChildNodes()) {
                pars(nodeList.item(i).getChildNodes());
            } else {
                if(((Element) nodeList.item(i).getParentNode()).getTagName() !="book")
                fillingOrder(nodeList.item(i).getParentNode().getNodeName(),nodeList.item(i).getTextContent().trim());
                if(this.countParam == 5){
                    this.strSend+="@#$%";
                    this.countParam = 0;
                }
            }
        }
    }
}