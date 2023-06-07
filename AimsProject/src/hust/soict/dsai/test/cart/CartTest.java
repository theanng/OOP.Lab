package src.hust.soict.dsai.test.cart;

import src.hust.soict.dsai.aims.cart.Cart;
import src.hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main (String[] args) {
        Cart anOrder=new Cart();
    	
    	DigitalVideoDisc dvd1=new DigitalVideoDisc("The Lion King","Animation","Roger Aller",87,19.95f);
    	anOrder.addDigitalVideoDisc(dvd1);
    	DigitalVideoDisc dvd2=new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
    	anOrder.addDigitalVideoDisc(dvd2);
    	DigitalVideoDisc dvd3=new DigitalVideoDisc("Aladin","Animation",18.99f);
    	anOrder.addDigitalVideoDisc(dvd3);
    	anOrder.removeDigitalVideoDisc(dvd1);
    	System.out.println("Total Cost is:");
    	System.out.println(anOrder.totalCost());

        anOrder.printCart();
        anOrder.searchDVD("The Lion King");
        anOrder.searchDVD("Star Wars");
    }
}
