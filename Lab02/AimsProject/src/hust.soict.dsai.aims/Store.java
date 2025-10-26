public class Store {
	private static final int MAX_STORE = 100000;
	private int nbDVD;
	private DigitalVideoDisc[] itemsInStore;
	
	public Store() {
		super();
		this.itemsInStore = new DigitalVideoDisc[MAX_STORE];
		nbDVD = 0;
	}

	public String getItemsInStore() {
		String listDVD = "";
		for (int i = 0; i < nbDVD; i++) {
			listDVD = listDVD + itemsInStore[i].getTitle() + "; ";
		}
		return listDVD;
	}

	public void addDVD(DigitalVideoDisc dvd) {
		itemsInStore[nbDVD] = dvd;
		nbDVD++;
	}

	public void removeDVD(String title) {
	    for (int i = 0; i < nbDVD; i++) {
	        if (itemsInStore[i].getTitle().equals(title)) {
	            for (int j = i; j < nbDVD - 1; j++) {
	                itemsInStore[j] = itemsInStore[j + 1];
	            }
	            nbDVD--;
	            
	            itemsInStore[nbDVD] = null; 
	            break;	
	        }
	    }
	}
}
