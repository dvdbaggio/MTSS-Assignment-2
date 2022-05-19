////////////////////////////////////////////////////////////////////
// Davide Baggio 2009989
// Sanson Sebastiano 2011880
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BillTest {
    Bill bill = null;
    List<EItem> itemsOrdered = null;
    User user = null;

    @Before
    public void initialize() {
        bill = new BillImp();
        itemsOrdered = new ArrayList<EItem>();
        user = new User("example@mail.com", "Tizio", "Caio", LocalDate.of(2000, 03, 18));
    }

    @Test
    public void testOrderPrice_nullUser() {
        itemsOrdered.add(new EItem(EItem.item.Keyboard, "Logitech", 65.20));
        try {
            bill.getOrderPrice(itemsOrdered, null);
        } catch(BillException e) {
            assertEquals("User cannot be null", e.getMessage());
        }
    }

    @Test
    public void testOrderPrice() throws BillException {
        itemsOrdered.add(new EItem(EItem.item.Processor, "AMD", 210.50));
        itemsOrdered.add(new EItem(EItem.item.Processor, "Intel", 40.00));
        itemsOrdered.add(new EItem(EItem.item.Motherboard, "Gigabyte", 120.00));
        itemsOrdered.add(new EItem(EItem.item.Processor, "Intel", 150.99));
        itemsOrdered.add(new EItem(EItem.item.Keyboard, "Logitech", 65.20));

        assertEquals( 586.69, bill.getOrderPrice(itemsOrdered, user), 1e-8);
    }

    @Test
    public void testOrderPrice_nullList() throws BillException {
        itemsOrdered = null;
        try {
            bill.getOrderPrice(itemsOrdered, user);
        } catch(BillException exc) {
            assertEquals("Items ordered list cannot be null", exc.getMessage());
        }
    }

    @Test
    public void testOrderPrice_nullItem() {
        itemsOrdered.add(new EItem(EItem.item.Processor, "AMD", 210.50));
        itemsOrdered.add(new EItem(EItem.item.Motherboard, "Gigabyte", 120.00));
        itemsOrdered.add(null);
        try {
            bill.getOrderPrice(itemsOrdered, user);
        } catch(BillException e) {
            assertEquals("Items list cannot contain a null value", e.getMessage());
        }
    }
}


