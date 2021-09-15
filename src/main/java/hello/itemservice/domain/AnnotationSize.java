package hello.itemservice.domain;

import lombok.Data;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class AnnotationSize {

    @Size(min = 3, max = 6)
    private String str;

    @Size(min = 3, max = 6)
    private List<String> list = new ArrayList<>();

    @Size(min = 3, max = 6)
    private Map<Integer,String> map = new HashMap<>();
}
