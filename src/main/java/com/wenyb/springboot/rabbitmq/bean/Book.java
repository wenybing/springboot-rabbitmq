package com.wenyb.springboot.rabbitmq.bean;

import lombok.Data;

/**
 * @Author wenyabing
 * @Date 2019/2/22 21:54
 */
@Data
public class Book {
    private String name;
    private String author;

    public Book() {
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
}
