package wafflestudio.wapang.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(
        basePackages = "wafflestudio.wapang",
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes=Configuration.class)
)
@Import({DiscountPolicyConfig.class, LifeCycleConfig.class})
public class AppConfig {
    // 알아서 컴포넌트들을 찾아주므로 그냥 비워두면 됨.
}
