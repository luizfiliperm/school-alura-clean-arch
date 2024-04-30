package br.com.alura.school.application.student.enroll;

import br.com.alura.school.domain.student.StudentRepository;

public class EnrollStudent {

    private final StudentRepository repository;

    public EnrollStudent(StudentRepository repository) {
        this.repository = repository;
    }

    public void execute(EnrollStudentDto enrollStudentDto){
        repository.enroll(enrollStudentDto.toStudent());
    }

}
