package src.hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    private String title;
    private String category;
    private float cost;
    private int id;

    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }
    public int getId() {
        return id;
    }

    public void setTitle(String title) {
		this.title = title;
	}
    public void setCategory(String category) {
		this.category = category;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
    public void setId(int id) {
        this.id = id;
    }

    public Media() {}

    public Media(int id) {
        this.id = id;
    }
    public Media(int id, String title) {
        this.id = id;
        this.title = title;
    }
    public Media(int id, String title, String category) {
        this.id = id;
        this.title = title;
        this.category = category;
    }
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;   
    }

    @Override
    public boolean equals(Object o) {
		if (o instanceof Media) {
			Media abc = (Media) o;
			return this.getTitle().equals(abc.getTitle());
		}
		else {
			return false;
		}
	}

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}
