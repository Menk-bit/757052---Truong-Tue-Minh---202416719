package hust.soict.dsai.aims.screen;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel{
    private Media media;
    private Cart cart;
    
    public MediaStore(Media media, Cart cart){
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JButton addMediaButton = new JButton("Add to cart");
        addMediaButton.addActionListener(new addMediaButtonListener());
        container.add(addMediaButton);
        if(media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new PlayButtonListener()); 
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    private class addMediaButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	cart.addMedia(media);
            JDialog playDialog = new JDialog();
            playDialog.setTitle("Added To cart!");
            playDialog.setLayout(new FlowLayout());
            
            playDialog.setSize(300, 100);
            playDialog.setLocationRelativeTo(MediaStore.this);
            playDialog.setVisible(true);
        }
    }
    
    private class PlayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog playDialog = new JDialog();
            playDialog.setTitle("Playing Media");
            playDialog.setLayout(new FlowLayout());

            JLabel message = new JLabel("Now playing: " + media.getTitle());
            playDialog.add(message);
            
            playDialog.setSize(300, 100);
            playDialog.setLocationRelativeTo(MediaStore.this);
            playDialog.setVisible(true);
        }
    }
}