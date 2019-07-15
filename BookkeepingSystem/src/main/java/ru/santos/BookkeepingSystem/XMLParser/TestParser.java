package ru.santos.BookkeepingSystem.XMLParser;

import org.xml.sax.SAXException;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class TestParser {
    public static void main(String[] args) {
        Parser parser = new Parser();
        try {
            parser.parsOrder("D:\\Java\\PractickJava\\SweaterLearnSpringBoot\\src\\main\\resources\\static\\order.xml");
            ArrayList<Book> list = parser.getListBook();
            for (int i = 0; i < list.size(); i++) {
                System.out.println("Книга " + i);
                System.out.println("Название " + list.get(i).getTitle());
                System.out.println("Актор " + list.get(i).getAuthor());
                System.out.println("Жанр " + list.get(i).getGenre());
                System.out.println("Количество " + list.get(i).getCount());
                System.out.println("Цена " + list.get(i).getPrice());
                System.out.println("");
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
