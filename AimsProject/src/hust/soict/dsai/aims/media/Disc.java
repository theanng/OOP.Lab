package src.hust.soict.dsai.aims.media;

public class Disc extends Media{
    private String director;
    private int length;

    public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}

	public void setLength(int length) {
		this.length = length;
	}
	public void setDirector(String director) {
		this.director = director;
	}

    public Disc() {
		super();
	}
		
	public Disc(String title) {
		super();
	}
	public Disc(String title, String category, float cost) {
		super();
	}
	public Disc(String title, String category, String director, float cost) {
		super();
        this.director = director;
	}
	public Disc(String title, String category, String director, int length, float cost) {
		super();
        this.director = director;
        this.length = length;
	}
}
