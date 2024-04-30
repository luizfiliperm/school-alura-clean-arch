package br.com.alura.school.domain.student;

public interface PasswordEncrypt {
    String encryptPassword(String password);

    boolean validatePassword(String password, String encryptedPassword);
}
