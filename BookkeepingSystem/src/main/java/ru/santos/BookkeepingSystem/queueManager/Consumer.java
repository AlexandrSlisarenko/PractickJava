package ru.santos.BookkeepingSystem.queueManager;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.ModelData.Order.Order;
import ru.santos.BookkeepingSystem.XMLParser.TransportData;

import java.util.ArrayList;

@Component
public class Consumer {
    private Order order;
    private TransportData transportData;
    public ArrayList<Book> getListBook(){
        return this.order.getBooks();
    }

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consume(String msg/*ArrayList<Book> list*/){
        System.out.println(msg);
        /*for (int i = 0; i < list.size(); i++) {
            System.out.println("Книга " + i);
            System.out.println("Название " + list.get(i).getTitle());
            System.out.println("Актор " + list.get(i).getAuthor());
            System.out.println("Жанр " + list.get(i).getGenre());
            System.out.println("Количество " + list.get(i).getCount());
            System.out.println("Цена " + list.get(i).getPrice());
            System.out.println("");
        }

         if(((Element) nodeList.item(i).getParentNode()).getTagName() !="book")
                fillingOrder(nodeList.item(i).getParentNode().getNodeName(),nodeList.item(i).getTextContent().trim());
                if(this.transportData.isFilled()){
                    this.order.addBoook(this.transportData.getTitle(),this.transportData.getAuthor()
                            ,this.transportData.getGenre(),this.transportData.getCount(),this.transportData.getPrice());
                    this.transportData.clearTransport();


                    private void fillingOrder(String key,String value){
        switch (key){
            case "title":
                this.transportData.setTitle(value);
                break;
            case "author":
                this.transportData.setAuthor(value);
                break;
            case "count":
                this.transportData.setCount(value);
                break;
            case "genre":
                this.transportData.setGenre(value);
                break;
            case"price":
                this.transportData.setPrice(value);
        }
    }
        */

    }
}
