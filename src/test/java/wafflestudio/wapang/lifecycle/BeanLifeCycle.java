package wafflestudio.wapang.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanLifeCycle {
    @Autowired
    NetworkCient networkCient;

    @Test
    public void lifeCycleTest() {
        networkCient.disconnect();
    }
}
