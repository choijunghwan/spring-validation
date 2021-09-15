package hello.itemservice.domain;

import lombok.Data;

@Data
public class User {

    private String userName;

    private String password;

    private int age;

    private String email;
}
