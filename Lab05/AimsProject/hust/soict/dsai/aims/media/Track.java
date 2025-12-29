package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	public Track() {
		super();
	}
	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	public void play() throws PlayerException {

		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
	
			System.out.println("DVD length: " + this.getLength());
		} else {
			throw new PlayerException("Error: DVD length is non-positive!");
		}

	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Track)) {
			return false;
		}
		
		Track other = (Track) obj;
		return (this.getTitle()).equals(other.getTitle());
	}
}
