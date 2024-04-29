package br.com.alura.school.indication;

import br.com.alura.school.student.Student;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Indication {

    private Student indicator;
    private Student indicated;
    private LocalDateTime indicationDate;

    public Indication(Student indicator, Student indicated) {
        this.indicator = indicator;
        this.indicated = indicated;
        this.indicationDate = LocalDateTime.now();
    }
}
