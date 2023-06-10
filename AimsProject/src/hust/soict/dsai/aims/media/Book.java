package src.hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    public List<String> authors = new ArrayList<String>();   
    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("This author has already been in the list of authors");
        }
        else {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);        
        }
        else {
            System.out.println("This author doesn't exist in the list of authors");
        }
    }

    public String toString() {
		return "Book" + " - " + this.getId()
        + " - " + this.getTitle()
		+ " - " + this.getCategory()
		+ " - " + this.authors
		+ ": " + this.getCost() + " $";
	}
}
