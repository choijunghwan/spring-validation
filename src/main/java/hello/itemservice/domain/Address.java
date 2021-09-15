package hello.itemservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Address {

    @NotBlank // null, "", " " 을 체크
    private String city;

    @NotEmpty // null, "" 을 체크
    private String street;

    @NotNull  // null 을 체크
    private String zipcode;

}
