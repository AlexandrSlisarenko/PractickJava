package ru.santos.sweaterlearnboot.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consume(String msg){
        System.out.println("Consume: "+msg);
    }
}
