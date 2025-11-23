import java.util.ArrayList;

import hust.soict.dsai.aims.media.*;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media newMedia) {
		if (itemsOrdered.contains(newMedia)) {
			System.out.println("The media is already in cart.");
		} else {itemsOrdered.add(newMedia);}
	}
	
	public void removeMedia(Media newMedia) {
		if (itemsOrdered.contains(newMedia)) {
			itemsOrdered.remove(newMedia);
		} else {System.out.println("The media is not in cart.");}
	}
	
	public float totalCost() {
	    float total = 0.0f;
	    for (Media item: itemsOrdered) {
	        total += item.getCost();
	    }
	    return total;
	}
	
	public void print() {
		int i = 0;
		System.out.println("***********************CART***********************");
		for (Media item: itemsOrdered) {
			i += 1;
			System.out.println((i) + ". " + item);
		System.out.println("***************************************************");
		}
	}
	
	public void search(String titleSearched) {
		int matchCount = 0;
		System.out.println("List of items found: ");
		for (Media item: itemsOrdered) {
			if (item.isMatch(titleSearched)) {
				matchCount++;
				System.out.println(item);
			}
		}
		if (matchCount == 0) {System.out.println("None");}
	}
	
	public void search(int idSearched) {
		int matchCount = 0;
		System.out.println("List of items found: ");
		for (Media item: itemsOrdered) {
			if (item.isMatch(idSearched)) {
				matchCount++;
				System.out.println(item);
			}
		}
		if (matchCount == 0) {System.out.println("None");}
	}
}
