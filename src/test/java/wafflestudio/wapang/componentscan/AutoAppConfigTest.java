package wafflestudio.wapang.componentscan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import wafflestudio.wapang.config.AutoAppConfig;
import wafflestudio.wapang.service.MemberService;

public class AutoAppConfigTest {
    @Test
    @DisplayName("컴포넌트를 스캔해서 빈으로 등록한다.")
    void setBeanByComponentScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
