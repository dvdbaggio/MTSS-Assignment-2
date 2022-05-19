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
        int countProcessor = 0;
        int countMouse = 0;
        int countKeyboard = 0;

        double minProcessor = Double.MAX_VALUE;
        double minMouse = Double.MAX_VALUE;
        double minKeyboard = Double.MAX_VALUE;
        double minMotherboard = Double.MAX_VALUE;

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
            if(item.getItemType() == EItem.item.Processor){
                countProcessor++;
                if(item.getPrice() < minProcessor){
                    minProcessor = item.getPrice();
                }
            }
            if(item.getItemType() == EItem.item.Mouse){
                countMouse++;
                if(item.getPrice() < minMouse){
                    minMouse = item.getPrice();
                }
            }

            if(item.getItemType() == EItem.item.Keyboard){
                countKeyboard++;
                if(item.getPrice() < minKeyboard){
                    minKeyboard = item.getPrice();
                }
            }

            if(item.getItemType() == EItem.item.Motherboard){
                if(item.getPrice() < minMotherboard){
                    minMotherboard = item.getPrice();
                }
            }
            // totale articoli in un elenco [issue #1]
            tot += item.getPrice();
        }

        // sconto 50% sui processori [issue #2]
        if(countProcessor > 5){
            minProcessor = minProcessor/2;
            tot -= minProcessor;
        }

        // Regalare il mouse meno caro [issue #3]
        if(countMouse > 10){
            tot -= minMouse;
        }

        // Articolo regalato nel caso #tastiere uguale #mouse [issue #4]
        if(countMouse!=0 && countMouse == countKeyboard) {
            tot -= Math.min(Math.min(Math.min(minKeyboard, minMouse), minMotherboard), minProcessor);
        }

        // Sconto 10% [issue #5]
        if(tot > 1000){
            tot = tot - (tot*0.1);
        }

        return tot;
    }
}