import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.media.Playable;


public class Aims {
	private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);
    
	public static void main (String[] args) {
		setupSampleStore();
        
        int choice = -1;
        do {
            showMenu();
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 0-3.");
            }
        } while (choice != 0);
        
        scanner.close();
		
	}
	
	private static void setupSampleStore() {
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87,19.95f);
        store.addMedia(dvd);

        Book book = new Book("The Lord of the Rings", "Fantasy", 25.50f, "Tolkien");
        book.addAuthor("J.R.R. Tolkien");
        store.addMedia(book);

        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(new Track("Track 1: Symphony No. 5", 300));
        tracks.add(new Track("Track 2: Moonlight Sonata", 420));
        tracks.add(new Track("Track 3: The Four Seasons", 600));

        CompactDisc cd = new CompactDisc("Classical Masterpieces", "Classical", 45.99f, tracks, "John Williams");
        store.addMedia(cd);
    }
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
    private static void viewStore() {
        System.out.println(store.getItemsInStore()); 
        
        int storeChoice = -1;
        do {
            storeMenu();
            if (scanner.hasNextInt()) {
                storeChoice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                storeChoice = -1;
                continue;
            }

            switch (storeChoice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                	String mediaTitle2 = scanner.nextLine();
                	Media media2 = store.findMediaByTitle(mediaTitle2);
                	if (media2 != null) {
                		cart.addMedia(media2);
                	}
                    break;
                case 3:
                	String mediaTitle3 = scanner.nextLine();
                	Media media3 = store.findMediaByTitle(mediaTitle3);
                	if (media3 instanceof CompactDisc) {
                		((CompactDisc) media3).play();
                	}
                	
                	if (media3 instanceof DigitalVideoDisc) {
                		((DigitalVideoDisc) media3).play();
                	}
                	
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Returning to Main Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 0-4.");
            }
            if (storeChoice != 0 && storeChoice != 4) {
            	System.out.println(store.getItemsInStore());
            }

        } while (storeChoice != 0);
    }
    
    private static void updateStore() {
        System.out.println("What would you like to do?");
        System.out.println("1. Add Media");
        System.out.println("2. Remove Media");
    }
    
    private static void seeCurrentCart() {
        cart.print(); 
        System.out.println("Total Cost: " + cart.totalCost());
        
        int cartChoice = -1;
        do {
            cartMenu();
            if (scanner.hasNextInt()) {
                cartChoice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                cartChoice = -1;
                continue;
            }

            switch (cartChoice) {
                case 1:
                    if (scanner.hasNextInt()) {
                    	cart.search(scanner.nextInt());
                    } else {cart.search(scanner.nextLine());}
                    break;
                case 2:
                    cart.sort();
                    cart.print();
                    break;
                case 3:
                	String title = scanner.nextLine();
                    cart.removeMedia(title);
                    break;
                case 4:
                    System.out.println("Type the name of the media you want to play.");
                    String mediaTitle3 = scanner.nextLine();
                	Media media3 = store.findMediaByTitle(mediaTitle3);
                	if (media3 instanceof CompactDisc) {
                		((CompactDisc) media3).play();
                	}
                	
                	if (media3 instanceof DigitalVideoDisc) {
                		((DigitalVideoDisc) media3).play();
                	}
                    break;
                    
                case 5:
                    placeOrder();
                    break;
                case 0:
                    System.out.println("Returning to Main Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 0-5.");
            }
            if (cartChoice != 0) {
                cart.print();
            }
        } while (cartChoice != 0 && cartChoice != 5);
    }
    
    private static void placeOrder() {
    	System.out.println("An order is created");
    	cart = new Cart();
    }
    
	private static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        
        Media media = store.findMediaByTitle(title);
        
        if (media == null) {
            System.out.println("Error: Media not found in the store.");
            return;
        }

        System.out.println("\n--- Media Details ---");
        System.out.println(media.toString()); 
        System.out.println("---------------------\n");

        int detailChoice = -1;
        do {
            mediaDetailsMenu();
            if (scanner.hasNextInt()) {
                detailChoice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                detailChoice = -1;
                continue;
            }

            switch (detailChoice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Added '" + media.getTitle() + "' to cart. Items in cart: ");
                    cart.print();
                    break;
                case 2:
                    if (media instanceof Playable) {
                         ((Playable) media).play();
                    } else {
                        System.out.println("Error: This media cannot be played.");
                    }
                    break;
                case 0:
                    System.out.println("Returning to Store Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 0-2.");
            }
        } while (detailChoice != 0 && detailChoice != 1);
    }
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
}
