package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	
	private Store store;
	
    private Cart cart;
    
    @FXML
    private Label TotalCost;
    
    @FXML
    private Button btnPlaceOrder;
    
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    public CartScreenController(Cart cart, Store store) {
        super();
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());
        
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        
        updateTotalCost();
        
        this.cart.getItemsOrdered().addListener((javafx.collections.ListChangeListener.Change<? extends Media> c) -> {
            updateTotalCost();
        });
        
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
        		new ChangeListener<Media>() {
        			
        			@Override
        			public void changed(ObservableValue<? extends Media> observable, Media oldValue,
        					Media newValue) {
        				if (newValue!=null) {
        					updateButtonBar(newValue);
        				}
        			}
        		});
        
    }
    
    private void updateTotalCost() {
        float total = cart.totalCost();
        TotalCost.setText(String.format("%.2f $", total));
    }
    
    void updateButtonBar(Media media) {
    	btnRemove.setVisible(true);
    	if(media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}
    	else {
    		btnPlay.setVisible(false);
    	}
    }
    
    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    }
    
    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	if (media instanceof Playable) {
    		 ((Playable) media).play();
    	};
    }
    
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
    	cart.getItemsOrdered().clear();
    }
    
    @FXML
    void viewStoreItemPressed(ActionEvent event) {
    	new StoreScreen(store);
    }
}
