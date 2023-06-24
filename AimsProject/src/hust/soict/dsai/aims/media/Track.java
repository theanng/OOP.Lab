package src.hust.soict.dsai.aims.media;

import src.hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

    public Track(String title) {
        this.title = title;
    }
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    @Override
	public void play() throws PlayerException {
		// TODO Auto-generated method stub
    	if (this.getLength()>0) {
		System.out.println("Playing DVD: "+this.getTitle());
		System.out.println("DVD length: " + this.getLength());
    	} else throw new PlayerException("Error: Length cannot be non-positive!");

	}

    public String toString() {
        return "Name: " + this.getTitle() + "; Length: " + this.getLength();
    }

    @Override
    public boolean equals(Object o) {
		if (o instanceof Track) {
			Track abc = (Track) o;
			return this.getTitle().equals(abc.getTitle()) && this.getLength()==abc.getLength();
		}
		else {
			return false;
		}
	}
}
