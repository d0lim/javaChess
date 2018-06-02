package chessDemo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PieceMouseController implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        //Add Highlighting 'IF'
        System.out.println("Destination Clicked");
        ChessPanel destination = (ChessPanel)e.getSource();
        Coordinate c = destination.getIndex();
        System.out.println("x is : " + c.x + ", y is " + c.y);
        MoveManager instance = MoveManager.getInstance();
        instance.move(2, c);
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
}