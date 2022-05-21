////////////////////////////////////////////////////////////////////
// [Davide] [Baggio] [2009989]
// [Sebastiano] [Sanson] [2011880]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EItemTest {
    EItem item = null;

    @Before
    public void beforeTests() {
        item = new EItem(EItem.item.Processor, "Intel i5-11600K", 237.09);
    }

    @Test
    public void testGetItemType() {
        assertEquals(EItem.item.Processor, item.getItemType());
    }

    @Test
    public void testGetName() {
        assertEquals("Intel i5-11600K", item.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(237.09, item.getPrice(), 1e-8);
    }

    @Test
    public void testNegativePrice() {
        try {
            item = new EItem(EItem.item.Processor, "Intel i5-11600K", -0.01);
        } catch(IllegalArgumentException exc) {
            assertEquals("Price must be a positive number", exc.getMessage());
        }
    }
}