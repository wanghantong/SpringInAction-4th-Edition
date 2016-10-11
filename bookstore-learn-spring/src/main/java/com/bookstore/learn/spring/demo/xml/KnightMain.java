package com.bookstore.learn.spring.demo.xml;

import org.springframework.context.support.
                   ClassPathXmlApplicationContext;

public class KnightMain {

  public static void main(String[] args) throws Exception {
    ClassPathXmlApplicationContext context = 
        new ClassPathXmlApplicationContext(
            "spring/knight.xml");
    Knight knight = context.getBean("knight",Knight.class);
    knight.embarkOnQuest();
    context.close();
  }

}
