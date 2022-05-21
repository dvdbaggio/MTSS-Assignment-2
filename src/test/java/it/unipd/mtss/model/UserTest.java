////////////////////////////////////////////////////////////////////
// [Davide] [Baggio] [2009989]
// [Sebastiano] [Sanson] [2011880]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    User user;

    @Before
    public void initialize() {
        user = new User("gabrielerapisarda@gmail.com", "Gabriele", "Rapisarda", LocalDate.of(1994, 1, 31));
    }

    @Test
    public void testGetEmail() {
        assertEquals("gabrielerapisarda@gmail.com", user.getEmail());
    }

    @Test
    public void testGetName() {
        assertEquals("Gabriele", user.getName());
    }

    @Test
    public void testGetSurname() {
        assertEquals("Rapisarda", user.getSurname());
    }

    @Test
    public void testGetDateOfBirth() {
        assertEquals(LocalDate.of(1994, 1, 31), user.getDateOfBirth());
    }

    @Test
    public void testNullDateOfBirth() {
        try {
            new User("gabrielerapisarda@gmail.com", "Gabriele","Rapisarda", null);
        }catch(IllegalArgumentException exc) {
            assertEquals("Date of birth value cannot be NULL", exc.getMessage());
        }
    }

    @Test
    public void testFutureDateOfBirth() {
        try {
            new User("gabrielerapisarda@gmail.com", "Gabriele", "Rapisarda", LocalDate.of(2030, 1, 31));
        } catch (IllegalArgumentException e) {
            assertEquals("Date of birth is in the future", e.getMessage());
        }
    }
}