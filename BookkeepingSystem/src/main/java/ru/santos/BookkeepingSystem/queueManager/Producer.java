package ru.santos.BookkeepingSystem.queueManager;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.XMLParser.Parser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingKey;

    @Value("${rabbitmq.queue}")
    private String queue;

    @Bean
    public Queue queue(){
        return new Queue(queue, false);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding binding(Queue queue,TopicExchange topicExchange){
        return  BindingBuilder.bind(queue).to(topicExchange).with(routingKey);
    }
    private Parser parser = new Parser();
    static int i = 1;

    @Scheduled(fixedDelay =10000)
    public void produce(){
        i++;
        try {
            parser.parsOrder("D:\\Java\\PractickJava\\SweaterLearnSpringBoot\\src\\main\\resources\\static\\order.xml");
            ArrayList<Book> list = parser.getListBook();
            rabbitTemplate.convertAndSend(exchange,routingKey,"asdfasdfasdfasdfasdfasdf");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }
}
