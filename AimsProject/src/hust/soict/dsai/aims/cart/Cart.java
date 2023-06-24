package src.hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import src.hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import src.hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED=20;
	private ObservableList<Media> itemsOrdered=FXCollections.observableArrayList();

	public void addMedia(Media media){
        itemsOrdered.add(media);
        System.out.println("Added " + media.getTitle() + " to cart.");
    }
    public void removeMedia(Media media){
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed " + media.getTitle() + " from cart.");
        } else {
            System.out.println("Item not found in cart.");
        }
    }

	
	
	public float totalCost() {
        float total = 0;
        for (Media media:itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }


    public void sortbyTitleCost(){
        Collections.sort(itemsOrdered,Media.COMPARE_BY_TITLE_COST);
    }
    public void sortByCostTiTle(){
        Collections.sort(itemsOrdered,Media.COMPARE_BY_COST_TITLE);
    }
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:\n");
    
        for (Media media:itemsOrdered) {
            System.out.println(media.toString());
        }
    
        float totalCost = totalCost();
        System.out.println("\nTotal cost: " + totalCost);
        System.out.println("***************************************************");
    }
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    public void searchById(int idToMatch) {
        boolean dvdFound = false;
        for (Media dvd: itemsOrdered) {
            if (dvd.getId() == idToMatch) {
                dvd.toString();
                dvdFound = true;
            }
        }
        if (dvdFound == false) {
            System.out.println("Item not found.");
        } 
    }

    public void searchByTitle(String titleToMatch) {
        boolean dvdFound = false;
        for (Media dvd:itemsOrdered) {
            if (((DigitalVideoDisc) dvd).equals(titleToMatch)) {
                dvd.toString();
                dvdFound = true;
            }
        }
        if (dvdFound == false) {
            System.out.println("Item not found.");
        }
    }
}
