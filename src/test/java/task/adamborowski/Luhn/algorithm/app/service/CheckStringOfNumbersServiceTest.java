package task.adamborowski.Luhn.algorithm.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import task.adamborowski.Luhn.algorithm.app.dto.CheckNumbers;
import static org.hamcrest.MatcherAssert.assertThat;


class CheckStringOfNumbersServiceTest {
    @Autowired
    CheckStringOfNumbersService checkStringOfNumbersService;
    @Autowired
    CheckNumbers checkNumbers;

    // tests to be completed
    @Test
    void isStringOfNumbersCorrect() {
    }

    @ParameterizedTest
    @ValueSource(strings = {"30437796680062","222324245456","2720994027358620"})
    void checkIfIsPossibleToAssignAString(String checkNumbers) {
        Assertions.assertTrue(!checkNumbers.isEmpty());
    }}

