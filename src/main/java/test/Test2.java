package test;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utils.Cal;

public class Test2 {
    public static void main(String[] args){
        //加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("./spring-aop.xml");
        //获取代理对象
        Cal cal= (Cal) applicationContext.getBean("calImpl");
        cal.add(1,1);
        cal.sub(2,1);
        cal.mul(2,3);
        cal.div(6,2);
        //cal.div(6,0);
    }
}
