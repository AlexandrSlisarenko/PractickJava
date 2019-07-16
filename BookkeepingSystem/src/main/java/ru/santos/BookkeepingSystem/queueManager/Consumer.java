package ru.santos.BookkeepingSystem.queueManager;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.ModelData.Order.Order;
import ru.santos.BookkeepingSystem.XMLParser.ParserToObject;
import ru.santos.BookkeepingSystem.XMLParser.TransportData;

import java.util.ArrayList;

@Component
public class Consumer {
    @Autowired
    private ParserToObject parserToObject;
    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consume(String msg) {
        //System.out.println(msg);
        parserToObject.dataProcessing(msg);
        ArrayList<Book> list = parserToObject.getListBook();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Книга " + i);
            System.out.println("Название " + list.get(i).getTitle());
            System.out.println("Актор " + list.get(i).getAuthor());
            System.out.println("Жанр " + list.get(i).getGenre());
            System.out.println("Количество " + list.get(i).getCount());
            System.out.println("Цена " + list.get(i).getPrice());
            System.out.println("");
        }
    }
}
