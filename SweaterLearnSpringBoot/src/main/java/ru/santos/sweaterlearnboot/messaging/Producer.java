
package ru.santos.sweaterlearnboot.messaging;

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

    static int i = 1;

    @Scheduled(fixedDelay =10000)
    public void produce(){
        i++;
        System.out.println("Counter : "+i);
        rabbitTemplate.convertAndSend(exchange,routingKey,"Counter : "+i);
    }
}
