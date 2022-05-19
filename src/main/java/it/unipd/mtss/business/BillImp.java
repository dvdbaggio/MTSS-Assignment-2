////////////////////////////////////////////////////////////////////
// Davide Baggio 2009989
// Sanson Sebastiano 2011880
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;

import java.util.List;

public class BillImp implements Bill {
    public double getOrderPrice(List<EItem> itemsOrdered, User user) throws BillException {
        double tot = 0.0;

        if(itemsOrdered == null) {
            throw new BillException("Items ordered list cannot be null");
        }
        if(itemsOrdered.contains(null)) {
            throw new BillException("Items list cannot contain a null value");
        }
        if(user == null) {
            throw new BillException("User cannot be null");
        }

        for(EItem item : itemsOrdered) {
            // totale articoli in un elenco [issue #1]
            tot += item.getPrice();
        }

        return tot;
    }
}