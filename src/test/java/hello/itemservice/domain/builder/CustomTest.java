package hello.itemservice.domain.builder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomTest {

    @Test
    public void builderTest() {
        Custom custom = Custom.builder()
                .name("Custom")
                .age(20)
                .time(LocalDateTime.now())
                .check(true)
                .jobs(Arrays.asList("직업"))
                .gender(Gender.MAN)
                .build();

        System.out.println("custom = " + custom);
        assertThat(custom.getName()).isEqualTo("Custom");
        assertThat(custom.getAge()).isEqualTo(20);
        assertThat(custom.getCheck()).isEqualTo(true);
    }

    @Test
    public void builder() {
        Custom custom = Custom.builder()
                .age(20)
                .jobs(Arrays.asList("직업"))
                .gender(Gender.MAN)
                .time(LocalDateTime.now())
                .build();

        System.out.println("custom = " + custom);
        assertThat(custom.getAge()).isEqualTo(20);
    }

}