package wafflestudio.wapang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import wafflestudio.wapang.domain.DiscountPolicy;

import java.util.Map;

@SpringBootTest
public class BeanCheckTest {
    @Autowired
    ApplicationContext ac;

    @Test
    void findDiscountPolicyBeans() {
        Map<String, DiscountPolicy> beans = ac.getBeansOfType(DiscountPolicy.class);
        beans.forEach((name, bean) -> {
            System.out.println("name = " + name + ", bean = " + bean.getClass());
        });
    }
}
