package br.com.alura.school.infra.student;

import br.com.alura.school.domain.student.CPF;
import br.com.alura.school.domain.student.Student;
import br.com.alura.school.domain.student.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentMemoryRepository implements StudentRepository {

    private List<Student> students = new ArrayList<>();

    @Override
    public void enroll(Student student) {
        students.add(student);
    }

    @Override
    public Student findByCPF(CPF cpf) {
        return this.students.stream()
            .filter(student -> student.getCpf().equals(cpf))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public List<Student> findAllEnrolledStudents() {
        return this.students;
    }
}
