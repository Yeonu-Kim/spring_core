package wafflestudio.wapang.lifecycle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SingletonWithPrototypeTest {
    @Autowired
    CounterStateBean counterStateBean1;
    @Autowired
    CounterStateBean counterStateBean2;
    @Autowired
    SingletonCounterBean singletonCounterBean;

    @Test
    void useOnlyPrototypeBean() {
        counterStateBean1.addCount();
        Assertions.assertThat(counterStateBean1.getCount()).isEqualTo(1);

        counterStateBean2.addCount();
        Assertions.assertThat(counterStateBean2.getCount()).isEqualTo(1);
    }

    @Test
    void usePrototypeBeanInSingleton() {
        int counter;
        counter = singletonCounterBean.logic();
        counter = singletonCounterBean.logic();
        Assertions.assertThat(counter).isEqualTo(1);
    }
}
