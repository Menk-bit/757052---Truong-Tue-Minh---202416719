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
}
