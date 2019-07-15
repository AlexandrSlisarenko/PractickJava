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
    private Order order;
    private TransportData transportData;

    public Parser(int id) {
        this.order = new Order(id);
        transportData = new TransportData();
    }

    public ArrayList<Book> getListBook(){
        return this.order.getBooks();
    }




    public void parsOrder(String filePath) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(filePath));
        this.elementDoc = document.getDocumentElement();
        pars(this.elementDoc.getChildNodes());
    }

    private void fillingOrder(String key,String value){

    }



    private void pars(NodeList nodeList) {
        String doc = "";
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).hasChildNodes()) {

                pars(nodeList.item(i).getChildNodes());

            } else {
                doc += "   " + ((Element) nodeList.item(i).getParentNode()).getTagName().trim() + " : " + nodeList.item(i).getTextContent().trim() + "\n";

            }

        }
        System.out.println(doc);
    }

}