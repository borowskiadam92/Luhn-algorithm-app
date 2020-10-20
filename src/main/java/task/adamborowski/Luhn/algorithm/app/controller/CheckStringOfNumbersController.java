package task.adamborowski.Luhn.algorithm.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.adamborowski.Luhn.algorithm.app.domain.StringOfNumbers;
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
    public ResponseEntity<Void> checkNumbers(@RequestBody @Valid CheckNumbers checkNumbers){
        checkStringOfNumbersService.isStringOfNumbersCorrect(checkNumbers);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @PostMapping("/checkDigit")
    public ResponseEntity<String> findCheckNumber(@RequestBody @Valid CheckNumbers checkNumbers){
        String checkDigitForGivenNumbers = checkStringOfNumbersService.findCheckDigitForGivenNumbers(checkNumbers);
        return new ResponseEntity<>(checkDigitForGivenNumbers,HttpStatus.OK);

    }

}
