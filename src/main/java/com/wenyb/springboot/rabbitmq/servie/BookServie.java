package com.wenyb.springboot.rabbitmq.servie;

import com.wenyb.springboot.rabbitmq.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Author wenyabing
 * @Date 2019/2/22 22:20
 */
@Service
public class BookServie {
    /**
     * 监听队列消息
     */
    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book) {
        System.out.println(book);
    }

    /**
     * 获取消息
     */
    @RabbitListener(queues = "gulixueyuan.news")
    public void getMessage(Message message) {
        //消息体
        System.out.println(message.getBody());
        //消息头
        System.out.println(message.getMessageProperties());
    }
}
