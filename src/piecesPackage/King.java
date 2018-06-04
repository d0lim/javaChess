package piecesPackage;

import chessDemo.ChessPanel;
import kr.ac.cau.mecs.lenerd.chess.ChessPieceSprite;
import chessDemo.Coordinate;
import chessDemo.TurnManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class King extends Piece {
	ChessPieceSprite instance = ChessPieceSprite.getInstace();

	public BufferedImage imageSetting(int team) {
		BufferedImage image1 = null;
		if (team == 0)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_KING);
		else if (team == 1)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_KING);
		return image1;
	}

	@Override
	public void highlight(ChessPanel[][] boardPiece, Coordinate c) {

		try {
			if (checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y - 1]) == false) {
				if (boardPiece[c.x - 1][c.y - 1].image == null) {
					boardPiece[c.x - 1][c.y - 1].setBackground(new Color(145, 255, 228));
				} else if (boardPiece[c.x - 1][c.y - 1].piece.team != TurnManager.turn)
					boardPiece[c.x - 1][c.y - 1].setBackground(new Color(255, 97, 160));
			}

		} catch (ArrayIndexOutOfBoundsException ignore) {
		}
		try {
			if (checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y]) == false) {
				if (boardPiece[c.x - 1][c.y].image == null) {
					boardPiece[c.x - 1][c.y].setBackground(new Color(145, 255, 228));
				} else if (boardPiece[c.x - 1][c.y].piece.team != TurnManager.turn)
					boardPiece[c.x - 1][c.y].setBackground(new Color(255, 97, 160));
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {
		}
		try {
			if (checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y + 1]) == false) {
				if (boardPiece[c.x - 1][c.y + 1].image == null) {
					boardPiece[c.x - 1][c.y + 1].setBackground(new Color(145, 255, 228));
				} else if (boardPiece[c.x - 1][c.y + 1].piece.team != TurnManager.turn)
					boardPiece[c.x - 1][c.y + 1].setBackground(new Color(255, 97, 160));
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {
		}
		try {
			if (checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y - 1]) == false) {
				if (boardPiece[c.x][c.y - 1].image == null) {
					boardPiece[c.x][c.y - 1].setBackground(new Color(145, 255, 228));
				} else if (boardPiece[c.x][c.y - 1].piece.team != TurnManager.turn)
					boardPiece[c.x][c.y - 1].setBackground(new Color(255, 97, 160));
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {
		}
		try {
			if (checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y + 1]) == false) {
				if (boardPiece[c.x][c.y + 1].image == null) {
					boardPiece[c.x][c.y + 1].setBackground(new Color(145, 255, 228));
				} else if (boardPiece[c.x][c.y + 1].piece.team != TurnManager.turn)
					boardPiece[c.x][c.y + 1].setBackground(new Color(255, 97, 160));
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {
		}
		try {
			if (checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y - 1]) == false) {
				if (boardPiece[c.x + 1][c.y - 1].image == null) {
					boardPiece[c.x + 1][c.y - 1].setBackground(new Color(145, 255, 228));
				} else if (boardPiece[c.x + 1][c.y - 1].piece.team != TurnManager.turn)
					boardPiece[c.x + 1][c.y - 1].setBackground(new Color(255, 97, 160));
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {
		}
		try {
			if (checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y]) == false) {
				if (boardPiece[c.x + 1][c.y].image == null) {
					boardPiece[c.x + 1][c.y].setBackground(new Color(145, 255, 228));
				} else if (boardPiece[c.x + 1][c.y].piece.team != TurnManager.turn)
					boardPiece[c.x + 1][c.y].setBackground(new Color(255, 97, 160));
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {
		}
		try {
			if (checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y + 1]) == false) {
				if (boardPiece[c.x + 1][c.y + 1].image == null) {
					boardPiece[c.x + 1][c.y + 1].setBackground(new Color(145, 255, 228));
				} else if (boardPiece[c.x + 1][c.y + 1].piece.team != TurnManager.turn)
					boardPiece[c.x + 1][c.y + 1].setBackground(new Color(255, 97, 160));
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {
		}

	}

	@Override
	public boolean checkPath(ChessPanel[][] boardPiece, Coordinate attackCoordinate) {

		return false;
	}
	
}
