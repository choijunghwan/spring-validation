package hello.itemservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class AnnotationNumber {

    @Min(2)
    @Max(5)    // @Range(min = 2, max=5) 도 같은 역할을 한다.
    private int minmax;

    @DecimalMin(value = "2")  // 지정된 최소값보다 큰지 확인, 기본값 inclusive=true이면 같은경우도 체크(>=) false이면(>)
    private int decimalMin;

    @DecimalMax(value = "5", inclusive = false)
    private int decimalMax;

    @Digits(integer = 3, fraction = 0)  // integer = 허용 가능한 정수 자릿수, fraction = 허용 가능한 소숫점 이하 자릿수
    private int digit;

    @Positive
    private int positive;

    @NegativeOrZero
    private int negativeOrZero;

}
