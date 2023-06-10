package src.hust.soict.dsai.test.store;
import src.hust.soict.dsai.aims.media.DigitalVideoDisc;
import src.hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main (String[] args) {
        Store store = new Store();
    	DigitalVideoDisc dvd1=new DigitalVideoDisc("The Lion King","Animation","Roger Aller",87,19.95f);
        store.addMedia(dvd1);
        DigitalVideoDisc dvd2=new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
        store.addMedia(dvd2);

        for (int i=0; i<store.itemsInStore.size(); i++) {
            System.out.println(store.itemsInStore.get(i).toString());
        }
        store.removeMedia(dvd2);
        store.removeMedia(dvd2);
    }
}
