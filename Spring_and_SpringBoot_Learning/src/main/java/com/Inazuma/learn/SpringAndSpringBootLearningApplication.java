package com.Inazuma.learn;

//import com.Inazuma.learn.lifecycle.Employee;
//import com.Inazuma.learn.lifecycle.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication()
public class SpringAndSpringBootLearningApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringAndSpringBootLearningApplication.class, args);

		ApplicationContext a;
//		Employee bean = context.getBean(Employee.class);
//		bean.setId(44l);
//		bean.setName("PRadip");

//		Person bean1 = context.getBean(Person.class);
//		bean1.setName("Sunny");
//		bean1.setAge(24);



	}

}
