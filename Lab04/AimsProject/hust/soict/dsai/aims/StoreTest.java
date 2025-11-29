import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		Store storeJohn = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
	            "Animation", "Roger Allers", 87, 19.95f);
		
	
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
	            "Science Fiction", "George Lucas", 87, 24.95f);
	
	
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
	            "Animation", 18.99f);
	
		storeJohn.addMedia(dvd1);
		storeJohn.addMedia(dvd2);
		System.out.println(storeJohn.getItemsInStore());
		
		storeJohn.removeMedia("Star Wars");
		storeJohn.addMedia(dvd3);
		System.out.println(storeJohn.getItemsInStore());
	}
}
