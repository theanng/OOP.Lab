package src.hust.soict.dsai.test.cart;

import src.hust.soict.dsai.aims.cart.Cart;
import src.hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main (String[] args) {
        Cart anOrder=new Cart();
    	
    	DigitalVideoDisc dvd1=new DigitalVideoDisc("The Lion King","Animation","Roger Aller",87,19.95f);
    	anOrder.addMedia(dvd1);
    	DigitalVideoDisc dvd2=new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
    	anOrder.addMedia(dvd2);
    	DigitalVideoDisc dvd3=new DigitalVideoDisc("Aladin","Animation",18.99f);
    	anOrder.addMedia(dvd3);
    	anOrder.removeMedia(dvd1);
    	System.out.println("Total Cost is:");
    	System.out.println(anOrder.totalCost());

        anOrder.printCart();
        anOrder.searchByTitle("The Lion King");
        anOrder.searchByTitle("Star Wars");
    }
}
