package task.adamborowski.Luhn.algorithm.app.service;

import org.springframework.stereotype.Service;
import task.adamborowski.Luhn.algorithm.app.dto.CheckNumbers;

@Service
public class CheckStringOfNumbersService {

    public boolean isStringOfNumbersCorrect(CheckNumbers stringOfNumbers) {
        boolean b = checkStringOfNumbersUsingLuhnAlgorithm(stringOfNumbers.getStringOfNumbers());
        if(b==true) {
        return true;
        }else{
            return false;
        }

    }
    public String findCheckDigitForGivenNumbers(CheckNumbers stringOfNumbers){
        String checkDigit = findCheckDigit(stringOfNumbers.getStringOfNumbers());
        return checkDigit;
    }


    private static boolean checkStringOfNumbersUsingLuhnAlgorithm(String numbers) {
        int[] values = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            values[i] = Integer.parseInt(numbers.substring(i, i + 1));
        }
        for (int i = values.length - 2; i >= 0; i = i - 2) {
            int j = values[i];
            j = j * 2;
            if (j > 9) {
                j = j % 10 + 1;
            }
            values[i] = j;
        }
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        if (sum % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String findCheckDigit(String number) {
        if (number == null) {
            return null;
        }
        String digit;
        int[] digits = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            digits[i] = Character.getNumericValue(number.charAt(i));
        }
        for (int i = digits.length - 1; i >= 0; i -= 2) {
            digits[i] += digits[i];
            if (digits[i] >= 10) {
                digits[i] = digits[i] - 9;
            }
        }
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }
        sum = sum * 9;
        number = sum + "";
        return number.substring(number.length() - 1);
    }
    
}
