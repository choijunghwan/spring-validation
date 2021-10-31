package hello.itemservice.domain.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@ToString
public class Custom {

    private String name;
    private Integer age;
    private LocalDateTime time;
    private Boolean check;
    private List<String> jobs;
    private Gender gender;
}
