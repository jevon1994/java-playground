package cn.leon;

import cn.leon.contenxt.SelfApplicationContext;
import cn.leon.contenxt.SelfClassPathXmlApplicationContext;
import cn.leon.service.SelfService;
import cn.leon.service.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSelfIOC(){
        SelfApplicationContext context = new SelfClassPathXmlApplicationContext("selfApplication.xml");

        SelfService selfService = (SelfService) context.getBean("SelfService");
        selfService.showHelloWorld();

        User user = (User) context.getBean("user");
        user.showUser();

    }

}
