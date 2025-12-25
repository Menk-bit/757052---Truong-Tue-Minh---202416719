package hust.soict.dsai.aims.media;

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
	
	public void play() {

		System.out.println("Playing DVD: " + this.getTitle());

		System.out.println("DVD length: " + this.getLength());

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
