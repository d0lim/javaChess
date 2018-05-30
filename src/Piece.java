import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class Piece {

    public void move(ImagePanel p, ImagePanel boardPiece[][]) { //when mouse is clicked
        
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                boardPiece[i][j].addMouseListener(new MouseListener(){
                    
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ImagePanel q = (ImagePanel)e.getSource();
                        q.setBackground(Color.DARK_GRAY);
                        System.out.println("DestinationClicked");


                        BufferedImage buffer = p.getImage();
                        p.setImage(null);

                        q.setImage(buffer);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
            }
        }
        //here is mouse event

        
    }
    
}

