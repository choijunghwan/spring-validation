package hello.itemservice.domain;

import hello.itemservice.domain.validation.Enum;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Member {

    @NotBlank
    private String name;

    @Valid
    private Phone phone;

    @NotNull
    private Role role;

    @Enum(enumClass = Role.class, ignoreCase = true)
    private String roleType;

}
