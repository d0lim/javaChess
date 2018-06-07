package managePackage;

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

        MoveManager instance = MoveManager.getInstance();
        ChessPanel destination = (ChessPanel)e.getSource();

        if(destination.getBackground().equals(ColorM.moveH)) {
            System.out.println("Move Destination Clicked");
            Coordinate c = destination.getIndex();
            System.out.println("x is : " + c.x + ", y is " + c.y);
            instance.move(2, c);
        }
        else if(destination.getBackground().equals(ColorM.attackH)) {
            System.out.println("Attacking!");
            Coordinate c = destination.getIndex();
            System.out.println("x is : " + c.x + ", y is " + c.y);
            instance.move(3, c);
        }
        else if(destination.getBackground().equals(ColorM.SpecialH)) {
            Coordinate c = destination.getIndex();
            instance.move( 4, c);
        }
        else if(destination.getBackground().equals(ColorM.SpecialAH)){
            Coordinate c = destination.getIndex();
            instance.move( 5, c);
        }
        else
            instance.move(6, null);
        
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