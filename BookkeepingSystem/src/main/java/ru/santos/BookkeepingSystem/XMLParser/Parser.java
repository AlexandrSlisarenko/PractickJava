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
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;

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
    private String getData(){
        Date date = new Date();
        String res = date.toString();
        res = res.replaceAll("\\s+","_");
        res = res.replaceAll(":","_");
        return res;
    }
    public String createOrderFinishedBook(String title, String author, String count) throws ParserConfigurationException, IOException, SAXException {
        String result = "";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File("D:\\Java\\PractickJava\\BookkeepingSystem\\src\\main\\resources\\static\\newOrderBook.xml"));
        document = orderFilling(document,title,author,count);
        Transformer transformer = null;
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            //tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            // send DOM to file
            result = "D:\\Java\\PractickJava\\BookkeepingSystem\\src\\main\\resources\\static\\newOrderBook"+title+"_"+getData()+".xml";
            tr.transform(new DOMSource(document),
                    new StreamResult(new FileOutputStream(result)));


        } catch (TransformerException te) {
            System.out.println(te.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        return result;

    }

    private Document orderFilling(Document document, String title, String author, String count) {
        document.getElementsByTagName("title").item(0).setTextContent(title);
        document.getElementsByTagName("author").item(0).setTextContent(author);
        document.getElementsByTagName("count").item(0).setTextContent(count);
        return document;
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

    private synchronized void pars(NodeList nodeList) {
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