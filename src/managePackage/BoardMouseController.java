package managePackage;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class BoardMouseController implements MouseListener{

	TurnManager turnChecker = new TurnManager();

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    	System.out.println("Start Point Clicked");
    	MoveManager instance = MoveManager.getInstance();
        ChessPanel selectedPanel = (ChessPanel)e.getSource();
        if(turnChecker.turn == selectedPanel.piece.team) {
            selectedPanel.setBackground(new Color(255, 248, 81));
            Coordinate c = selectedPanel.getIndex();
            System.out.println("x is : " + c.x + ", y is " + c.y);
            instance.setPiece(c);
            instance.move(1, null);
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