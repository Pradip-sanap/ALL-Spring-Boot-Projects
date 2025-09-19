package com.dev.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.dev.app.model.Book;
import com.dev.app.service.Car;
import com.dev.app.service.ProductService;

 
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
//        ApplicationContext ctx= new ClassPathXmlApplicationContext("com/dev/app/config.xml");
//        Product book = ctx.getBean(Product.class);
//        System.out.println(book);
        
//        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.dev.app.model");
//        Book b= ctx.getBean(Book.class);
//        System.out.println(b);
        
        
        AbstractApplicationContext  ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        
        Book book = ctx.getBean(Book.class);
        System.out.println(book);
        
        ProductService prod = ctx.getBean(ProductService.class);
        prod.printValues();
        
        Car car = ctx.getBean(Car.class);
        car.drive();
        
      //registering shutdown hook
//        ctx.registerShutdownHook();
    }
}
