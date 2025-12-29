package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	
	public String getArtist() {
		return artist;
	}
	
	
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
	
			System.out.println("DVD length: " + this.getLength());
	
			for (Track individualTrack: tracks) {
				try {
					individualTrack.play();
				} catch (PlayerException e) {
					throw e;
				}
			}
			
		} else throw new PlayerException("Error: DVD length is non-positive!");
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
	
	public CompactDisc(String title, String category, float cost, ArrayList<Track> tracks, String artist) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.tracks = tracks;
		this.artist = artist;
	}
	
	@Override
	public String toString() {
		return "CompactDisc - " + title + " - " + category + " - " + artist + " - " + cost + " $";
	}
}
