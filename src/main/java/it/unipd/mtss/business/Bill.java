////////////////////////////////////////////////////////////////////
// [Davide] [Baggio] [2009989]
// [Sebastiano] [Sanson] [2011880]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import java.time.LocalTime;
import java.util.List;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;

public interface Bill {
    double getOrderPrice(List<EItem> itemsOrdered, User user, LocalTime orderTime) throws BillException;
}