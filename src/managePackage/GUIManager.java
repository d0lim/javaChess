package managePackage;

import javax.swing.*;
import java.awt.*;

public class GUIManager {
    public void show1Chess() {
        JFrame frame = new JFrame();
/*
        ChessBoard chess1 = new ChessBoard();
        JPanel centerPanel;
        centerPanel = chess1.makePanel(1);
        frame.add(centerPanel);
        frame.setSize(1280,720);
        frame.setVisible(true);*/
    }

    public static JPanel showCheckmate() {
        JPanel gameOver = new JPanel();
        gameOver.setLayout(null);
        gameOver.setSize(500, 300);
        JLabel overLabel = new JLabel("SelfRiskCheck");
        gameOver.add(overLabel);
        overLabel.setBounds(50, 70, 200, 80);
        JButton homeButton = new JButton("HOME");
        gameOver.add(homeButton);
        homeButton.setBounds(200, 170, 100, 100);
        homeButton.setBackground(new Color(177, 153, 255));
        return gameOver;
    }
}