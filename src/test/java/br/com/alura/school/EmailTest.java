package br.com.alura.school;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    @Test
    public void shouldNotCreateEmailWithInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertThrows(IllegalArgumentException.class, () -> new Email("invalid"));
        assertThrows(IllegalArgumentException.class, () -> new Email("invalid@"));
        assertThrows(IllegalArgumentException.class, () -> new Email("invalid.com"));
    }

    @Test
    public void shouldCreateEmailWithValidAddress() {
        String validAddress = "test@email.com";
        Email email = new Email(validAddress);
        assertEquals(validAddress, email.getAddress());
    }
}