package src.hust.soict.dsai.screen;

import src.hust.soict.dsai.aims.cart.Cart;
import src.hust.soict.dsai.aims.exception.PlayerException;
import src.hust.soict.dsai.aims.media.Media;
import src.hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private Cart cart;
	private StoreScreen storeScreen;
	@FXML
    private MenuItem menuAddBook;

    @FXML
    private MenuItem menuAddCD;

    @FXML
    private MenuItem menuAddDVD;
	 @FXML
	private MenuItem optionViewStore;
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button placeOrderButton;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private Label totalCostLabel;
    
    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;
    
    public CartScreenController(Cart cart,StoreScreen storeScreen) {
    	super();
    	this.cart=cart;
    	this.storeScreen=storeScreen;
    }
    
    @FXML 
    private void initialize() {
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	tblMedia.setItems(this.cart.getItemsOrdered());
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {

			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				// TODO Auto-generated method stub
				if (newValue!=null) {
					updateButtonBar(newValue);
				}
				
			}
    		
		});
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				showFilteredMedia(newValue);
				
			}
		});
    	cart.getItemsOrdered().addListener(
                new ListChangeListener<Media>() {
                    @Override
                    public void onChanged(Change<? extends Media> change) {
                        updateTotalCost();
                    }
                }
            );

            // Update the total cost initially
            updateTotalCost();
    	
    	 
    }
 // Update button bar method
    
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }
    
    void showFilteredMedia(String filterText) {
    	//Wrap the ObservableValue in a FilteredList
    	FilteredList<Media> filteredList=new FilteredList<>(this.cart.getItemsOrdered());
    	filteredList.setPredicate(media ->{
    		if (radioBtnFilterId.isSelected()) {
    			String mediaId=String.valueOf(media.getId());
    			return mediaId.contains(filterText);
    		} else if (radioBtnFilterTitle.isSelected()) {
    			String mediaTitle=media.getTitle().toLowerCase();
    			return mediaTitle.contains(filterText.toLowerCase());
    		}
    		return true;
    	});
    	tblMedia.setItems(filteredList);
    }
    

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
    	if (cart.getItemsOrdered().isEmpty()){
    		Alert alert=new Alert(AlertType.ERROR);
    		alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("The cart is empty. Please add items to the cart before placing an order.");
            alert.showAndWait();
    		
    	}else {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Placed");
            alert.setHeaderText(null);
            alert.setContentText("Your order has been placed successfully!");
            alert.showAndWait();
            cart.getItemsOrdered().clear();
            updateTotalCost();
            tblMedia.refresh();
            
    	}
    	
    }
    private void updateTotalCost() {
    
        totalCostLabel.setText("$"+ String.valueOf(cart.totalCost()));
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
    	Media media=tblMedia.getSelectionModel().getSelectedItem();
    	if (media instanceof Playable) {
    		try{
    			((Playable) media).play();
    		} catch (PlayerException e) {
    			e.printStackTrace();
    		}
    	}
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media=tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);

    }
    @FXML
    void viewStorePressed(ActionEvent event) {
    	storeScreen.updateStoreContents();
    	storeScreen.setVisible(true);
        
    	
    }
    @FXML
    void menuAddBookPressed(ActionEvent event) {
    	AddBookToStoreScreen newScreen=new AddBookToStoreScreen(storeScreen, storeScreen.getStore());
    	newScreen.setVisible(true);
    }

    @FXML
    void menuAddCDPressed(ActionEvent event) {
    	AddCompactDiscToStoreScreen newScreen=new AddCompactDiscToStoreScreen(storeScreen, storeScreen.getStore());
    	newScreen.setVisible(true);
    }

    @FXML
    void menuAddDVDPressed(ActionEvent event) {
    	AddDigitalVideoDiscToStoreScreen newScreen=new AddDigitalVideoDiscToStoreScreen(storeScreen, storeScreen.getStore());
    	newScreen.setVisible(true);

    }
    

}



