package hust.soict.hedspi.aims.screen.customer.controller;

package hust.soict.hedspi.aims.screen;

import java.io.IOException;
import java.util.function.Predicate;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.binding.Bindings;
import javafx.beans.value.*;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	
	private Cart cart;
	private Store store;
	private FilteredList<Media> filteredMediaList;
	
	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediaCategory;
	
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	
	@FXML
    private Button btnPlaceOrder;
    
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;
    
    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Label lblTotalCost;
	
    
	
	public CartController(Cart cart, Store store) {
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
        
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
        		new ChangeListener<Media>() {
        			
        			@Override
        			public void changed(ObservableValue<? extends Media> observable, Media oldValue,
        					Media newValue) {
        				if(newValue != null) {
        					updateButtonBar(newValue);
        				}
        			}
        		});
        
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
        	@Override
        	public void changed(ObservableValue<? extends String> observable, String oldValue,
        			String newValue) {
        		showFilteredMedia(newValue);
        	}
        });
        
        filteredMediaList = new FilteredList<>(cart.getItemsOrdered(), null);
        tblMedia.setItems(filteredMediaList);
        lblTotalCost.textProperty().bind(Bindings.format("$%.2f", cart.totalCost()));
        
	}
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		}else {
			btnPlay.setVisible(false);
		}
	}
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
	}
	
	void showFilteredMedia(String filter) {
		filteredMediaList.setPredicate(new Predicate<Media>(){
			@Override
			public boolean test(Media media) {
				if (filter == null || filter.isEmpty()) {
					return true;
				}
				if (radioBtnFilterId.isSelected()) {
					return String.valueOf(media.getId()).contains(filter);
				}else {
					return media.getTitle().toLowerCase().contains(filter.toLowerCase());
				}
			}
		});
	}
	
	@FXML
	void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            ((Playable) media).play();
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        // Place order logic here
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been placed successfully!");
        alert.showAndWait();
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/store_screen.fxml"));
            loader.setController(new ViewStoreController(store, cart));
            Parent storeRoot = loader.load();
            Scene storeScene = new Scene(storeRoot);
            Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(storeScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

