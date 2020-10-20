package task.adamborowski.Luhn.algorithm.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StringOfNumbers {

    @NonNull
    private String stringOfNumbers;
}
