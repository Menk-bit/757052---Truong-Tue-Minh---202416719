package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	private String director;
	private int length;
	private static int nbDigitalVideoDiscs = 0;

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public DigitalVideoDisc(String title) {
		super();
		nbDigitalVideoDiscs += 1;
		this.title = title;
		this.id = nbDigitalVideoDiscs;
		
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		this(title);
		this.category = category;
		this.cost = cost;
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		this(title);
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		this(title);
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	
	
	@Override
	public String toString() {
		return "DVD - " + title + " - " + category + " - " + director + " - " + length + " - " + cost + " $";
	}
	
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
	
			System.out.println("DVD length: " + this.getLength());
		} else {
			throw new PlayerException("Error: DVD length is non-positive!");
		}

	}
}
