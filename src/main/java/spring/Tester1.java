package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester1 {

    @Autowired
    private TestSpring spring;

    public String seyHello() {
        return spring.getStr();
    }

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/context.xml");
        Tester test = ctx.getBean(Tester.class);
        System.out.println(test.seyHello());
        ctx.stop();
        ctx.close();
    }
}
