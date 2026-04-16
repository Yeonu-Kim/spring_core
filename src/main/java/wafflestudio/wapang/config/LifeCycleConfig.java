package wafflestudio.wapang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wafflestudio.wapang.lifecycle.NetworkCient;

@Configuration
public class LifeCycleConfig {
    @Bean
    public NetworkCient networkCient() {
        NetworkCient networkCient = new NetworkCient();
        networkCient.setUrl("http://hello-spring.dev");
        return networkCient;
    }
}
