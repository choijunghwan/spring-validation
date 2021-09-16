package hello.itemservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class Phone {

    @NotBlank
    private String phone1;

    @NotBlank
    @Length(min = 3, max = 4)
    private String phone2;

    @NotBlank
    @Length(min = 3, max = 4)
    private String phone3;
}
