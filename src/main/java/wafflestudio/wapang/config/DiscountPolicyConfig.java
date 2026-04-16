package wafflestudio.wapang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import wafflestudio.wapang.domain.DiscountPolicy;
import wafflestudio.wapang.domain.FixDiscountPolicy;
import wafflestudio.wapang.domain.RateDiscountPolicy;

@Configuration
public class DiscountPolicyConfig {
    @Bean
    @Primary
    public DiscountPolicy fixDiscountPolicy() {
        return new FixDiscountPolicy();
    }

    @Bean
    public DiscountPolicy rateDiscountPolicy() {
        return new RateDiscountPolicy();
    }
}