package piecesPackage;

import managePackage.ChessPanel;
import kr.ac.cau.mecs.lenerd.chess.ChessPieceSprite;
import managePackage.ColorM;
import managePackage.Coordinate;
import managePackage.GameManager;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Pawn extends Piece {

    ChessPieceSprite instance = ChessPieceSprite.getInstace();

    public Pawn(int x, int y) {
        this.x = x;
        this.y = y;
    }
	Color moveC = ColorM.moveH;
	Color attackC = ColorM.attackH;

	public BufferedImage imageSetting(int team)
	{
		BufferedImage image1 = null;
		if(GameManager.gameType == 1) {
			if(team == 0)
				image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_PAWN);
			else if(team == 1)
				image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_PAWN);

		}
		else if(GameManager.gameType == 2) {

			if (team == 0)
				image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_PAWN);
			else if (team == 1)
				image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.RED_PAWN);
			else if (team == 2)
				image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_PAWN);
			else if (team == 3)
				image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.GREEN_PAWN);

		}
		return image1;
	}
	@Override
	public void highlight(ChessPanel[][] boardPiece, Coordinate c) {

		if (this.team == 0) {
			if (c.x == 1) {
				moveC = ColorM.SpecialH;
				attackC = ColorM.SpecialAH;
			}
			if (boardPiece[c.x - 1][c.y].piece == null) {
			    if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y])) {
                    boardPiece[c.x - 1][c.y].setBackground(moveC);
                }
			}
            if (c.x == 6 && (boardPiece[c.x - 2][c.y].piece == null && boardPiece[c.x - 1][c.y].piece == null)) {
                if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 2][c.y]))
                    boardPiece[c.x - 2][c.y].setBackground(moveC);
            }

			try {
				if (boardPiece[c.x - 1][c.y + 1].piece != null && boardPiece[c.x - 1][c.y + 1].piece.team % 2 == 1) {
				    if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y + 1]))
                        boardPiece[c.x - 1][c.y + 1].setBackground(attackC);
                }
			} catch (ArrayIndexOutOfBoundsException ignored) {}
			try {
				if (boardPiece[c.x - 1][c.y - 1].piece != null && boardPiece[c.x - 1][c.y - 1].piece.team % 2 == 1) {
				    if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y - 1]))
                        boardPiece[c.x - 1][c.y - 1].setBackground(attackC);
                }
			} catch (ArrayIndexOutOfBoundsException ignored) {}

		} else if (this.team == 1) {
			if (c.x == 6) {
				moveC = ColorM.SpecialH;
				attackC = ColorM.SpecialAH;
			}
			if (boardPiece[c.x + 1][c.y].piece == null) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y])) {
					boardPiece[c.x + 1][c.y].setBackground(moveC);
				}
			}
			if (c.x == 1 && (boardPiece[c.x + 2][c.y].image == null && boardPiece[c.x + 1][c.y].image == null)) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 2][c.y]))
					boardPiece[c.x + 2][c.y].setBackground(moveC);
			}

			try {
				if (boardPiece[c.x + 1][c.y + 1].image != null && boardPiece[c.x + 1][c.y + 1].piece.team % 2 == 0) {
					if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y + 1]))
						boardPiece[c.x + 1][c.y + 1].setBackground(attackC);
				}
			} catch (ArrayIndexOutOfBoundsException ignored) {}

			try {
				if (boardPiece[c.x + 1][c.y - 1].image != null && boardPiece[c.x + 1][c.y - 1].piece.team % 2 == 0) {
					if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y - 1]))
						boardPiece[c.x + 1][c.y - 1].setBackground(attackC);
				}
			} catch (ArrayIndexOutOfBoundsException ignored) {}
		}
	}
}
