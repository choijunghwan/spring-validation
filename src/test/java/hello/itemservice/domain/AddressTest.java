package hello.itemservice.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class AddressTest {

    private static Validator validator;

    @BeforeEach
    void setUpValidator() {
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
            System.out.println("violation.getConstraintDescriptor() = " + violation.getConstraintDescriptor());
        }

        assertThat(1).isEqualTo(violations.size());
        assertThat("공백일 수 없습니다").isEqualTo(violations.iterator().next().getMessage());
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

        assertThat(1).isEqualTo(violations.size());
        assertThat("공백일 수 없습니다").isEqualTo(violations.iterator().next().getMessage());
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

        assertThat(1).isEqualTo(violations.size());
        assertThat("공백일 수 없습니다").isEqualTo(violations.iterator().next().getMessage());
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

        assertThat(0).isEqualTo(violations.size());
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

        assertThat(1).isEqualTo(violations.size());
        assertThat("비어 있을 수 없습니다").isEqualTo(violations.iterator().next().getMessage());
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

        assertThat(1).isEqualTo(violations.size());
        assertThat("비어 있을 수 없습니다").isEqualTo(violations.iterator().next().getMessage());
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

        assertThat(0).isEqualTo(violations.size());
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

        assertThat(1).isEqualTo(violations.size());
        assertThat("널이어서는 안됩니다").isEqualTo(violations.iterator().next().getMessage());
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

        assertThat(0).isEqualTo(violations.size());
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

        assertThat(0).isEqualTo(violations.size());
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

        assertThat(0).isEqualTo(violations.size());
    }

}