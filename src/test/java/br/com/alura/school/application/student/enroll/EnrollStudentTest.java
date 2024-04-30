package br.com.alura.school.application.student.enroll;

import br.com.alura.school.domain.student.CPF;
import br.com.alura.school.domain.student.Student;
import br.com.alura.school.domain.student.StudentRepository;
import br.com.alura.school.infra.student.StudentMemoryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnrollStudentTest {

    @Test
    void studentShouldPersist() {
        StudentRepository repository = new StudentMemoryRepository();
        EnrollStudent useCase = new EnrollStudent(repository);
        EnrollStudentDto studentDto = new EnrollStudentDto("Fulano", "125.182.172-31", "email@email.com");

        useCase.execute(studentDto);

        Student student =  repository.findByCPF(new CPF("125.182.172-31"));

        assertEquals("Fulano", student.getName());
        assertEquals("125.182.172-31", student.getCpf().getNumber());
        assertEquals("email@email.com", student.getEmail().getAddress());
    }
}