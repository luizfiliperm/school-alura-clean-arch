package br.com.alura.school.infra.indication;

import br.com.alura.school.application.indication.SentIndicationEmail;
import br.com.alura.school.domain.student.Student;

public class SentIndicationEmailWithJavaMail implements SentIndicationEmail {
    @Override
    public void sendTo(Student indicated) {
        // implementation to send email
    }
}
