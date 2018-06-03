package chessDemo;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javafx.event.Event;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.removeMouseListener;




public class BoardMouseController implements MouseListener{



    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    	System.out.println("Start Point Clicked");
        ChessPanel selectedPanel = (ChessPanel)e.getSource();
        selectedPanel.setBackground(new Color(255, 248, 81));
        
        MoveManager instance = MoveManager.getInstance();
        Coordinate c = selectedPanel.getIndex();
        System.out.println("x is : " + c.x + ", y is " + c.y);
        instance.setPiece(c);
        instance.move(1, null);
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