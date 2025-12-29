package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame{
	private JPanel centerPanel;
	private Store store;
	private String tempTitle = "";
	private String tempCategory = "";
	private String tempCost = "";
	private Cart cart;
	
	public JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	public JMenuBar createMenuBar() {
		JMenu menu = new JMenu("options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBookButton = new JMenuItem("Add Book");
		smUpdateStore.add(addBookButton);
		addBookButton.addActionListener(new addBookButtonListener());
		JMenuItem addCDButton = new JMenuItem("Add CD");
		smUpdateStore.add(addCDButton);
		addCDButton.addActionListener(new addCDButtonListener());
		JMenuItem addDVDButton = new JMenuItem("Add DVD");
		smUpdateStore.add(addDVDButton);
		addDVDButton.addActionListener(new addDVDButtonListener());
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		JMenuItem viewCartItem = new JMenuItem("View cart");
		viewCartItem.addActionListener(new viewCartButtonListener());
		menu.add(viewCartItem);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	public JPanel createHeader() {
	    JPanel header = new JPanel();
	    header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
	    
	    JLabel title = new JLabel("AIMS");
	    title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
	    title.setForeground(Color.CYAN);
	    
	    JButton cart = new JButton("View cart");
	    cart.setPreferredSize(new Dimension(100, 50));
	    cart.setMaximumSize(new Dimension(100, 50));
	    
	    header.add(Box.createRigidArea(new Dimension(10, 10)));
	    header.add(title);
	    header.add(Box.createHorizontalGlue());
	    header.add(cart);
	    header.add(Box.createRigidArea(new Dimension(10, 10)));
	    
	    return header;
	}
	
	public JPanel createCenter() {

	    JPanel center = new JPanel();
	    center.setLayout(new GridLayout());

	    ArrayList<Media> mediaInStore = store.getItemsInStore();
	    for (Media media: mediaInStore) {
	        MediaStore cell = new MediaStore(media, cart);
	        center.add(cell);
	    }

	    return center;
	}
	
	public StoreScreen(Store store) {
	    this.store = store;
	    this.cart = new Cart();
	    Container cp = getContentPane();
	    cp.setLayout(new BorderLayout());

	    cp.add(createNorth(), BorderLayout.NORTH);
	    this.centerPanel = createCenter();
	    cp.add(this.centerPanel, BorderLayout.CENTER);

	    setVisible(true);
	    setTitle("Store");
	    setSize(1024, 768);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void updateStoreDisplay() {
	    centerPanel.removeAll(); 
	    
	    ArrayList<Media> mediaInStore = store.getItemsInStore();
	    
	    for (Media m : mediaInStore) {
	        MediaStore cell = new MediaStore(m, cart);
	        centerPanel.add(cell);
	    }
	    
	    centerPanel.revalidate(); 
	    centerPanel.repaint();    
	}
	private class viewCartButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new CartScreen(cart, store);
			dispose();
		}
	}
	private class addBookButtonListener implements ActionListener {
		@Override
        public void actionPerformed(ActionEvent e) {
			JDialog addBookDialog = new JDialog();
			
			addBookDialog.setTitle("Adding a new media: ");
            addBookDialog.setLayout(new FlowLayout());
            
            JMenuBar menuBar = new JMenuBar();
            JMenu menuBook = new JMenu("options");
			menuBook.add(new JMenuItem("View store"));
			JMenuItem viewCartItem = new JMenuItem("View cart");
			viewCartItem.addActionListener(new viewCartButtonListener());
			menuBook.add(viewCartItem);
			menuBar.add(menuBook);
			
			addBookDialog.setJMenuBar(menuBar);
            
            addBookDialog.add(new Label("Title:"));
            JTextField title = new JTextField(10);
            title.setEditable(true);
            addBookDialog.add(title);
            
            addBookDialog.add(new Label("Category:"));
            JTextField category = new JTextField(10);
            category.setEditable(true);
            addBookDialog.add(category);
            
            addBookDialog.add(new Label("Cost:"));
            JTextField cost = new JTextField(10);
            cost.setEditable(true);
            addBookDialog.add(cost);
            
            
            JButton accept = new JButton("Accept");
            accept.addActionListener(new ActionListener() {
            	@Override public void actionPerformed(ActionEvent e) {
            		try {
	            		JDialog addedDialog = new JDialog();
	            		tempTitle = title.getText();
	            		tempCategory = category.getText();
	            		tempCost = cost.getText();
	            		float floatCost = Float.parseFloat(tempCost);
	            		store.addMedia(new Book(tempTitle, tempCategory, floatCost, null));
	            		
	            		updateStoreDisplay();
	            		
	            		addedDialog.setTitle("Added To store!");
	            		addedDialog.setLayout(new FlowLayout());
	                    
	            		addedDialog.setSize(300, 100);
	                    addedDialog.setLocationRelativeTo(StoreScreen.this);
	                    addedDialog.setVisible(true);
	                    
            		} catch (NumberFormatException e2) {
            			JDialog costErrorDialog = new JDialog();
            			costErrorDialog.setLayout(new FlowLayout());
            			costErrorDialog.setTitle("Error");
            			JLabel errorLabel = new JLabel();
            			errorLabel.setText("Cost must be a number!");
            			costErrorDialog.add(errorLabel);
            			costErrorDialog.setSize(200, 100);
            			costErrorDialog.setVisible(true);
            		}
            	};
            });
            addBookDialog.add(accept);
            
            JButton cancel = new JButton("Cancel");
            cancel.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {					
					addBookDialog.dispose();
            	};
            });
            addBookDialog.add(cancel);
                       
            addBookDialog.setSize(375, 200);
            addBookDialog.setVisible(true);
            
        }
	}
	
	private class addCDButtonListener implements ActionListener {
		@Override
        public void actionPerformed(ActionEvent e) {
			JDialog addBookDialog = new JDialog();
			addBookDialog.setTitle("Adding a new media: ");
            addBookDialog.setLayout(new FlowLayout());
            
            JMenuBar menuBar = new JMenuBar();
            JMenu menuCD = new JMenu("options");
			menuCD.add(new JMenuItem("View store"));
			JMenuItem viewCartItem = new JMenuItem("View cart");
			viewCartItem.addActionListener(new viewCartButtonListener());
			menuCD.add(viewCartItem);
			menuBar.add(menuCD);
			
			addBookDialog.setJMenuBar(menuBar);
			
            addBookDialog.add(new Label("Title:"));
            JTextField title = new JTextField(10);
            title.setEditable(true);
            addBookDialog.add(title);
            
            addBookDialog.add(new Label("Category:"));
            JTextField category = new JTextField(10);
            category.setEditable(true);
            addBookDialog.add(category);
            
            addBookDialog.add(new Label("Cost:"));
            JTextField cost = new JTextField(10);
            cost.setEditable(true);
            addBookDialog.add(cost);
            
            
            JButton accept = new JButton("Accept");
            accept.addActionListener(new ActionListener() {
            	@Override 
            	public void actionPerformed(ActionEvent e) {
            		try {
	            		JDialog addedDialog = new JDialog();
	            		tempTitle = title.getText();
	            		tempCategory = category.getText();
	            		tempCost = cost.getText();
	            		float floatCost = Float.parseFloat(tempCost);
	            		store.addMedia(new CompactDisc(tempTitle, tempCategory, floatCost, null, null));
	            		
	            		updateStoreDisplay();
	            		
	            		addedDialog.setTitle("Added To store!");
	            		addedDialog.setLayout(new FlowLayout());
	                    
	            		addedDialog.setSize(300, 100);
	                    addedDialog.setLocationRelativeTo(StoreScreen.this);
	                    addedDialog.setVisible(true);
	                    
            		} catch (NumberFormatException e2) {
            			JDialog costErrorDialog = new JDialog();
            			costErrorDialog.setLayout(new FlowLayout());
            			costErrorDialog.setTitle("Error");
            			JLabel errorLabel = new JLabel();
            			errorLabel.setText("Cost must be a number!");
            			costErrorDialog.add(errorLabel);
            			costErrorDialog.setSize(200, 100);
            			costErrorDialog.setVisible(true);
            		}
            	};
            });
            addBookDialog.add(accept);
            
            JButton cancel = new JButton("Cancel");
            cancel.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {					
					addBookDialog.dispose();
            	};
            });
            addBookDialog.add(cancel);
                       
            addBookDialog.setSize(375, 200);
            addBookDialog.setVisible(true);
            
    
		}
	
	}
		
	private class addDVDButtonListener implements ActionListener {
		@Override
        public void actionPerformed(ActionEvent e) {
			JDialog addBookDialog = new JDialog();

			addBookDialog.setTitle("Adding a new media: ");
            addBookDialog.setLayout(new FlowLayout());
            JMenuBar menuBar = new JMenuBar();
            JMenu menuDVD = new JMenu("options");
            menuDVD.add(new JMenuItem("View store"));
            JMenuItem viewCartItem = new JMenuItem("View cart");
    		viewCartItem.addActionListener(new viewCartButtonListener());
    		menuDVD.add(viewCartItem);
			menuBar.add(menuDVD);
			
			addBookDialog.setJMenuBar(menuBar);

            
            addBookDialog.add(new Label("Title:"));
            JTextField title = new JTextField(10);
            title.setEditable(true);
            addBookDialog.add(title);
            
            addBookDialog.add(new Label("Category:"));
            JTextField category = new JTextField(10);
            category.setEditable(true);
            addBookDialog.add(category);
            
            addBookDialog.add(new Label("Cost:"));
            JTextField cost = new JTextField(10);
            cost.setEditable(true);
            addBookDialog.add(cost);
            
            
            JButton accept = new JButton("Accept");
            accept.addActionListener(new ActionListener() {
            	@Override public void actionPerformed(ActionEvent e) {
            		try {
	            		JDialog addedDialog = new JDialog();
	            		tempTitle = title.getText();
	            		tempCategory = category.getText();
	            		tempCost = cost.getText();
	            		float floatCost = Float.parseFloat(tempCost);
	            		store.addMedia(new DigitalVideoDisc(tempTitle, tempCategory, floatCost));
	            		
	            		updateStoreDisplay();
	            		
	            		addedDialog.setTitle("Added To store!");
	            		addedDialog.setLayout(new FlowLayout());
	                    
	            		addedDialog.setSize(300, 100);
	                    addedDialog.setLocationRelativeTo(StoreScreen.this);
	                    addedDialog.setVisible(true);
	                    
	            	} catch (NumberFormatException e2) {
	        			JDialog costErrorDialog = new JDialog();
	        			costErrorDialog.setLayout(new FlowLayout());
	        			costErrorDialog.setTitle("Error");
	        			JLabel errorLabel = new JLabel();
	        			errorLabel.setText("Cost must be a number!");
	        			costErrorDialog.add(errorLabel);
	        			costErrorDialog.setSize(200, 100);
	        			costErrorDialog.setVisible(true);
	        		}
            	};
            });
            addBookDialog.add(accept);
            
            JButton cancel = new JButton("Cancel");
            cancel.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {					
					addBookDialog.dispose();
            	};
            });
            addBookDialog.add(cancel);
                       
            addBookDialog.setSize(375, 200);
            addBookDialog.setVisible(true);
            
        }
	}
}
