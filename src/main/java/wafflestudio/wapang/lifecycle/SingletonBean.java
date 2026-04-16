package wafflestudio.wapang.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    @PostConstruct
    public void init(){
        System.out.println("PrototypeBean.init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("PrototypeBean.destory");
    }
}
