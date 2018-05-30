import javax.swing.*;


import java.awt.*;
import java.awt.image.BufferedImage;

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

    void makeBoard(ImagePanel boardPanel, int type) {
        if(type == 1) {
            boardPanel.setSize(575, 575);
            boardPanel.setLayout(new GridLayout(8, 8));
            ImagePanel[][] boardPiece = new ImagePanel[8] [8];
            for(int i = 0; i < 8; ++i) {
                for(int j = 0; j < 8; ++j) {
                    boardPiece[i][j] = new ImagePanel();
                    boardPiece[i][j].setSize(575 / 8, 575 / 8);
                    boardPiece[i][j].setOpaque(true);
                    
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

            resetPiece(boardPiece, 1);
            
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    boardPanel.add(boardPiece[i][j]);
                }
            }
            
        }

    }

    void resetPiece(ImagePanel boardPiece[][], int type) {
        ChessPieceSprite instance = ChessPieceSprite.getInstace();
        BufferedImage pieceImage;
        for(int i = 0; i < 8; i++) {
            pieceImage = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_PAWN);
            boardPiece[1][i].setImage(pieceImage);
            pieceImage = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_PAWN);
            boardPiece[6][i].setImage(pieceImage);
        }
        pieceImage = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_KNIGHT);
        boardPiece[0][1].setImage(pieceImage);
        boardPiece[0][6].setImage(pieceImage);

        pieceImage = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_KNIGHT);
        boardPiece[7][1].setImage(pieceImage);
        boardPiece[7][6].setImage(pieceImage);

        pieceImage = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_LOOK);
        boardPiece[0][0].setImage(pieceImage);
        boardPiece[0][7].setImage(pieceImage);

        pieceImage = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_LOOK);
        boardPiece[7][0].setImage(pieceImage);
        boardPiece[7][7].setImage(pieceImage);

        pieceImage = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_BISHOP);
        boardPiece[0][2].setImage(pieceImage);
        boardPiece[0][5].setImage(pieceImage);

        pieceImage = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_BISHOP);
        boardPiece[7][2].setImage(pieceImage);
        boardPiece[7][5].setImage(pieceImage);

        pieceImage = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_QUEEN);
        boardPiece[0][3].setImage(pieceImage);

        pieceImage = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_KING);
        boardPiece[0][4].setImage(pieceImage);

        pieceImage = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_QUEEN);
        boardPiece[7][4].setImage(pieceImage);

        pieceImage = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_KING);
        boardPiece[7][3].setImage(pieceImage);
    }
    
    

}

