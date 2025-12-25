package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.*;
import java.util.*;
public class Store {
	private ArrayList<Media> itemsInStore;
	
	public Store() {
		super();
		this.itemsInStore = new ArrayList<Media>();
	}

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	public void addMedia(Media dvd) {
		itemsInStore.add(dvd);
	}

	public void removeMedia(String title) {
	    for (Media item: itemsInStore) {
	        if (item.getTitle().equals(title)) {
	            itemsInStore.remove(item);
	            break;
	        }
	    }
	}
	
	public Media findMediaByTitle(String title) {
	    for (Media item: itemsInStore) {
			if (item.getTitle().equals(title)) {
	            return item;
	        }
	    }
	    System.out.println("No such media with that title");
	    return null;
	}
}

