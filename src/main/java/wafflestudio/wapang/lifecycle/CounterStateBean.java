package wafflestudio.wapang.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CounterStateBean {
    private int count = 0;

    public void addCount(){
        count++;
    }

    public int getCount(){
        return count;
    }

    @PostConstruct
    public void init(){
        System.out.println("PrototypeBean.init" + this);
    }

    @PreDestroy
    public void destory(){
        System.out.println("PrototypeBean.destory");
    }
}
