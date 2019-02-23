package com.wenyb.springboot.rabbitmq.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wenyabing
 * @Date 2019/2/22 21:45
 */
@Configuration
public class MyRabbitmqConfig {
    /**
     * 自定义消息转化器（转为json格式）
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
