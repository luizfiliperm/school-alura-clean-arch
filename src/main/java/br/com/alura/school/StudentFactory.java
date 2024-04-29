package br.com.alura.school;

public class StudentFactory {

    private Student student;

    public StudentFactory withCPF(String cpf) {
        this.student = new Student();
        this.student.setCpf(new CPF(cpf));
        return this;
    }

    public StudentFactory withName(String name) {
        this.student.setName(name);
        return this;
    }

    public StudentFactory withEmail(String email) {
        this.student.setEmail(new Email(email));
        return this;
    }

    public StudentFactory withCellphone(String ddd, String number) {
        this.student.addCellphone(ddd, number);
        return this;
    }

    public Student create() {
        return this.student;
    }
}
