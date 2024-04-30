package br.com.alura.school.application.student.enroll;

import br.com.alura.school.domain.student.Student;
import br.com.alura.school.domain.student.StudentFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EnrollStudentDto {

    private String name;
    private String cpf;
    private String email;

    public Student toStudent(){
        StudentFactory studentFactory = new StudentFactory();
        return studentFactory.withCPF(cpf)
                .withName(name)
                .withEmail(email)
                .create();
    }
}
