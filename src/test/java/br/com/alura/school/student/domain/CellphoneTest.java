package br.com.alura.school.student.domain;

import br.com.alura.school.domain.student.Cellphone;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CellphoneTest {

    @Test
    public void shouldNotCreateCellphoneWithInvalidDdd() {
        assertThrows(IllegalArgumentException.class, () -> new Cellphone(null, "123456789"));
        assertThrows(IllegalArgumentException.class, () -> new Cellphone("", "123456789"));
        assertThrows(IllegalArgumentException.class, () -> new Cellphone("1", "123456789"));
    }

    @Test
    public void shouldNotCreateCellphoneWithInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Cellphone("83", null));
        assertThrows(IllegalArgumentException.class, () -> new Cellphone("83", ""));
        assertThrows(IllegalArgumentException.class, () -> new Cellphone("83", "12345678"));
        assertThrows(IllegalArgumentException.class, () -> new Cellphone("83", "1234567890"));
    }

    @Test
    public void shouldCreateCellphoneWithValidDddAndNumber() {
        String validDdd = "83";
        String validNumber = "123456789";
        Cellphone cellphone = new Cellphone(validDdd, validNumber);
        assertEquals(validDdd, cellphone.getDdd());
        assertEquals(validNumber, cellphone.getNumber());
    }
}