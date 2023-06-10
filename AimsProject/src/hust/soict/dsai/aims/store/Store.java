package src.hust.soict.dsai.aims.store;
import java.util.ArrayList;

import src.hust.soict.dsai.aims.media.Media;

public class Store {
    public ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public Store() {}
    public void addMedia(Media media) {
        boolean a = false;
        for (int i=0; i<itemsInStore.size(); i++) {
            if (media.equals(itemsInStore.get(i))) {
                System.out.println("This media has already been in the store.");
                a = true;
                break;
            }
            else {
                a = false;
            }
        }
        if (a==false) {
            itemsInStore.add(media);
        }
    }
    
    public void removeMedia(Media media) {
        boolean a = false;
        for (int i=0; i<itemsInStore.size(); i++) {
            if (media.equals(itemsInStore.get(i))) {
                itemsInStore.remove(media);
                a = true;
                break;
            }
            else {
                a = false;
            }
        }
        if (a==false) {
            System.out.println("This media is not in the store.");
        }
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public boolean searchTitle(String title){
            for (Media media: itemsInStore){
                if (media.getTitle().equals(title)){
                    return true;
                }
            }
            return false;
    
    }
    public void display(){
        for (Media media: itemsInStore){
            System.out.println(media);
        }
    }

}
