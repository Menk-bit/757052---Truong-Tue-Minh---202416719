package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.*;

public class Test {
	public static void main(String[] args) {
		Book testBook = new Book("1636", "Balls", 36, "Paris");
		DigitalVideoDisc testDVD = new DigitalVideoDisc("ligma", "Skibidi", 3636);
		Track testTrack1 = new Track("Deez Nuts", 36);
		Track testTrack2 = new Track("Deez Balls", 3636);
		ArrayList<Track> testTracks = new ArrayList<Track>();
		testTracks.add(testTrack2);
		testTracks.add(testTrack1);
		CompactDisc EliteBallKnowledge = new CompactDisc("James Balls", "gyatt", 2, testTracks, "ggin");
		
		ArrayList<Media> initialStore = new ArrayList<Media>();
		
		Store store = new Store();
		store.addMedia(testDVD);
		store.addMedia(testBook);
		store.addMedia(EliteBallKnowledge);
		
		new StoreScreen(store);
	}

}
