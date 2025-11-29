package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.*;
import java.util.*;
public class Store {
	private List<Media> itemsInStore;
	
	public Store() {
		super();
		this.itemsInStore = new ArrayList<Media>();
	}

	public String getItemsInStore() {
		String listDVD = "";
		for (Media item: itemsInStore) {
			listDVD = listDVD + item.getTitle() + "; ";
		}
		return listDVD;
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

