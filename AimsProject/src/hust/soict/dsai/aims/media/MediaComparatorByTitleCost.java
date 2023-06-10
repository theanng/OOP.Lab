package src.hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{

    @Override
    public int compare(Media o1, Media o2) {
        // TODO Auto-generated method stub
        int titleCompare = o1.getTitle().compareTo(o2.getTitle());
        int costCompare = (int) (o1.getCost() - (o2.getCost()));
        return (titleCompare == 0) ? costCompare : titleCompare; 
    }
    
}