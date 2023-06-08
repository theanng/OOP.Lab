package src.hust.soict.dsai.aims.media;
public class DigitalVideoDisc extends Disc implements Playable{
	private static int nbDigitalVideoDiscs = 0;

	public DigitalVideoDisc() {
		super();
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
	}
		
	public DigitalVideoDisc(String title) {
		super();
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
		this.setTitle(title);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		this.setDirector(director);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		this.setDirector(director);
		this.setLength(length);
	}

	public String toString() {
		return "DVD" + " - " + this.getTitle()
		+ " - " + this.getCategory()
		+ " - " + this.getDirector()
		+ " - " + this.getLength()
		+ ": " + this.getCost() + " $";
	}

	public boolean equals(Object o) {
		if (o instanceof DigitalVideoDisc) {
			DigitalVideoDisc abc = (DigitalVideoDisc) o;
			return this.getId() == abc.getId();
		}
		else {
			return false;
		}
	}
	@Override
    public void play() {
        
    }
}