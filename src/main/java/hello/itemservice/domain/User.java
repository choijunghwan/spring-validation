package hello.itemservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class User {


    @NotBlank
    private String userName;

    @Length(min = 3, max = 8)
    @Pattern(regexp = "[a-z0-9!@]+")
    private String password;

    @Email
    private String email;

    @AssertTrue // true 인지 검사한다. null은 유효하다고 판단
    private Boolean isVisited;

    @PastOrPresent
    private LocalDateTime createdDate;

    @Future
    private LocalDateTime lastModifiedDate;

}
