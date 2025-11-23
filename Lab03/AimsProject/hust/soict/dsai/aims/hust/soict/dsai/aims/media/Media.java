package hust.soict.dsai.aims.media;

public abstract class Media {
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
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
	
}
