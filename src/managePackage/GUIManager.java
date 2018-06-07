package managePackage;

import kr.ac.cau.mecs.lenerd.chess.ChessPieceSprite;
import kr.ac.cau.mecs.lenerd.chess.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

    public static JPanel promotionPanel() {

        JPanel pPanel = new JPanel();
        JPanel innerPanel = new JPanel();
        ImagePanel pQueen = new ImagePanel();
        ImagePanel pBishop = new ImagePanel();
        ImagePanel pRook = new ImagePanel();
        ImagePanel pKnight = new ImagePanel();

        pPanel.setLayout(null);
        innerPanel.setLayout(new GridLayout(2, 2));
        pQueen.setImage(ChessPieceSprite.getInstace().getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_QUEEN));
        pBishop.setImage(ChessPieceSprite.getInstace().getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_BISHOP));
        pRook.setImage(ChessPieceSprite.getInstace().getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_LOOK));
        pKnight.setImage(ChessPieceSprite.getInstace().getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_KNIGHT));
        innerPanel.setSize(120, 120);
        innerPanel.add(pQueen);
        innerPanel.add(pBishop);
        innerPanel.add(pRook);
        innerPanel.add(pKnight);
        pPanel.add(innerPanel);
        innerPanel.setBounds(0, 60, 120, 120);
        pQueen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Add Promotion Code
                //Maybe Include setVisible(false);
            }
        });
        pBishop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Add Promotion Code
                //Maybe Include setVisible(false);
            }
        });
        pRook.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Add Promotion Code
                //Maybe Include setVisible(false);
            }
        });
        pKnight.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Add Promotion Code
                //Maybe Include setVisible(false);
            }
        });




        return pPanel;
    }
}