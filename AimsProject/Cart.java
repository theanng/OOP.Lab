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
	
    //method for an abitraty number of arguments
    
	
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
}
