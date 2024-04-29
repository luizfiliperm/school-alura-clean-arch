package br.com.alura.school.student;

import lombok.Getter;

@Getter
public class CPF {

    private String number;

    public CPF(String number){
        if(!validateFormat(number) || !validateNumber(number)){
            throw new IllegalArgumentException("Invalid CPF number");
        }

        this.number = number;
    }

    private boolean validateFormat(String number){
        if(number == null)
            return false;
        if(!number.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}"))
            return false;
        return true;
    }

    private static boolean validateNumber(String number){
        int[] numbers = new int[11];

        number = number.replaceAll("\\D", "");

        for(int i = 0; i < 11; i++){
            numbers[i] = Integer.parseInt(number.substring(i, i + 1));
        }

        return validateFirstDigit(numbers) && validateSecondDigit(numbers);
    }

    private static boolean validateFirstDigit(int[] numbers) {
        int firstDigit;
        int sum = 0;

        for(int i = 0, j = 10; i < 9; i++, j--){
            sum+= numbers[i] * j;
        }

        if(sum % 11 < 2){
            firstDigit = 0;
        } else {
            firstDigit = 11 - (sum % 11);
        }


        return firstDigit == numbers[9];
    }

    private static boolean validateSecondDigit(int[] numbers) {
        int secondDigit;
        int sum = 0;

        for(int i = 0, j = 11; i < 10; i++, j--){
            sum+= numbers[i] * j;
        }

        if(sum % 11 < 2){
            secondDigit = 0;
        } else {
            secondDigit = 11 - (sum % 11);
        }

        return secondDigit == numbers[10];
    }
}
