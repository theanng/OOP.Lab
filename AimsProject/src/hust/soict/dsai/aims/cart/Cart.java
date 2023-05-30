package src.hust.soict.dsai.aims.cart;

import src.hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED=20;
	private DigitalVideoDisc itemsOrdered[]=new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered=0;
	
    public Cart() {
		qtyOrdered=0;
	}
	
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered<MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered]=disc;
			qtyOrdered++;
			System.out.println("The disc has been added");
			
		}
		else {
			System.out.println("The cart is almost full");
			
		}
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (int i = 0; i<dvdList.length; i++) {
            this.addDigitalVideoDisc(dvdList[i]);
        }
    }
	
    //method for arbitrary number of arguments
	
	/*public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
		for (DigitalVideoDisc dvd:Cart dvds) {
			this.addDigitalVideoDisc(dvd);
		}
	}
    */

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		this.addDigitalVideoDisc(dvd1);
		this.addDigitalVideoDisc(dvd2);
    }
    
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered = qtyOrdered -1;
                System.out.println("The disc has been removed.");
                break;
            }
        }
	}
	
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
    //print the list of ordered items of a cart
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items: ");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i+1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    //search for dvds by id
    public void searchDVD(int id) {
        boolean a = true;
        for (int i = 0; i<qtyOrdered; i++) {
            if (itemsOrdered[i].id == id) {
                System.out.println(itemsOrdered[i].toString());
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
    public void searchDVD(String title) {
        boolean a = true;
        for (int i = 0; i<qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().equals(title)) {
                System.out.println(itemsOrdered[i].toString());
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
}
