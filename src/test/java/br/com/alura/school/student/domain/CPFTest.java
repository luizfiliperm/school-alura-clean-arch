package br.com.alura.school.student.domain;

import br.com.alura.school.domain.student.CPF;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CPFTest {

    @Test
    public void shouldNotCreateCpfWithInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
        assertThrows(IllegalArgumentException.class, () -> new CPF(""));
        assertThrows(IllegalArgumentException.class, () -> new CPF("123456789"));
        assertThrows(IllegalArgumentException.class, () -> new CPF("123.456.789"));
        assertThrows(IllegalArgumentException.class, () -> new CPF("123.456.789-0"));
    }

    @Test
    public void shouldCreateCpfWithValidNumber(){
        String validNumber = "125.182.172-31";
        CPF cpf = new CPF(validNumber);
        assertEquals(validNumber, cpf.getNumber());
    }
}