package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
	public void setItemsOrdered(ObservableList<Media> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}
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
	
	public void removeMedia(String title) {
		for (Media item: itemsOrdered) {
			Media temp = null;
			
			if (item.getTitle() == title) {
				temp = item;
				break;
			} 
			
			if (itemsOrdered.contains(temp)) {
				itemsOrdered.remove(temp);
			} else {System.out.println("The media is not in cart.");}
		}
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
	
	public void sort() {
		Collections.sort(itemsOrdered, new MediaComparatorByCostTitle());
	}
}
