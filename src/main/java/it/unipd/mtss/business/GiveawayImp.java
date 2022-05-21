////////////////////////////////////////////////////////////////////
// [Davide] [Baggio] [2009989]
// [Sebastiano] [Sanson] [2011880]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.model.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GiveawayImp {
    Random rand;
    List<User> winners;

    public GiveawayImp() {
        winners = new ArrayList<User>();
        rand = new Random();
        rand.setSeed(22);
    }

    public boolean canBeAdded(User user, LocalTime orderTime){
        if(user.getDateOfBirth() != null && Period.between(user.getDateOfBirth(), LocalDate.now()).getYears() < 18) {
            if(winners.size() < 10 && !winners.contains(user)){
                if(orderTime.getHour() == 18 || orderTime.getHour() == 19) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addWinner(User user, LocalTime orderTime) {
        if(user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if(orderTime == null) {
            throw new IllegalArgumentException("Order time cannot be null");
        }
        if(canBeAdded(user, orderTime)) {
            if (rand.nextInt(100) < 50) {
                winners.add(user);
                return true;
            }
        }
        return false;
    }
}