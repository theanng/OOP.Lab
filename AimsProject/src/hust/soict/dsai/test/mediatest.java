package src.hust.soict.dsai.test;

import java.util.ArrayList;
import java.util.List;

import src.hust.soict.dsai.aims.media.CompactDisc;
import src.hust.soict.dsai.aims.media.Media;
import src.hust.soict.dsai.aims.media.Track;

public class mediatest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();
        Track track1 = new Track("abc",12);
        Track track2 = new Track("cdf",12);
        ArrayList<Track> tracks = new ArrayList<Track>();
        CompactDisc cd = new CompactDisc(1,"abc1","ty",12.99f,"an",tracks);
        cd.addTrack(track1);
        cd.addTrack(track2);
        System.out.println(cd.toString());
    }
}
