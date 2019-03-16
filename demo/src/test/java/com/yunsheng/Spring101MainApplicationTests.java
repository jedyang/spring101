package com.yunsheng;

import org.junit.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;


public class Spring101MainApplicationTests {

    private ApplicationContextRunner applicationContextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(MyAutoConfiguration.class));

    @Test
    public void testService() {
        applicationContextRunner
                .withPropertyValues("spring101.age=35")
                .withPropertyValues("spring101.name=yunsheng")
                .run(context -> {
                    assertThat(context).hasSingleBean(AbstractMyService.class);
                    assertThat(context.getBean(AbstractMyService.class).hello()).containsSequence("yunsheng:35");
                    System.out.println(context.getBean(MyStarterServiceV1.class).hello());
                });
    }

    @Test
    public void testConditionalOnProperty() {
        applicationContextRunner
                .run(context -> {
                    assertThat(context).hasSingleBean(AbstractMyService.class);
                    assertThat(context.getBean(AbstractMyService.class).hello()).containsSequence("V1 Hello");
                    System.out.println(context.getBean(AbstractMyService.class).hello());
                });
        applicationContextRunner
                .withPropertyValues("spring101.version=v1")
                .run(context -> {
                    assertThat(context).hasSingleBean(AbstractMyService.class);
                    assertThat(context.getBean(AbstractMyService.class).hello()).containsSequence("V1 Hello");
                    System.out.println(context.getBean(AbstractMyService.class).hello());
                });
        applicationContextRunner
                .withPropertyValues("spring101.version=v2")
                .run(context -> {
                    assertThat(context).hasSingleBean(AbstractMyService.class);
                    assertThat(context.getBean(AbstractMyService.class).hello()).containsSequence("V2 Hello");
                    System.out.println(context.getBean(AbstractMyService.class).hello());
                });

    }

    @Test
    public void testConditionalOnMissingBean() {
        applicationContextRunner
                .withUserConfiguration(MyServiceConfig.class)
                .run(context -> {
                    assertThat(context).hasSingleBean(MyStarterServiceV1.class);
                    assertThat(context.getBean(MyStarterServiceV1.class).hello()).containsSequence("V1 Hi");
                    System.out.println(context.getBean(MyStarterServiceV1.class).hello());
                });
    }

}

@Configuration
class MyServiceConfig {
    @Bean
    MyStarterServiceV1 getService() {
        return new MyStarterServiceV1("Hi");
    }
}
