package hello.itemservice.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
public enum Role {
    ADMIN("관리자"),
    USER("유저"),
    GUEST("손님");

    String value;

    Role(String value) {
        this.value = value;
    }
}
