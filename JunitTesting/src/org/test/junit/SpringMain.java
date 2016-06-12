package org.test.junit;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringMain {
  public static void main(String[] args) {
          ApplicationContext context = 
                 new ClassPathXmlApplicationContext("Bean.xml");

          HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

          System.out.println(obj.getMessage());
       }
}
