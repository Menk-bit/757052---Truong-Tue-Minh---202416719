package Lab03.AimsProject.hust.soict.dsai.aims;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	private int qtyOrdered;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBER_ORDERED) {
			this.itemsOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			System.out.println("The disc has been added.");
		} else {
	        System.out.println("The cart is full. Cannot add more discs.");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for (DigitalVideoDisc disc: dvdList) {
			addDigitalVideoDisc(disc);
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
	        if (itemsOrdered[i] == disc) { 
	            for (int j = i; j < qtyOrdered - 1; j++) {
	                itemsOrdered[j] = itemsOrdered[j + 1];
	            }
	            itemsOrdered[qtyOrdered - 1] = null; 
	            qtyOrdered--;
	            System.out.println("Removed: " + disc.getTitle());
	        }
	    }
	    System.out.println("Disc not found in cart.");
	}    
	    
	public float totalCost() {
	    float total = 0.0f;
	    for (int i = 0; i < qtyOrdered; i++) {
	        total += itemsOrdered[i].getCost();
	    }
	    return total;
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println((i + 1) + ". " + itemsOrdered[i]);
		System.out.println("***************************************************");
		}
	}
	
	public void search(String titleSearched) {
		int matchCount = 0;
		System.out.println("List of items found: ");
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(titleSearched)) {
				matchCount++;
				System.out.println(itemsOrdered[i]);
			}
		}
		if (matchCount == 0) {System.out.println("None");}
	}
	
	public void search(int idSearched) {
		int matchCount = 0;
		System.out.println("List of items found: ");
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(idSearched)) {
				matchCount++;
				System.out.println(itemsOrdered[i]);
			}
		}
		if (matchCount == 0) {System.out.println("None");}
	}
}
