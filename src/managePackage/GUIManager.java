package managePackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUIManager {
    public static void showWinner1() {
        final Frame fs = new Frame("Checkmate!!!");
        JLabel cmtext = new JLabel();
        if(TurnManager.turn == 0)
            cmtext.setText("Black Win!!! Go Main");
        if(TurnManager.turn == 1)
            cmtext.setText("White Win!!! Go Main");
        fs.setLayout(null);

        fs.add(cmtext);
        fs.setVisible(true);
        fs.setSize(250, 150);
        fs.setLocation(515, 285);
        cmtext.setBounds(80, 0, 250, 150);

        fs.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                fs.setVisible(false);
                fs.dispose();
            }
        });
    }
    public static void showDraw() {
        final Frame fs = new Frame("STALEMATE!!!");
        JLabel cmtext = new JLabel();
        cmtext.setText("Draw!!! Go Main");
        fs.setLayout(null);

        fs.add(cmtext);
        fs.setVisible(true);
        fs.setSize(250, 150);
        fs.setLocation(515, 285);
        cmtext.setBounds(80, 0, 250, 150);

        fs.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                fs.setVisible(false);
                fs.dispose();
            }
        });
    }
}