package src.hust.soict.dsai.aims.store;
import java.util.ArrayList;

import src.hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
    public ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
    public Store() {}
    public void addDVD(DigitalVideoDisc dvd) {
        boolean a = false;
        for (int i=0; i<itemsInStore.size(); i++) {
            if (dvd.equals(itemsInStore.get(i))) {
                System.out.println("This DVD has already been in the store.");
                a = true;
                break;
            }
            else {
                a = false;
            }
        }
        if (a==false) {
            itemsInStore.add(dvd);
        }
    }

    public void removeDVD(DigitalVideoDisc dvd){
        boolean a = false;
        for (int i=0; i<itemsInStore.size(); i++) {
            if (dvd.equals(itemsInStore.get(i))) {
                itemsInStore.remove(dvd);
                a = true;
                break;
            }
            else {
                a = false;
            }
        }
        if (a==false) {
            System.out.println("This DVD is not in the store.");
        }
    }

}
