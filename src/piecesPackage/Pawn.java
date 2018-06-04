package piecesPackage;

import managePackage.ChessPanel;
import kr.ac.cau.mecs.lenerd.chess.ChessPieceSprite;
import managePackage.Coordinate;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Pawn extends Piece {

    ChessPieceSprite instance = ChessPieceSprite.getInstace();
	
	public BufferedImage imageSetting(int team)
	{
		BufferedImage image1 = null;
		if(team == 0)
			return instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_PAWN);
		else if(team == 1)
			return instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_PAWN);
		else {
            System.out.println("There's Error~ Fuck you~");
            return instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_KING);
        }
	}
	@Override
	public void highlight(ChessPanel[][] boardPiece, Coordinate c) {

		if (this.team == 0) {

			if (boardPiece[c.x - 1][c.y].image == null) {
			    if(!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y])) {
                    boardPiece[c.x - 1][c.y].setBackground(new Color(145, 255, 228));
                }
			}
            if (c.x == 6 && (boardPiece[c.x - 2][c.y].image == null && boardPiece[c.x - 1][c.y].image == null)) {
                if(!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 2][c.y]))
                    boardPiece[c.x - 2][c.y].setBackground(new Color(145, 255, 228));
            }

			try {
				if (boardPiece[c.x - 1][c.y + 1].image != null && boardPiece[c.x - 1][c.y + 1].piece.team % 2 == 1) {
				    if(!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y + 1]))
                        boardPiece[c.x - 1][c.y + 1].setBackground(new Color(255, 97, 160));
                }
			} catch (ArrayIndexOutOfBoundsException ignored) {}
			try {
				if (boardPiece[c.x - 1][c.y - 1].image != null && boardPiece[c.x - 1][c.y - 1].piece.team % 2 == 1) {
				    if(!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y - 1]))
                        boardPiece[c.x - 1][c.y - 1].setBackground(new Color(255, 97, 160));
                }
			} catch (ArrayIndexOutOfBoundsException ignored) {}

			if (c.y == 1) {
				// case of promotion
			}
			if (c.y == 3) {
				// case of en passant
			}
		} else if (this.team == 1) {
            if (boardPiece[c.x + 1][c.y].image == null) {
                if(!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y])) {
                    boardPiece[c.x + 1][c.y].setBackground(new Color(145, 255, 228));
                }
            }
            if (c.x == 1 && (boardPiece[c.x + 2][c.y].image == null && boardPiece[c.x + 1][c.y].image == null)) {
                if(!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 2][c.y]))
                    boardPiece[c.x + 2][c.y].setBackground(new Color(145, 255, 228));
            }

            try {
                if (boardPiece[c.x + 1][c.y + 1].image != null && boardPiece[c.x + 1][c.y + 1].piece.team % 2 == 1) {
                    if(!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y + 1]))
                        boardPiece[c.x + 1][c.y + 1].setBackground(new Color(255, 97, 160));
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
            try {
                if (boardPiece[c.x + 1][c.y - 1].image != null && boardPiece[c.x + 1][c.y - 1].piece.team % 2 == 1) {
                    if(!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y - 1]))
                        boardPiece[c.x + 1][c.y - 1].setBackground(new Color(255, 97, 160));
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}


			if (c.x == 6) {
				// case of promotion
			}
			if (c.x == 4) {
				// case of en passant
			}
		}

		else {
		} // case of 2vs2

	}

	@Override
	public boolean checkPath(ChessPanel[][] boardPiece, Coordinate panelC) {
		if(this.team == 0) {
		    for(int i = 0; i < 4; i++) {
		        if(i == 0)
		            continue;
		        try {
                    if(boardPiece[panelC.x-1][panelC.y-1].isKing[i]) {
                        System.out.println("Pawn Made Check team 0");
                        return true;
                    }

                    else if(boardPiece[panelC.x-1][panelC.y+1].isKing[i]) {
                        System.out.println("Pawn Made Check team 0");
                        return true;
                    }

                    else
                        return false;
                } catch (ArrayIndexOutOfBoundsException ignored) {}

            }

        }
	    else if(this.team == 1) {
            for(int i = 0; i < 4; i++) {
                if(i == 1)
                    continue;
                try {
                    if(boardPiece[panelC.x-1][panelC.y-1].isKing[i]) {
                        System.out.println("Pawn Made Check team 1");
                        return true;
                    }

                    else if(boardPiece[panelC.x-1][panelC.y+1].isKing[i]) {
                        System.out.println("Pawn Made Check team 1");
                        return true;
                    }

                    else
                        return false;
                } catch (ArrayIndexOutOfBoundsException ignored) {}

            }
        }

        return false;
    }
}
