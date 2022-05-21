////////////////////////////////////////////////////////////////////
// [Davide] [Baggio] [2009989]
// [Sebastiano] [Sanson] [2011880]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.model.User;

import java.time.LocalTime;

public interface Giveaway {
    boolean giveAwayOrder(User user, LocalTime orderTime);
}
