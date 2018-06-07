package piecesPackage;

import managePackage.ChessPanel;
import kr.ac.cau.mecs.lenerd.chess.ChessPieceSprite;
import managePackage.ColorM;
import managePackage.Coordinate;
import managePackage.GameManager;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Bishop extends Piece {
	ChessPieceSprite instance = ChessPieceSprite.getInstace();

    public Bishop(int x, int y) {
        this.x = x;
        this.y = y;
    }
	public BufferedImage imageSetting(int team)
	{
        BufferedImage image1 = null;
	    if(GameManager.gameType == 1) {
	        if(team == 0)
                image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_BISHOP);
	        else if(team == 1)
                image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_BISHOP);

        }
	    else if(GameManager.gameType == 2) {

            if (team == 0)
                image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_BISHOP);
            else if (team == 1)
                image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.RED_BISHOP);
            else if (team == 2)
                image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_BISHOP);
            else if (team == 3)
                image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.GREEN_BISHOP);

        }
        return image1;
	}
	@Override
	public void highlight(ChessPanel[][] boardPiece, Coordinate c)
	{
        for (int i = -1; i < 2; i += 2) {
            try {
                for (int j = 1;; j++) {
                    if (boardPiece[c.x + (i) * j][c.y + (i) * j].piece == null) {
                        if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + (i) * j][c.y + (i) * j]))
                            boardPiece[c.x + (i) * j][c.y + (i) * j].setBackground(ColorM.moveH);
                    }
                    else {
                        if (boardPiece[c.x + (i) * j][c.y + (i) * j].piece.team % 2 != this.team % 2
                                 && boardPiece[c.x + i * j][c.y + i * j].piece.team > -1) {
                            if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + (i) * j][c.y + (i) * j]))
                                boardPiece[c.x + (i) * j][c.y + (i) * j].setBackground(ColorM.attackH);
                        }
                        break;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {}
        }
        for (int i = -1; i < 2; i += 2) {
            try {
                for (int j = 1;; j++) {
                    if (boardPiece[c.x + (i) * j][c.y - (i) * j].piece == null) {
                        if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + (i) * j][c.y - (i) * j]))
                            boardPiece[c.x + (i) * j][c.y - (i) * j].setBackground(ColorM.moveH);
                    }
                    else {
                        if (boardPiece[c.x + (i) * j][c.y - (i) * j].piece.team % 2 != this.team % 2
                                 && boardPiece[c.x + i * j][c.y - i * j].piece.team > -1) {
                            if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + (i) * j][c.y - (i) * j]))
                                boardPiece[c.x + (i) * j][c.y - (i) * j].setBackground(ColorM.attackH);
                        }
                        break;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {}
        }
	}
}
