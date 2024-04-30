package br.com.alura.school.application.indication;

import br.com.alura.school.domain.student.Student;

public interface SentIndicationEmail {

    void sendTo(Student indicated);
}
