package managePackage;

import javax.swing.*;
import java.awt.*;

public class ChessBoard {


    private int i, j;
    JPanel game1v1Panel = new JPanel();
    JPanel boardPanel = new JPanel();
    ChessPanel[][] boardPiece;
    public static ChessPanel[][] deathPieceLeft;
    public static ChessPanel[][] deathPieceRight;

    public JPanel makeGamePanel() {
        JPanel boardPanel;
        JPanel[] deathPanel;

        boardPanel = makeBoard();
        deathPanel = makeDeathBoard();

        game1v1Panel.setSize(1280, 720);
        game1v1Panel.setLayout(null);

        game1v1Panel.add(boardPanel);
        game1v1Panel.add(deathPanel[0]);
        game1v1Panel.add(deathPanel[1]);

        boardPanel.setBounds(340, 60, 600, 600);
        deathPanel[0].setBounds(170, 60, 600 / 4, 600);
        deathPanel[1].setBounds(960, 60, 600 / 4, 600);

        /*JPanel forTitle = new JPanel();
        forTitle.setSize(1280, 145);
        game1v1Panel.add(forTitle, BorderLayout.NORTH);
        */
        return game1v1Panel;
    }

    public JPanel makeBoard() {

        boardPiece = new ChessPanel[8][8];
        boardPanel.setPreferredSize(new Dimension(600, 600));

        boardPanel.setLayout(new GridLayout(8, 8));

        for(i = 0; i < 8; ++i) {
            for(j = 0; j < 8; ++j) {
                boardPiece[i][j] = new ChessPanel();
                boardPiece[i][j].setSize(600 / 8, 600 / 8);
                boardPiece[i][j].setOpaque(true);
                if((j + i) % 2 == 0)
                    boardPiece[i][j].setBackground(new Color(219, 219, 219));
                else
                    boardPiece[i][j].setBackground(new Color(156, 156, 156));

                boardPanel.add(boardPiece[i][j]);

                boardPiece[i][j].setIndex(i, j);

            }
        }
        return boardPanel;
    }

    public JPanel[] makeDeathBoard() {
        JPanel[] deathPanel = new JPanel[2];
        deathPanel[0] = new JPanel(); // left
        deathPanel[1] = new JPanel(); // right

        deathPieceLeft = new ChessPanel[8][2];
        deathPieceRight = new ChessPanel[8][2];

        deathPanel[0].setSize(600/4, 600);
        deathPanel[0].setLayout(new GridLayout(8,2));
        deathPanel[1].setSize(600/4, 600);
        deathPanel[1].setLayout(new GridLayout(8,2));

        for(i = 0; i < 8; i++) {
            for(j = 0; j < 2; j++) {
                deathPieceLeft[i][j] = new ChessPanel();
                deathPieceLeft[i][j].setSize(600 / 8, 600 / 8);
                deathPieceLeft[i][j].setOpaque(true);
                deathPieceLeft[i][j].setBackground(new Color(68, 126, 150, 200));
                deathPieceLeft[i][j].setIndex(i, j);
                deathPanel[0].add(deathPieceLeft[i][j]);
            }
        }
        for(i = 0; i < 8; i++) {
            for(j = 0; j < 2; j++) {
                deathPieceRight[i][j] = new ChessPanel();
                deathPieceRight[i][j].setSize(600 / 8, 600 / 8);
                deathPieceRight[i][j].setOpaque(true);
                deathPieceRight[i][j].setBackground(new Color(68, 126, 150, 200));
                deathPieceRight[i][j].setIndex(i, j);
                deathPanel[1].add(deathPieceRight[i][j]);
            }
        }
        return deathPanel;
    }
}


