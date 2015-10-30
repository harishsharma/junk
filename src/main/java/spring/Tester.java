package spring;

import javax.inject.Inject;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Tester {

    @Inject
    private TestSpring spring;

    // @Autowired
    // public Tester(final TestSpring spring) {
    // this.spring = spring;
    // }

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
