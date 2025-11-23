package hust.soict.dsai.aims.media;



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
	
	public boolean isMatch(int idSearched) {
		if (this.id == idSearched) {return true;} else {return false;}
	}
	
	public boolean isMatch(String titleSearched) {
        if (titleSearched == null || titleSearched.trim().isEmpty()) {
            return false;
        }

        String dvdTitleLower = this.title.toLowerCase();

        String[] keywords = titleSearched.toLowerCase().split("\\s+");

        for (String keyword : keywords) {         
            if (dvdTitleLower.contains(keyword)) {
                return true; 
            }
        }
        return false;
    }
	
	@Override
	public String toString() {
		return "DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + " $";
	}
	
	public void play() {

		System.out.println("Playing DVD: " + this.getTitle());

		System.out.println("DVD length: " + this.getLength());

	}
}
