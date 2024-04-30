package br.com.alura.school.domain.student;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student {

    private CPF cpf;

    private String name;

    private Email email;

    private String password;

    private List<Cellphone> cellphones = new ArrayList<>();

    public void addCellphone(String ddd, String number){
        this.cellphones.add(new Cellphone(ddd, number));
    }
}
