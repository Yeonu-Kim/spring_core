package wafflestudio.wapang.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean {
    @PostConstruct
    public void init(){
        System.out.println("PrototypeBean.init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("PrototypeBean.destory");
    }
}
