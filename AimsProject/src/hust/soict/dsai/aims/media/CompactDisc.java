package src.hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import src.hust.soict.dsai.aims.exception.PlayerException;
public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();
    
    public String getArtist() {
        return artist;
    }

    public CompactDisc(int id, String title, String category, float cost, String artist) {
        super(id, title,category, cost);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, float cost, String artist, ArrayList<Track> tracks) {
        super(id, title,category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }
    
    public CompactDisc(int id,String title,String category, float cost,String artist,String director,ArrayList<Track> tracks){
        super(id, title, category, director, 0, cost);
        this.artist=artist;
        this.tracks=tracks;       
        getLength();
    }
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("This track has already been in the list.");
        }
        else {
            tracks.add(track);
        }
    }
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        }
        else {
            System.out.println("This track hasn't been in the list.");
        }
    }
    public int getLength() {
        int totallength = 0;
        for (int i=0; i<tracks.size(); i++) {
            totallength+=tracks.get(i).getLength();
        }
        return totallength;
    }

    @Override
    public void play() throws PlayerException {
    	
        if (this.getLength()>0) {
        	java.util.Iterator iter=tracks.iterator();
        	Track nextTrack;
        	while (iter.hasNext()) {
        		nextTrack=(Track) iter.next();
        		try {
        			nextTrack.play();
        		}catch (PlayerException e) {
					// TODO: handle exception
        			throw e;
				}
        	}
        } else throw new PlayerException("ERROR: CD length is non-positive");
    }

    public String toString() {
        return "CD info: " + this.getId()
        + " - " + this.getTitle()
		+ " - " + this.getCategory()
		+ " - " + this.getArtist()
		+ " - " + this.tracks
		+ ": " + this.getCost() + " $";
	}
}