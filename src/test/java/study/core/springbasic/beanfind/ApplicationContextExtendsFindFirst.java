package study.core.springbasic.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.core.springbasic.order.service.DiscountService;
import study.core.springbasic.order.service.FixedDiscountService;
import study.core.springbasic.order.service.PercentDiscountService;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindFirst {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 둘 이상 있으면, 중복오류가 발생한다")
    void findBeanByParentTypeDuplicate() {
        // given
        // when
        // then
        assertThrows(
                NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountService.class)
        );
    }

    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
    void findBeanByParentTypeBeanName() {
        // given
        // when
        DiscountService percentDiscountService = ac.getBean("percentDiscountService", PercentDiscountService.class);
        // then
        assertThat(percentDiscountService).isInstanceOf(DiscountService.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubType() {
        // given
        // when
        DiscountService percentDiscountService = ac.getBean(PercentDiscountService.class);
        // then
        assertThat(percentDiscountService).isInstanceOf(DiscountService.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    void findAllBeanByParentType() {
        // given
        // when
        Map<String, DiscountService> beansOfType = ac.getBeansOfType(DiscountService.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
        // then
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - Object")
    void testMethod() {
        // given
        // when
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
        // then
    }

    @Configuration
    static class TestConfig {
        @Bean
        public DiscountService percentDiscountService() {
            return new PercentDiscountService();
        }

        @Bean
        public DiscountService fixedDiscountService() {
            return new FixedDiscountService();
        }
    }
}
