package hello.itemservice.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class AnnotationNumberTest {

    private static Validator validator;

    @BeforeEach
    void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void minmaxTooLow() {
        AnnotationNumber annotationNumber = new AnnotationNumber(1, 3, 3, 12, 10, -5);

        Set<ConstraintViolation<AnnotationNumber>> violations = validator.validate(annotationNumber);
        for (ConstraintViolation<AnnotationNumber> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("2 이상이어야 합니다");
    }

    @Test
    void minmaxTooHigh() {
        AnnotationNumber annotationNumber = new AnnotationNumber(6, 3, 3, 12, 10, -5);

        Set<ConstraintViolation<AnnotationNumber>> violations = validator.validate(annotationNumber);
        for (ConstraintViolation<AnnotationNumber> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("5 이하여야 합니다");
    }

    @Test
    void minmaxIsValid() {
        AnnotationNumber annotationNumber = new AnnotationNumber(4, 3, 3, 12, 10, -5);

        Set<ConstraintViolation<AnnotationNumber>> violations = validator.validate(annotationNumber);
        for (ConstraintViolation<AnnotationNumber> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
        }

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    void decimalMinTooLow() {
        AnnotationNumber annotationNumber = new AnnotationNumber(4, 1, 3, 12, 10, -5);

        Set<ConstraintViolation<AnnotationNumber>> violations = validator.validate(annotationNumber);
        for (ConstraintViolation<AnnotationNumber> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("다음 값 이상이어야 합니다 2");
    }

    @Test
    void decimalMinIsValid() {
        AnnotationNumber annotationNumber = new AnnotationNumber(4, 2, 3, 12, 10, -5);

        Set<ConstraintViolation<AnnotationNumber>> violations = validator.validate(annotationNumber);
        for (ConstraintViolation<AnnotationNumber> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
        }

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    void decimalMaxTooHigh() {
        AnnotationNumber annotationNumber = new AnnotationNumber(4, 2, 5, 12, 10, -5);

        Set<ConstraintViolation<AnnotationNumber>> violations = validator.validate(annotationNumber);
        for (ConstraintViolation<AnnotationNumber> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("다음 값 이하여야 합니다5");
    }

    @Test
    void digitTooLarge() {
        AnnotationNumber annotationNumber = new AnnotationNumber(4, 2, 4, 1234, 10, -5);

        Set<ConstraintViolation<AnnotationNumber>> violations = validator.validate(annotationNumber);
        for (ConstraintViolation<AnnotationNumber> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("숫자 값이 한계를 초과합니다(<3 자리>.<0 자리> 예상)");
    }

    @Test
    void digitIsValid() {
        AnnotationNumber annotationNumber = new AnnotationNumber(4, 2, 4, 123, 10, -5);

        Set<ConstraintViolation<AnnotationNumber>> violations = validator.validate(annotationNumber);
        for (ConstraintViolation<AnnotationNumber> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
        }

        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    void positiveIsZero() {
        AnnotationNumber annotationNumber = new AnnotationNumber(4, 2, 4, 123, 0, -5);

        Set<ConstraintViolation<AnnotationNumber>> violations = validator.validate(annotationNumber);
        for (ConstraintViolation<AnnotationNumber> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("0보다 커야 합니다");
    }

    @Test
    void negativeIsZero() {
        AnnotationNumber annotationNumber = new AnnotationNumber(4, 2, 4, 123, 2, 0);

        Set<ConstraintViolation<AnnotationNumber>> violations = validator.validate(annotationNumber);
        for (ConstraintViolation<AnnotationNumber> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
        }

        assertThat(violations.size()).isEqualTo(0);
    }
}