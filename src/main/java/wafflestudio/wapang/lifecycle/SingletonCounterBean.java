package wafflestudio.wapang.lifecycle;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SingletonCounterBean {
    private final ObjectProvider<CounterStateBean> counterStateBeanProvider;

    public int logic() {
        CounterStateBean counterStateBean = counterStateBeanProvider.getObject();
        counterStateBean.addCount();
        return counterStateBean.getCount();
    }
}
