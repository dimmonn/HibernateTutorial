package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContextHolder {
    private static final ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:/spring.xml");

    public static <T> T getBean(String bean) {
        return (T) appContext.getBean(bean);
    }
}