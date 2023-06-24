package src.hust.soict.dsai.screen;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.ArrayList;
import src.hust.soict.dsai.aims.cart.Cart;
import src.hust.soict.dsai.aims.media.Book;
import src.hust.soict.dsai.aims.media.CompactDisc;
import src.hust.soict.dsai.aims.media.DigitalVideoDisc;
import src.hust.soict.dsai.aims.media.Media;
import src.hust.soict.dsai.aims.store.Store;
import src.hust.soict.dsai.screen.MediaStore;
import src.hust.soict.dsai.aims.media.Track;

public class StoreScreen extends JFrame{
    private Store store;
    private Cart cart;
    public void setStore(Store store) {
    	this.store=store;
    }
    public Store getStore() {
    	return store;
    }
    public Cart getCart() {
    	return cart;
    }
    //Create the method createNorth(), which will create our NORTH component: 
    JPanel createNorth(){
        JPanel north=new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;

    }
    JMenuBar createMenuBar(){
        JMenu menu=new JMenu("Options");
        JMenu smUpdateStore=new JMenu("Update Store");
        JMenuItem addBookMenuItem=new JMenuItem("Add Book");
        addBookMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddBookToStoreScreen addBookScreen=new AddBookToStoreScreen(StoreScreen.this,store);
				addBookScreen.setVisible(true);
			}
		});
        smUpdateStore.add(addBookMenuItem);
        JMenuItem addCDMenuItem=new JMenuItem("Add CD");
        addCDMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddCompactDiscToStoreScreen addCompactDiscToStoreScreen=new AddCompactDiscToStoreScreen(StoreScreen.this,store);
				addCompactDiscToStoreScreen.setVisible(true);
				
				
			}
		});
        smUpdateStore.add(addCDMenuItem);
        JMenuItem addDVDMenuItem=new JMenuItem("Add DVD");
        addDVDMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddDigitalVideoDiscToStoreScreen addDigitalVideoDiscToStoreScreen=new AddDigitalVideoDiscToStoreScreen(StoreScreen.this, store);
				addDigitalVideoDiscToStoreScreen.setVisible(true);
			}
		});
        smUpdateStore.add(addDVDMenuItem);
        menu.add(smUpdateStore);
        
        
        JMenuItem viewStoreMenuItem=new JMenuItem("View Store");
        viewStoreMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StoreScreen.this.setVisible(true);
				
			}
		});
        menu.add(viewStoreMenuItem);
        
        JMenuItem viewCartMenuItem=new JMenuItem("View Cart");
        viewCartMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CartScreen cartScreen=new CartScreen(cart,StoreScreen.this);
				cartScreen.setVisible(true);
				
			}
		});
        menu.add(viewCartMenuItem);

        JMenuBar menuBar=new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }
    /*Options
   |
   +-- Update Store
   |       |
   |       +-- Add Book
   |       |
   |       +-- Add CD
   |       |
   |       +-- Add DVD
   |
   +-- View Store
   |
   +-- View cart*/

    JPanel createHeader(){
        JPanel header=new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title=new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
        title.setForeground(Color.cyan);

        JButton cartButton=new JButton("View cart");
        cartButton.setPreferredSize(new Dimension(100,50));
        cartButton.setMaximumSize(new Dimension(100, 50));
        cartButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CartScreen cartScreen=new CartScreen(cart,StoreScreen.this);
				cartScreen.setVisible(true);
			}
		});

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10,10)));
        return header;

    }


    //THE CENTER COMPONENT
    JPanel createCenter(){
        JPanel center=new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaInStore=store.getItemsInStore();
        for (int i=0;i<mediaInStore.size();i++){
            MediaStore cell=new MediaStore(mediaInStore.get(i),cart);
            center.add(cell);
        }
        return center;
    }
    public void updateStoreContents() {
        getContentPane().removeAll(); // Remove the existing components
        getContentPane().add(createNorth(), BorderLayout.NORTH); // Add the updated components
        getContentPane().add(createCenter(), BorderLayout.CENTER);
        revalidate(); // Revalidate the frame to update the UI
        repaint(); // Repaint the frame to reflect the changes
    }
    
    
    
    public StoreScreen(Store store,Cart cart){
        this.store=store;
        this.cart=cart;
        Container cp=getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(),BorderLayout.NORTH);
        cp.add(createCenter(),BorderLayout.CENTER);
       
        setTitle("Store");
        setSize(1024,768);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        }
    
public static void main(String[] args){
        
        Store store = new Store();
        Cart cart=new Cart();
//        ArrayList<Track> tracks = new ArrayList<>();
//		tracks.add(new Track("Track 1", 240));
//		tracks.add(new Track("Track 2", 180));
//		tracks.add(new Track("Track 3", 210));
//
//		CompactDisc cd = new CompactDisc(4, "Album Title", "Music", 29.99f, "Artist Name","Hoang",tracks);
//		cd.setTrack(tracks);

        Media dvd1 = new DigitalVideoDisc("Star Wars 1", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd1);

        Media dvd2 = new DigitalVideoDisc("Star Wars 2", "Science Fiction", "George Lucas", 112, 29.95f);
        store.addMedia(dvd2);

//        List<String> authors1 = new ArrayList<>();
//        authors1.add("Author 1");
//        authors1.add("Author 2");
//        Media book1 = new Book(1, "Book Title 1", "Fantasy", 12.99f, authors1);
//        store.addMedia(book1);
//
//        List<String> authors2 = new ArrayList<>();
//        authors2.add("Author 3");
//        authors2.add("Author 4");
//        Media book2 = new Book(2, "Book Title 2", "Mystery", 14.99f, authors2);
//        store.addMedia(book2);

        // Add 3 more instances of media here

        StoreScreen storeScr = new StoreScreen(store,cart);
        

        
    }
        
}