package piecesPackage;

import managePackage.ChessPanel;
import kr.ac.cau.mecs.lenerd.chess.ChessPieceSprite;
import managePackage.Coordinate;
import managePackage.TurnManager;

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
			if (boardPiece[c.x - 1][c.y - 1].image == null) {
				if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y - 1]))
					boardPiece[c.x - 1][c.y - 1].setBackground(new Color(145, 255, 228));
			} else if (boardPiece[c.x - 1][c.y - 1].piece.team != TurnManager.turn) {
				if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y - 1]))
					boardPiece[c.x - 1][c.y - 1].setBackground(new Color(255, 97, 160));
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {}

		try {
			if (boardPiece[c.x - 1][c.y].image == null) {
				if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y]))
					boardPiece[c.x - 1][c.y].setBackground(new Color(145, 255, 228));
			} else if (boardPiece[c.x - 1][c.y].piece.team != TurnManager.turn) {
				if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y]))
					boardPiece[c.x - 1][c.y].setBackground(new Color(255, 97, 160));
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {}

		try {
			if (boardPiece[c.x - 1][c.y + 1].image == null) {
				if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y + 1]))
					boardPiece[c.x - 1][c.y + 1].setBackground(new Color(145, 255, 228));
			} else if (boardPiece[c.x - 1][c.y + 1].piece.team != TurnManager.turn) {
				if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y + 1]))
					boardPiece[c.x - 1][c.y + 1].setBackground(new Color(255, 97, 160));
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {}

		try {
			if (boardPiece[c.x][c.y - 1].image == null) {
				if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y - 1]))
					boardPiece[c.x][c.y - 1].setBackground(new Color(145, 255, 228));
			} else if (boardPiece[c.x][c.y - 1].piece.team != TurnManager.turn) {
				if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y - 1]))
					boardPiece[c.x][c.y - 1].setBackground(new Color(255, 97, 160));
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {}

		try {
			if (boardPiece[c.x][c.y + 1].image == null) {
				if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y + 1]))
					boardPiece[c.x][c.y + 1].setBackground(new Color(145, 255, 228));
			} else if (boardPiece[c.x][c.y + 1].piece.team != TurnManager.turn) {
				if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y + 1]))
					boardPiece[c.x][c.y + 1].setBackground(new Color(255, 97, 160));
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {}

		try {
			if (boardPiece[c.x + 1][c.y - 1].image == null) {
				if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y - 1]))
					boardPiece[c.x + 1][c.y - 1].setBackground(new Color(145, 255, 228));
			} else if (boardPiece[c.x + 1][c.y - 1].piece.team != TurnManager.turn) {
				if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y - 1]))
					boardPiece[c.x + 1][c.y - 1].setBackground(new Color(255, 97, 160));
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {}

		try {
			if (boardPiece[c.x + 1][c.y].image == null) {
				if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y]))
					boardPiece[c.x + 1][c.y].setBackground(new Color(145, 255, 228));
			} else if (boardPiece[c.x + 1][c.y].piece.team != TurnManager.turn) {
				if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y]))
					boardPiece[c.x + 1][c.y].setBackground(new Color(255, 97, 160));
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {}

		try {
			if (boardPiece[c.x + 1][c.y + 1].image == null) {
				if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y + 1]))
					boardPiece[c.x + 1][c.y + 1].setBackground(new Color(145, 255, 228));
			} else if (boardPiece[c.x + 1][c.y + 1].piece.team != TurnManager.turn) {
				if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y + 1]))
					boardPiece[c.x + 1][c.y + 1].setBackground(new Color(255, 97, 160));
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {}


	}

	@Override
	public boolean checkPath(ChessPanel[][] boardPiece, Coordinate panelC) {

		if(this.team == 0) {
			for(int i = 0; i < 4; i++) {
				if(i == 0)
					continue;
				try {
					if (boardPiece[panelC.x - 1][panelC.y - 1].isKing[i]) {
						return true;
					}
				} catch (ArrayIndexOutOfBoundsException ignore) {}

                try {
                    if (boardPiece[panelC.x - 1][panelC.y].isKing[i]) {
                        return true;
                    }
                } catch (ArrayIndexOutOfBoundsException ignore) {}

                try {
                    if (boardPiece[panelC.x - 1][panelC.y + 1].isKing[i]) {
                        return true;
                    }
                } catch (ArrayIndexOutOfBoundsException ignore) {}

                try {
                    if (boardPiece[panelC.x][panelC.y - 1].isKing[i]) {
                        return true;
                    }
                } catch (ArrayIndexOutOfBoundsException ignore) {}

                try {
                    if (boardPiece[panelC.x][panelC.y + 1].isKing[i]) {
                        return true;
                    }
                } catch (ArrayIndexOutOfBoundsException ignore) {}

                try {
                    if (boardPiece[panelC.x + 1][panelC.y - 1].isKing[i]) {
                        return true;
                    }
                } catch (ArrayIndexOutOfBoundsException ignore) {}

                try {
                    if (boardPiece[panelC.x + 1][panelC.y].isKing[i]) {
                        return true;
                    }
                } catch (ArrayIndexOutOfBoundsException ignore) {}

                try {
                    if (boardPiece[panelC.x + 1][panelC.y + 1].isKing[i]) {
                        return true;
                    }
                } catch (ArrayIndexOutOfBoundsException ignore) {}
			}
		}
		return false;
	}
	
}
