////////////////////////////////////////////////////////////////////
// Davide Baggio 2009989
// Sanson Sebastiano 2011880
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.model.User;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class GiveawayTest {
    GiveawayImp gift = null;
    User user = null;

    @Before
    public void initialize() {
        user = new User("example@mail.com", "Sebastiano", "Sanson", LocalDate.of(2015, 3, 18));
        gift = new GiveawayImp();
    }

    @Test
    public void testGiveAwayOrder_NullUser() {
        user = null;
        try {
            gift.addWinner(user, LocalTime.of(18, 35));
        } catch(IllegalArgumentException exc) {
            assertEquals("User cannot be null", exc.getMessage());
        }
    }

    @Test
    public void testGiveAwayOrder_Underage() {
        assertTrue(gift.canBeAdded(user, LocalTime.of(18, 35)));
    }

    @Test
    public void testGiveAwayOrder_Adult() {
        user = new User("example@mail.com", "Sebastiano", "Sanson", LocalDate.of(2000, 3, 18));
        assertFalse(gift.canBeAdded(user, LocalTime.of(18, 35)));
    }

    @Test
    public void testGiveAwayOrder_WrongOrderTime() {
        user = new User("example@mail.com", "Sebastiano", "Sanson", LocalDate.of(2015, 3, 18));
        assertFalse(gift.canBeAdded(user, LocalTime.of(12, 35)));
    }

    @Test
    public void testGiveAwayOrder_NullOrderTime() {
        try {
            gift.addWinner(user, null);
        } catch(IllegalArgumentException exc) {
            assertEquals("Order time cannot be null", exc.getMessage());
        }
    }

    @Test
    public void testGiveAwayOrder_testAddWinner() throws IllegalArgumentException{
        assertTrue(gift.addWinner(user, LocalTime.of(18, 35)));
    }

    @Test
    public void testGiveAwayOrder_MoreThan10Winners() throws IllegalArgumentException {
        for(int i = 0; i < 10; i++) {
            gift.winners.add(user);
        }
        assertFalse(gift.addWinner(user, LocalTime.of(18, 35)));
    }
}
