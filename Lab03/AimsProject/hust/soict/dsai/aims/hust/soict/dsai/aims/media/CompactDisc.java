package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	
	public String getArtist() {
		return artist;
	}
	
	
	public void play() {

		System.out.println("Playing DVD: " + this.getTitle());

		System.out.println("DVD length: " + this.getLength());

		for (Track individualTrack: tracks) {
			individualTrack.play();
		}
	}
	
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("Track is already included.");
		} else {tracks.add(track);}
	}
	
	public void removeTack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
		} else {
			System.out.println("Author is not yet included.");
		}
	}
	
	public int getLength() {
		int totalLength = 0;
		for (Track individualTrack: tracks) {
			totalLength = totalLength + individualTrack.getLength();
	}
		return totalLength;	
	}
	
	public CompactDisc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
