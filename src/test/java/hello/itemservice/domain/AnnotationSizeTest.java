package hello.itemservice.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class AnnotationSizeTest {

    private static Validator validator;

    @BeforeEach
    void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void allTooShort() {
        AnnotationSize annotationSize = new AnnotationSize();
        annotationSize.setStr("1");

        Set<ConstraintViolation<AnnotationSize>> violations = validator.validate(annotationSize);
        for (ConstraintViolation<AnnotationSize> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getConstraintDescriptor() = " + violation.getConstraintDescriptor());
        }

        assertThat(violations.size()).isEqualTo(3);
        assertThat(violations).extracting("message").
                contains("크기가 2에서 5 사이여야 합니다",
                        "크기가 3에서 6 사이여야 합니다",
                        "크기가 3에서 7 사이여야 합니다");
    }

    @Test
    void strTooShort() {
        AnnotationSize annotationSize = new AnnotationSize();
        annotationSize.setStr("1");

        List<String> list = annotationSize.getList();
        for (int i = 0; i < 3; i++) {
            list.add(Integer.toString(i));
        }

        Map<Integer, String> map = annotationSize.getMap();
        for (int i = 0; i < 3; i++) {
            map.put(i, Integer.toString(i));
        }

        Set<ConstraintViolation<AnnotationSize>> violations = validator.validate(annotationSize);
        for (ConstraintViolation<AnnotationSize> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getConstraintDescriptor() = " + violation.getConstraintDescriptor());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("크기가 2에서 5 사이여야 합니다");
    }

    @Test
    void listTooShort() {
        AnnotationSize annotationSize = new AnnotationSize();
        annotationSize.setStr("123");

        Map<Integer, String> map = annotationSize.getMap();
        for (int i = 0; i < 3; i++) {
            map.put(i, Integer.toString(i));
        }

        Set<ConstraintViolation<AnnotationSize>> violations = validator.validate(annotationSize);
        for (ConstraintViolation<AnnotationSize> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getConstraintDescriptor() = " + violation.getConstraintDescriptor());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("크기가 3에서 6 사이여야 합니다");
    }

    @Test
    void mapTooShort() {
        AnnotationSize annotationSize = new AnnotationSize();
        annotationSize.setStr("123");

        List<String> list = annotationSize.getList();
        for (int i = 0; i < 3; i++) {
            list.add(Integer.toString(i));
        }

        Set<ConstraintViolation<AnnotationSize>> violations = validator.validate(annotationSize);
        for (ConstraintViolation<AnnotationSize> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
            System.out.println("violation.getConstraintDescriptor() = " + violation.getConstraintDescriptor());
        }

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("크기가 3에서 7 사이여야 합니다");
    }

}