package hello.itemservice.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    private static Validator validator;

    @BeforeEach
    void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void phoneIsNull() {

        Member member = new Member(
                "memberA",
                null,
                Role.ADMIN,
                "ADMIN");

        Set<ConstraintViolation<Member>> violations = validator.validate(member);
        for (ConstraintViolation<Member> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getMessageTemplate() = " + violation.getMessageTemplate());
            System.out.println("violation.getRootBean() = " + violation.getRootBean());
            System.out.println("violation.getPropertyPath() = " + violation.getPropertyPath());
            System.out.println("violation.getRootBeanClass() = " + violation.getRootBeanClass());
        }

    }

    @Test
    void phone1IsBlank() {
        Phone phone = new Phone(" ", "1234", "5678");

        Member member = new Member(
                "memberA",
                phone,
                Role.ADMIN,
                "ADMIN");

        Set<ConstraintViolation<Member>> violations = validator.validate(member);
        for (ConstraintViolation<Member> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getMessageTemplate() = " + violation.getMessageTemplate());
            System.out.println("violation.getRootBean() = " + violation.getRootBean());
            System.out.println("violation.getPropertyPath() = " + violation.getPropertyPath());
            System.out.println("violation.getRootBeanClass() = " + violation.getRootBeanClass());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("공백일 수 없습니다");
    }

    @Test
    void phone2TooLong() {
        Phone phone = new Phone("010", "12345", "5678");

        Member member = new Member(
                "memberA",
                phone,
                Role.ADMIN,
                "ADMIN");

        Set<ConstraintViolation<Member>> violations = validator.validate(member);
        for (ConstraintViolation<Member> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getMessageTemplate() = " + violation.getMessageTemplate());
            System.out.println("violation.getRootBean() = " + violation.getRootBean());
            System.out.println("violation.getPropertyPath() = " + violation.getPropertyPath());
            System.out.println("violation.getRootBeanClass() = " + violation.getRootBeanClass());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("길이가 3에서 4 사이여야 합니다");
    }

    @Test
    void roleIsNull() {
        Phone phone = new Phone("010", "1234", "5678");

        Member member = new Member(
                "memberA",
                phone,
                null,
                "ADMIN");

        Set<ConstraintViolation<Member>> violations = validator.validate(member);
        for (ConstraintViolation<Member> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getMessageTemplate() = " + violation.getMessageTemplate());
            System.out.println("violation.getRootBean() = " + violation.getRootBean());
            System.out.println("violation.getPropertyPath() = " + violation.getPropertyPath());
            System.out.println("violation.getRootBeanClass() = " + violation.getRootBeanClass());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("널이어서는 안됩니다");

    }

    @Test
    void roleTypeNotValid() {
        Phone phone = new Phone("010", "1234", "5678");

        Member member = new Member(
                "memberA",
                phone,
                Role.ADMIN,
                "VIP");

        Set<ConstraintViolation<Member>> violations = validator.validate(member);
        for (ConstraintViolation<Member> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getMessageTemplate() = " + violation.getMessageTemplate());
            System.out.println("violation.getRootBean() = " + violation.getRootBean());
            System.out.println("violation.getPropertyPath() = " + violation.getPropertyPath());
            System.out.println("violation.getRootBeanClass() = " + violation.getRootBeanClass());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("Enum에 없는 값입니다.");

    }
}