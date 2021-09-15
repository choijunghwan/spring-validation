package hello.itemservice.domain;

import org.assertj.core.api.Assertions;
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

        assertThat(1).isEqualTo(violations.size());
        assertThat("크기가 3에서 6 사이여야 합니다").isEqualTo(violations.iterator().next().getMessage());
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

        assertThat(1).isEqualTo(violations.size());
        assertThat("크기가 3에서 6 사이여야 합니다").isEqualTo(violations.iterator().next().getMessage());
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

        assertThat(1).isEqualTo(violations.size());
        assertThat("크기가 3에서 6 사이여야 합니다").isEqualTo(violations.iterator().next().getMessage());
    }

}