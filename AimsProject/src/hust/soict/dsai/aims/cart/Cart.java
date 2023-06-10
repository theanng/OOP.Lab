package src.hust.soict.dsai.aims.cart;

import src.hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED=20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
    public Cart() {
	}
	
    public void addMedia(Media media) {
        boolean a = false;
        for (int i=0; i<itemsOrdered.size(); i++) {
            if (media.equals(itemsOrdered.get(i))) {
                System.out.println("This media has already been in the cart.");
                a = true;
                break;
            }
            else {
                a = false;
            }
        }
        if (a==false) {
            itemsOrdered.add(media);
        }
    }
    
    public void removeMedia(Media media) {
        boolean a = false;
        for (int i=0; i<itemsOrdered.size(); i++) {
            if (media.equals(itemsOrdered.get(i))) {
                itemsOrdered.remove(media);
                a = true;
                break;
            }
            else {
                a = false;
            }
        }
        if (a==false) {
            System.out.println("This media is not in the cart.");
        }
    }
    
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }
    //print the list of ordered items of a cart
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items: ");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i+1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    //search for dvds by id
    public void searchMedia(int id) {
        boolean a = true;
        for (int i = 0; i<itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getId() == id) {
                System.out.println(itemsOrdered.get(i).toString());
                a = true;
                break;
            }
            else {
                a = false;
            }
        }
        if (a == false) {
            System.out.println("No match is found.");
        }
    }

    //search for dvds by title
    public void searchMedia(String title) {
        boolean a = true;
        for (int i = 0; i<itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getTitle().equals(title)) {
                System.out.println(itemsOrdered.get(i).toString());
                a = true;
                break;
            }
            else {
                a = false;
            }
        }
        if (a == false) {
            System.out.println("No match is found.");
        }
    }
    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}
