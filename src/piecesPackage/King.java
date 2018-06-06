package piecesPackage;

import managePackage.ChessPanel;
import kr.ac.cau.mecs.lenerd.chess.ChessPieceSprite;
import managePackage.ColorM;
import managePackage.Coordinate;
import managePackage.TurnManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class King extends Piece {
	ChessPieceSprite instance = ChessPieceSprite.getInstace();

	public King(int x, int y) {
		super(x, y);
	}

	public BufferedImage imageSetting(int team) {
		BufferedImage image1 = null;
		if (team == 0)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_KING);
		else if (team == 1)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_KING);
		else if(team == 2)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.RED_KING);
		else if(team == 3)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.GREEN_KING);
		return image1;
	}

	@Override
	public void highlight(ChessPanel[][] boardPiece, Coordinate c) {

		try {
			if (boardPiece[c.x - 1][c.y - 1].piece == null) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y - 1]))
					boardPiece[c.x - 1][c.y - 1].setBackground(ColorM.moveH);
			} else if (boardPiece[c.x - 1][c.y - 1].piece.team != TurnManager.turn) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y - 1]))
					boardPiece[c.x - 1][c.y - 1].setBackground(ColorM.attackH);
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {
		}

		try {
			if (boardPiece[c.x - 1][c.y].piece == null) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y]))
					boardPiece[c.x - 1][c.y].setBackground(ColorM.moveH);
			} else if (boardPiece[c.x - 1][c.y].piece.team != TurnManager.turn) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y]))
					boardPiece[c.x - 1][c.y].setBackground(ColorM.attackH);
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {
		}

		try {
			if (boardPiece[c.x - 1][c.y + 1].piece == null) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y + 1]))
					boardPiece[c.x - 1][c.y + 1].setBackground(ColorM.moveH);
			} else if (boardPiece[c.x - 1][c.y + 1].piece.team != TurnManager.turn) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y + 1]))
					boardPiece[c.x - 1][c.y + 1].setBackground(ColorM.attackH);
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {
		}

		try {
			if (boardPiece[c.x][c.y - 1].piece == null) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y - 1]))
					boardPiece[c.x][c.y - 1].setBackground(ColorM.moveH);
			} else if (boardPiece[c.x][c.y - 1].piece.team != TurnManager.turn) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y - 1]))
					boardPiece[c.x][c.y - 1].setBackground(ColorM.attackH);
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {
		}

		try {
			if (boardPiece[c.x][c.y + 1].piece == null) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y + 1]))
					boardPiece[c.x][c.y + 1].setBackground(ColorM.moveH);
			} else if (boardPiece[c.x][c.y + 1].piece.team != TurnManager.turn) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y + 1]))
					boardPiece[c.x][c.y + 1].setBackground(ColorM.attackH);
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {
		}

		try {
			if (boardPiece[c.x + 1][c.y - 1].piece == null) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y - 1]))
					boardPiece[c.x + 1][c.y - 1].setBackground(ColorM.moveH);
			} else if (boardPiece[c.x + 1][c.y - 1].piece.team != TurnManager.turn) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y - 1]))
					boardPiece[c.x + 1][c.y - 1].setBackground(ColorM.attackH);
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {
		}

		try {
			if (boardPiece[c.x + 1][c.y].piece == null) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y]))
					boardPiece[c.x + 1][c.y].setBackground(ColorM.moveH);
			} else if (boardPiece[c.x + 1][c.y].piece.team != TurnManager.turn) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y]))
					boardPiece[c.x + 1][c.y].setBackground(ColorM.attackH);
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {
		}

		try {
			if (boardPiece[c.x + 1][c.y + 1].piece == null) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y + 1]))
					boardPiece[c.x + 1][c.y + 1].setBackground(ColorM.moveH);
			} else if (boardPiece[c.x + 1][c.y + 1].piece.team != TurnManager.turn) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y + 1]))
					boardPiece[c.x + 1][c.y + 1].setBackground(ColorM.attackH);
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {
		}
	}
}

