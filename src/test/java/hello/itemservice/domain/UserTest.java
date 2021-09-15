package hello.itemservice.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.time.LocalDateTime;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    private static Validator validator;

    @BeforeEach
    void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void passwordTooShort() {
        User user = new User(
                "UserA",
                "aa",
                "abc@gmail.com",
                true,
                LocalDateTime.now(),
                LocalDateTime.MAX);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getMessageTemplate() = " + violation.getMessageTemplate());
            System.out.println("violation.getRootBean() = " + violation.getRootBean());
            System.out.println("violation.getPropertyPath() = " + violation.getPropertyPath());
            System.out.println("violation.getRootBeanClass() = " + violation.getRootBeanClass());
            System.out.println("violation.getExecutableReturnValue() = " + violation.getExecutableReturnValue());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("길이가 3에서 8 사이여야 합니다");
    }

    @Test
    void passwordIsUpper() {
        User user = new User(
                "UserA",
                "AAA",
                "abc@gmail.com",
                true,
                LocalDateTime.now(),
                LocalDateTime.MAX);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getMessageTemplate() = " + violation.getMessageTemplate());
            System.out.println("violation.getRootBean() = " + violation.getRootBean());
            System.out.println("violation.getPropertyPath() = " + violation.getPropertyPath());
            System.out.println("violation.getRootBeanClass() = " + violation.getRootBeanClass());
            System.out.println("violation.getExecutableReturnValue() = " + violation.getExecutableReturnValue());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("\"[a-z0-9!@]+\"와 일치해야 합니다");
    }


    @Test
    void passwordIsNotMatch() {
        User user = new User(
                "UserA",
                "a$",
                "abc@gmail.com",
                true,
                LocalDateTime.now(),
                LocalDateTime.MAX);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getMessageTemplate() = " + violation.getMessageTemplate());
            System.out.println("violation.getRootBean() = " + violation.getRootBean());
            System.out.println("violation.getPropertyPath() = " + violation.getPropertyPath());
            System.out.println("violation.getRootBeanClass() = " + violation.getRootBeanClass());
            System.out.println("violation.getExecutableReturnValue() = " + violation.getExecutableReturnValue());
        }

        assertThat(violations.size()).isEqualTo(2);
        assertThat(violations).extracting("message").contains("길이가 3에서 8 사이여야 합니다", "\"[a-z0-9!@]+\"와 일치해야 합니다");
    }

    @Test
    void emailIsValid() {
        User user = new User(
                "UserA",
                "aa12",
                "abc@gmail.com",
                true,
                LocalDateTime.now(),
                LocalDateTime.MAX);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getMessageTemplate() = " + violation.getMessageTemplate());
            System.out.println("violation.getRootBean() = " + violation.getRootBean());
            System.out.println("violation.getPropertyPath() = " + violation.getPropertyPath());
            System.out.println("violation.getRootBeanClass() = " + violation.getRootBeanClass());
            System.out.println("violation.getExecutableReturnValue() = " + violation.getExecutableReturnValue());
        }

        assertThat(violations.size()).isEqualTo(0);
    }

    /**
     * @Email 은 Null을 허용
     */
    @Test
    void emailIsNull() {
        User user = new User(
                "UserA",
                "aa12",
                null,
                true,
                LocalDateTime.now(),
                LocalDateTime.MAX);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getMessageTemplate() = " + violation.getMessageTemplate());
            System.out.println("violation.getRootBean() = " + violation.getRootBean());
            System.out.println("violation.getPropertyPath() = " + violation.getPropertyPath());
            System.out.println("violation.getRootBeanClass() = " + violation.getRootBeanClass());
            System.out.println("violation.getExecutableReturnValue() = " + violation.getExecutableReturnValue());
        }

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    void emailIsNotContainCharacter() {
        User user = new User(
                "UserA",
                "aa12",
                "abc.gmail.com",
                true,
                LocalDateTime.now(),
                LocalDateTime.MAX);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getMessageTemplate() = " + violation.getMessageTemplate());
            System.out.println("violation.getRootBean() = " + violation.getRootBean());
            System.out.println("violation.getPropertyPath() = " + violation.getPropertyPath());
            System.out.println("violation.getRootBeanClass() = " + violation.getRootBeanClass());
            System.out.println("violation.getExecutableReturnValue() = " + violation.getExecutableReturnValue());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("올바른 형식의 이메일 주소여야 합니다");
    }

    @Test
    void visitIsFalse() {
        User user = new User(
                "UserA",
                "aa12",
                "abc@gmail.com",
                false,
                LocalDateTime.now(),
                LocalDateTime.MAX);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getMessageTemplate() = " + violation.getMessageTemplate());
            System.out.println("violation.getRootBean() = " + violation.getRootBean());
            System.out.println("violation.getPropertyPath() = " + violation.getPropertyPath());
            System.out.println("violation.getRootBeanClass() = " + violation.getRootBeanClass());
            System.out.println("violation.getExecutableReturnValue() = " + violation.getExecutableReturnValue());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("true여야 합니다");
    }

    @Test
    void visitIsNull() {
        User user = new User(
                "UserA",
                "aa12",
                "abc@gmail.com",
                null,
                LocalDateTime.now(),
                LocalDateTime.MAX);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getMessageTemplate() = " + violation.getMessageTemplate());
            System.out.println("violation.getRootBean() = " + violation.getRootBean());
            System.out.println("violation.getPropertyPath() = " + violation.getPropertyPath());
            System.out.println("violation.getRootBeanClass() = " + violation.getRootBeanClass());
            System.out.println("violation.getExecutableReturnValue() = " + violation.getExecutableReturnValue());
        }

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    void createDateIsPast() {
        User user = new User(
                "UserA",
                "aa12",
                "abc@gmail.com",
                true,
                LocalDateTime.MAX,
                LocalDateTime.MAX);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getMessageTemplate() = " + violation.getMessageTemplate());
            System.out.println("violation.getRootBean() = " + violation.getRootBean());
            System.out.println("violation.getPropertyPath() = " + violation.getPropertyPath());
            System.out.println("violation.getRootBeanClass() = " + violation.getRootBeanClass());
            System.out.println("violation.getExecutableReturnValue() = " + violation.getExecutableReturnValue());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("과거 또는 현재의 날짜여야 합니다");
    }

    @Test
    void lastModifiedDateIsPast() {
        User user = new User(
                "UserA",
                "aa12",
                "abc@gmail.com",
                true,
                LocalDateTime.now(),
                LocalDateTime.MIN);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getMessageTemplate() = " + violation.getMessageTemplate());
            System.out.println("violation.getRootBean() = " + violation.getRootBean());
            System.out.println("violation.getPropertyPath() = " + violation.getPropertyPath());
            System.out.println("violation.getRootBeanClass() = " + violation.getRootBeanClass());
            System.out.println("violation.getExecutableReturnValue() = " + violation.getExecutableReturnValue());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("미래 날짜여야 합니다");
    }

    @Test
    void lastModifiedDateIsNow() {
        User user = new User(
                "UserA",
                "aa12",
                "abc@gmail.com",
                true,
                LocalDateTime.now(),
                LocalDateTime.now());

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getMessageTemplate() = " + violation.getMessageTemplate());
            System.out.println("violation.getRootBean() = " + violation.getRootBean());
            System.out.println("violation.getPropertyPath() = " + violation.getPropertyPath());
            System.out.println("violation.getRootBeanClass() = " + violation.getRootBeanClass());
            System.out.println("violation.getExecutableReturnValue() = " + violation.getExecutableReturnValue());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("미래 날짜여야 합니다");
    }




}