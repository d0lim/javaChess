package chessDemo;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PieceMouseController implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    	//Add Highlighting 'IF'
        Color moveH = new Color(145, 255, 228);
        Color attackH = new Color(255, 97, 160);

        MoveManager instance = MoveManager.getInstance();
        ChessPanel destination = (ChessPanel)e.getSource();
        if(destination.getBackground().equals(moveH) || destination.getBackground().equals(attackH)) {
            System.out.println("Destination Clicked");
            Coordinate c = destination.getIndex();
            System.out.println("x is : " + c.x + ", y is " + c.y);
            instance.move(2, c);
        }
        else {
            System.out.println("Unfortunately, that was not a Destination!!");
            instance.move(3, null);
        }
        
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
}