package src.hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Media implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();
    
    public String getArtist() {
        return artist;
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
    public void play() {
        System.out.println("CD info:");
        for (int i=0; i<tracks.size(); i++) {
            System.out.println((i+1) + ". " + tracks.get(i).toString());
        }
    }
}
