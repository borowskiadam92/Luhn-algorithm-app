package task.adamborowski.Luhn.algorithm.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.adamborowski.Luhn.algorithm.app.dto.CheckNumbers;
import task.adamborowski.Luhn.algorithm.app.service.CheckStringOfNumbersService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/check")
public class CheckStringOfNumbersController {
    private CheckStringOfNumbersService checkStringOfNumbersService;

    public CheckStringOfNumbersController(CheckStringOfNumbersService checkStringOfNumbersService) {
        this.checkStringOfNumbersService = checkStringOfNumbersService;
    }

    @PostMapping
    public ResponseEntity<String> checkNumbers(@RequestBody @Valid CheckNumbers checkNumbers) {
        boolean stringOfNumbersCorrect = checkStringOfNumbersService.isStringOfNumbersCorrect(checkNumbers);
        if (stringOfNumbersCorrect == true) {
            String numbersAreCorrect = "Given String is correct according to Luhn algorithm";
            return new ResponseEntity<>(numbersAreCorrect, HttpStatus.OK);
        } else {
            String numberAreNotCorrect = "Given String is not correct according to Luhn algorithm";
            return new ResponseEntity<String>(numberAreNotCorrect, HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/checkDigit")
    public ResponseEntity<String> findCheckDigit(@RequestBody @Valid CheckNumbers checkNumbers) {
        String checkDigitForGivenNumbers = checkStringOfNumbersService.findCheckDigitForGivenNumbers(checkNumbers);
        return new ResponseEntity<>(checkDigitForGivenNumbers, HttpStatus.OK);

    }

}
