package task.adamborowski.Luhn.algorithm.app.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import task.adamborowski.Luhn.algorithm.app.domain.StringOfNumbers;

@Data
public class CheckNumbers {

    @NotNull
    private String stringOfNumbers;
}
