package br.com.alura.school;

import lombok.Data;

@Data
public class Cellphone {
    private String ddd;
    private String number;

    public Cellphone(String ddd, String number) {
        if (ddd == null || !ddd.matches("\\d{2}")) {
            throw new IllegalArgumentException("Invalid DDD");
        }
        if (number == null || !number.matches("\\d{9}")) {
            throw new IllegalArgumentException("Invalid number");
        }
        this.ddd = ddd;
        this.number = number;
    }
}
