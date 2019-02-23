package com.wenyb.springboot.rabbitmq;

import com.wenyb.springboot.rabbitmq.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * AmqpAdmin:创建、删除Queue、Exchange、Binding
     */
    @Autowired
    private AmqpAdmin amqpAdmin;

    /**
     * 创建、删除queue、exchange、binding
     */
    @Test
    public void testAmqpAdmin() {
        //创建Exchange
//        amqpAdmin.declareExchange(new DirectExchange("AmqdAdmin.exchange"));
        //删除Exchange
//        amqpAdmin.deleteExchange("AmqdAdmin.exchange");
        //创建队列
//        amqpAdmin.declareQueue(new Queue("AmqdAdmin.queue"));
        //创建binding
        amqpAdmin.declareBinding(new Binding("AmqdAdmin.queue", Binding.DestinationType.QUEUE, "AmqdAdmin.exchange", "AmqdAdmin.routingKey", null));
    }

    @Test
    public void sendMsg() {
        String msg = "hello world!";
        rabbitTemplate.convertAndSend("AmqdAdmin.exchange", "AmqdAdmin.routingKey", msg);
    }

    @Test
    public void contextLoads() {
    }

    /**
     * 单播发送消息
     */
    @Test
    public void sendMessage() {
        String exchange = "exchange.direct";
        String routingKey = "atguigu.news";
        Map<String, Object> message = new HashMap<>();
        message.put("message", "这是一个单播消息");
        message.put("data", Arrays.asList(123, "abc", false));
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

    /**
     * 接受消息
     */
    @Test
    public void getMessage() {
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播发送消息
     */
    @Test
    public void broadcastSendMessage() {
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("红楼梦", "曹雪芹"));
    }

}
