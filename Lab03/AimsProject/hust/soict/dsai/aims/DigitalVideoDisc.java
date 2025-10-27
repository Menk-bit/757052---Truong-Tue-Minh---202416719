package Lab03.AimsProject.hust.soict.dsai.aims;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private int id;	
	private static int nbDigitalVideoDiscs = 0;
	
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	
	public int getId() {
		return id;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
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
	
	
}
