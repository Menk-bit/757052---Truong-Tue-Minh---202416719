package hust.soict.dsai.aims.media;
import java.util.*;

public abstract class Media {
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	
	public Media() {
	}
	
	public Media(String title) {
		this.title = title;
	}

	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;		
	}
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = 
	        new MediaComparatorByTitleCost();

	    public static final Comparator<Media> COMPARE_BY_COST_TITLE = 
	        new MediaComparatorByCostTitle();
	    
	  
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
	
	@Override
	public boolean equals(Object obj) throws NullPointerException  {
		try {
			Media other = (Media) obj;
			return (this.getTitle()).equals(other.getTitle());
		} catch (NullPointerException e) {
			System.out.println("One of the 2 medias does not exist!");
			return false;
		} catch (ClassCastException e) {
			System.out.println("The media is not of the appropriate type!");
			return false;
		}
	}
}
