import javax.swing.*;
import java.awt.*;

public class ChessBoard {

    public ImagePanel makePanel(int type) {
        ImagePanel boardPanel = new ImagePanel();

        if(type == 1) {
            int [][] pieceOn = {{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}};
            

            makeBoard(boardPanel, type);
            
        }


        return boardPanel;
    }

    private void makeBoard(ImagePanel boardPanel, int type) {
        if(type == 1) {
            boardPanel.setLayout(new GridLayout(8, 8));
            boardPanel.setSize(575, 575);
            JButton[][] boardPiece = new JButton[8] [8];
            for(int i = 0; i < 8; ++i) {
                for(int j = 0; j < 8; ++j) {
                    boardPiece[i][j] = new JButton();
                    boardPiece[i][j].setSize(575 / 8, 575 / 8);
                    
                }
            }

            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    if((j + i) % 2 == 0)
                        boardPiece[i][j].setBackground(new Color(254, 253, 207));
                    else
                        boardPiece[i][j].setBackground(new Color(242, 157, 76));
                }
            }
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    boardPanel.add(boardPiece[i][j]);
                }
            }
        }
    }
    
    

}
