package br.com.alura.school;

import br.com.alura.school.application.student.enroll.EnrollStudent;
import br.com.alura.school.application.student.enroll.EnrollStudentDto;
import br.com.alura.school.infra.student.StudentMemoryRepository;

public class EnrollStudentViaCommandLine {
    public static void main(String[] args) {
        String name = args[0];
        String cpf = args[1];
        String email = args[2];

        EnrollStudent enroll = new EnrollStudent(new StudentMemoryRepository());
        enroll.execute(new EnrollStudentDto(name, cpf, email));
    }
}