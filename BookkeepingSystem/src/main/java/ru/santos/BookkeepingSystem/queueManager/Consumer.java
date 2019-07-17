package ru.santos.BookkeepingSystem.queueManager;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.santos.BookkeepingSystem.XMLParser.ParserToObject;
import ru.santos.BookkeepingSystem.service.ServiceDB;


@Component
public class Consumer {
    @Autowired
    private ParserToObject parserToObject;

    @Autowired
    private ServiceDB serviceDB;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consume(String msg) {
        parserToObject.dataProcessing(msg);
        serviceDB.addToDB(parserToObject.getListBook());
    }
}
