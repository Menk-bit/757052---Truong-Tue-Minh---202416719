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

	public void addDVD(DigitalVideoDisc dvd) {
		itemsInStore.add(dvd);
	}

	public void removeDVD(String title) {
	    for (Media item: itemsInStore) {
	        if (item.getTitle().equals(title)) {
	            itemsInStore.remove(item);
	            break;
	        }
	    }
	}
}
