package wafflestudio.wapang.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class SingletonLifeCycltTest {
    @Autowired
    SingletonBean singletonBean1;
    @Autowired
    SingletonBean singletonBean2;
    @Autowired
    PrototypeBean prototypeBean1;
    @Autowired
    PrototypeBean prototypeBean2;

    @Test
    void prototypeBeanFind() {
        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
    }

    @Test
    void singletonBeanFind() {
        assertThat(singletonBean1).isSameAs(singletonBean2);
    }
}
