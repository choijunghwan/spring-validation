package hello.itemservice.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Locale;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class AddressTest {

    private static Validator validator;

    /**
     * 컴퓨터 기본 설정이 한글로 되어 있어 오류메시지가 한글로 나온다.
     * 오류메시지를 다른 언어로 보고싶으면 Locale을 설정하면 된다.
     * 예를 들어 영어로 보고싶다면
     * Locale.setDefault(Locale.US);
     */
    @BeforeEach
    void setUpValidator() {
//        Locale.setDefault(Locale.US);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void cityIsNull() {
        Address address = new Address(null, "잠실", "12345");
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        for (ConstraintViolation<Address> violation : violations) {
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
    void cityIsEmpty() {
        Address address = new Address("", "잠실", "12345");
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        for (ConstraintViolation<Address> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getConstraintDescriptor() = " + violation.getConstraintDescriptor());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("공백일 수 없습니다");
    }

    @Test
    void cityIsBlank() {
        Address address = new Address(" ", "잠실", "12345");
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        for (ConstraintViolation<Address> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getConstraintDescriptor() = " + violation.getConstraintDescriptor());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("공백일 수 없습니다");
    }

    @Test
    void cityIsValid() {
        Address address = new Address("서울", "잠실", "12345");
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        for (ConstraintViolation<Address> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getConstraintDescriptor() = " + violation.getConstraintDescriptor());
        }

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    void streetIsNull() {
        Address address = new Address("서울", null, "12345");
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        for (ConstraintViolation<Address> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getConstraintDescriptor() = " + violation.getConstraintDescriptor());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("비어 있을 수 없습니다");
    }

    @Test
    void streetIsEmpty() {
        Address address = new Address("서울", "", "12345");
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        for (ConstraintViolation<Address> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getConstraintDescriptor() = " + violation.getConstraintDescriptor());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("비어 있을 수 없습니다");
    }

    @Test
    void streetIsBlank() {
        Address address = new Address("서울", " ", "12345");
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        for (ConstraintViolation<Address> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getConstraintDescriptor() = " + violation.getConstraintDescriptor());
        }

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    void zipcodeIsNull() {
        Address address = new Address("서울", "잠실", null);
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        for (ConstraintViolation<Address> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getConstraintDescriptor() = " + violation.getConstraintDescriptor());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("널이어서는 안됩니다");
    }

    @Test
    void zipcodeIsEmpty() {
        Address address = new Address("서울", "잠실", "");
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        for (ConstraintViolation<Address> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getConstraintDescriptor() = " + violation.getConstraintDescriptor());
        }

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    void zipcodeIsBlank() {
        Address address = new Address("서울", "잠실", " ");
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        for (ConstraintViolation<Address> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getConstraintDescriptor() = " + violation.getConstraintDescriptor());
        }

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    void addressIsValid() {
        Address address = new Address("서울", "잠실", "12345");
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        for (ConstraintViolation<Address> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getConstraintDescriptor() = " + violation.getConstraintDescriptor());
        }

        assertThat(violations.size()).isEqualTo(0);
    }

}