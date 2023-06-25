package src.hust.soict.dsai.screen;
import java.io.IOException;
import src.hust.soict.dsai.aims.media.DigitalVideoDisc;
import src.hust.soict.dsai.aims.media.Track;
import src.hust.soict.dsai.aims.media.CompactDisc;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import src.hust.soict.dsai.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
	private Cart cart;
	private StoreScreen storeScreen;
	public CartScreen(Cart cart,StoreScreen storeScreen) {
		super();
		this.cart=cart;
		this.storeScreen=storeScreen;
		
		
		JFXPanel fxPanel=new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					FXMLLoader loader=new FXMLLoader(getClass().getResource("/src/hust/soict/dsai/screen/cart.fxml"));
					CartScreenController controller=new CartScreenController(cart,storeScreen); 
					loader.setController(controller);
					Parent root=loader.load();
					fxPanel.setScene(new Scene(root));
					
					
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		});
	}
//	public static void main(String[] args) throws Exception{
//        Cart cart = new Cart();
//        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
//				"Animation",87, "Roger Allers", 19.95f);
//		cart.addMedia(dvd1);
//		
//		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
//				"Science Fiction",87, "George Lucas", 24.95f);
//		cart.addMedia(dvd2);
//		
//		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
//				"Animation", 18.99f);
//        cart.addMedia(dvd3);
//        new CartScreen(cart);
//	}
}
