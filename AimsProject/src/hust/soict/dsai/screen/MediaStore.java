package src.hust.soict.dsai.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import src.hust.soict.dsai.aims.media.Media;
import src.hust.soict.dsai.aims.cart.Cart;
import src.hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
	private Media media;
	private Cart cart;
    public MediaStore(Media media,Cart cart){
        this.media=media;
        this.cart=cart;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        JLabel title=new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost=new JLabel("           "+media.getCost()+"$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container=new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartButton=new JButton("Add to cart");
        addToCartButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cart.addMedia(media);
				JDialog playDialog=new JDialog();
				JLabel label1=new JLabel("Media Add");
				cart.printCart();
				playDialog.add(label1);
				playDialog.setSize(100,100);
				playDialog.setVisible(true);
			}
        });
        	
        
        container.add(addToCartButton);
        
        if (media instanceof Playable) {
        	JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Play the media in a dialog window
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Media Player");
                    dialog.setSize(400, 300);
                    // Implement the logic to play the media here
                    dialog.setVisible(true);
                }
            });
            container.add(playButton);
        }
        
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createHorizontalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    

}
