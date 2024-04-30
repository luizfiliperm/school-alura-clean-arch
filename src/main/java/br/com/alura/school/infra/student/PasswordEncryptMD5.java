package br.com.alura.school.infra.student;

import br.com.alura.school.domain.student.PasswordEncrypt;

import java.security.MessageDigest;

public class PasswordEncryptMD5 implements PasswordEncrypt {

    @Override
    public String encryptPassword(String password) {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        }catch (Exception e){
            throw new RuntimeException("Error encrypting password");
        }
    }

    @Override
    public boolean validatePassword(String password, String encryptedPassword) {
        return encryptPassword(password).equals(encryptedPassword);
    }
}
