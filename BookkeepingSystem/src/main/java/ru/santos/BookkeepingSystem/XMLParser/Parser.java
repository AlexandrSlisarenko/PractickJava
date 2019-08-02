package ru.santos.BookkeepingSystem.XMLParser;



import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.ModelData.Order.Genre;
import ru.santos.BookkeepingSystem.ModelData.Order.Order;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

@Component
public class Parser {

    private Element elementDoc;
    private String strSend;
    private int countParam;



    public void parsOrder(String filePath) throws IOException, SAXException, ParserConfigurationException {
        Document document = getDocument(filePath);
        this.elementDoc = document.getDocumentElement();
        this.strSend = "";
        this.countParam = 0;
        pars(this.elementDoc.getChildNodes());

    }

    private Document getDocument(String path) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(path));
        return document;
    }

    private String getData(){
        Date date = new Date();
        String res = date.toString();
        res = res.replaceAll("\\s+","_");
        res = res.replaceAll(":","_");
        return res;
    }

    private void saveXML(Document document, String path) throws TransformerException, FileNotFoundException {
        Transformer transformer = null;
        Transformer tr = TransformerFactory.newInstance().newTransformer();
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        tr.setOutputProperty(OutputKeys.METHOD, "xml");
        tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        //tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
        tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        tr.transform(new DOMSource(document), new StreamResult(new FileOutputStream(path)));
    }

    public String createOrderFinishedBook(String title, String author, String count, String path) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        String result = "";
        Document document = getDocument(path);
        document = orderFilling(document,title,author,count);
        result = "D:\\Java\\PractickJava\\BookkeepingSystem\\src\\main\\resources\\static\\ordersBooksSystems\\newOrderBook"+title+"_"+getData()+".xml";
        saveXML(document,result);
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


    public void addBookToDeliveryList(String title, String author, String genry, String quantity, String price, String path) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        Document document = getDocument(path);

        Element root = document.getDocumentElement();

        Element newBook = document.createElement("book");

        newBook.appendChild(createBookParam("title",title,document));
        newBook.appendChild(createBookParam("author",author,document));
        newBook.appendChild(createBookParam("genry",genry,document));
        newBook.appendChild(createBookParam("quantity",quantity,document));
        newBook.appendChild(createBookParam("price",price,document));

        root.appendChild(newBook);

        saveXML(document,path);

    }

    private Element createBookParam(String name, String value, Document doc){
        Element el = doc.createElement(name);
        el.appendChild(doc.createTextNode(value));
        return el;
    }
}