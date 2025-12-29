package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public class CartScreen extends JFrame{
	private Cart cart;
	private Store store;
	
	public CartScreen(Cart cart, Store store){
		super();
		this.cart = cart;
		this.store = store;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
	
		this.setTitle("Cart");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass()
							.getResource("/hust/soict/dsai/aims/screen/fxml/cart.fxml"));
					CartScreenController controller =
							new CartScreenController(cart, store);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
					
				} catch (IOException e2) {
					System.out.println(e2.getMessage());
				    System.out.println(e2.toString());
				    e2.printStackTrace();

				    java.io.StringWriter sw = new java.io.StringWriter();
				    java.io.PrintWriter pw = new java.io.PrintWriter(sw);
				    e2.printStackTrace(pw);
				    String exceptionDetails = sw.toString();

				    JTextArea textArea = new JTextArea(exceptionDetails, 10, 50);
				    textArea.setEditable(false);
				    JScrollPane scrollPane = new JScrollPane(textArea);

				    JOptionPane.showMessageDialog(
				        scrollPane, 
				        e2.getClass().getSimpleName()
				    );
				}
			}
			
		});
		
	}
	
}
