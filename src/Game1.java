import java.awt.BorderLayout;

import javax.swing.*;

public class Game1 {
    public static void main(String args[]) {
        JFrame frame = new JFrame("1v1");
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 20));
        ChessBoard board1 = new ChessBoard();
        
        frame.add(board1.makePanel(1), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}

