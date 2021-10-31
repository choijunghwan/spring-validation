package hello.itemservice.domain.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@ToString
public class Custom {

    private String name;
    @Builder.Default
    private Integer age = 0;

    @Builder.Default
    private LocalDateTime time = LocalDateTime.now();

    @Builder.Default
    private Boolean check = false;

    @Singular
    private List<String> jobs;

    @Builder.Default
    private Gender gender = Gender.MAN;
}
