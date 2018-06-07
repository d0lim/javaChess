package piecesPackage;

import java.awt.Color;

import managePackage.ChessPanel;
import managePackage.Coordinate;

public class Pawn2 extends Pawn{

	public Pawn2(int x, int y) {
		super(x, y);

	}
	@Override
	public void highlight(ChessPanel[][] boardPiece, Coordinate c) {

		if (this.team == 0) {

			if (boardPiece[c.x - 1][c.y].piece == null) {
			    if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y])) {
                    boardPiece[c.x - 1][c.y].setBackground(new Color(145, 255, 228));
                }
			}
            
			if (c.x == 12 && (boardPiece[c.x - 2][c.y].piece == null && boardPiece[c.x - 1][c.y].piece == null)) {
                if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 2][c.y]))
                    boardPiece[c.x - 2][c.y].setBackground(new Color(145, 255, 228));
            }

			try {
				if ((boardPiece[c.x - 1][c.y + 1].piece != null && boardPiece[c.x - 1][c.y + 1].piece.team % 2 == 1) && boardPiece[c.x - 1][c.y + 1].piece.team > -1) {
				    if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y + 1]))
                        boardPiece[c.x - 1][c.y + 1].setBackground(new Color(255, 97, 160));
                }
			} catch (ArrayIndexOutOfBoundsException ignored) {}
			try {
				if ((boardPiece[c.x - 1][c.y - 1].piece != null && boardPiece[c.x - 1][c.y - 1].piece.team % 2 == 1) && boardPiece[c.x - 1][c.y - 1].piece.team > -1) {
				    if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y - 1]))
                        boardPiece[c.x - 1][c.y - 1].setBackground(new Color(255, 97, 160));
                }
			} catch (ArrayIndexOutOfBoundsException ignored) {}

			if (c.y == 1) {
				// case of promotion
			}
			if (c.y == 3) {
				// case of en passant
			}
		} 

		else if(this.team == 1){
			if (boardPiece[c.x][c.y + 1].piece == null) {
			    if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y + 1])) {
                    boardPiece[c.x][c.y + 1].setBackground(new Color(145, 255, 228));
                }
			}
            if (c.y == 1 && (boardPiece[c.x][c.y + 2].piece == null && boardPiece[c.x][c.y + 1].piece == null)) {
                if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y + 2]))
                    boardPiece[c.x][c.y + 2].setBackground(new Color(145, 255, 228));
            }

			try {
				if ((boardPiece[c.x - 1][c.y + 1].piece != null && boardPiece[c.x - 1][c.y + 1].piece.team % 2 == 0) && boardPiece[c.x - 1][c.y + 1].piece.team > -1) {
				    if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y + 1]))
                        boardPiece[c.x - 1][c.y + 1].setBackground(new Color(255, 97, 160));
                }
			} catch (ArrayIndexOutOfBoundsException ignored) {}
			try {
				if ((boardPiece[c.x + 1][c.y + 1].piece != null && boardPiece[c.x + 1][c.y + 1].piece.team % 2 == 0) && boardPiece[c.x + 1][c.y + 1].piece.team > -1) {
				    if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y + 1]))
                        boardPiece[c.x + 1][c.y + 1].setBackground(new Color(255, 97, 160));
                }
			} catch (ArrayIndexOutOfBoundsException ignored) {}

			if (c.y == 1) {
				// case of promotion
			}
			if (c.y == 3) {
				// case of en passant
			}
		} // case of 2vs2
		else if (this.team == 2) {
            if (boardPiece[c.x + 1][c.y].piece == null) {
                if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y])) {
                    boardPiece[c.x + 1][c.y].setBackground(new Color(145, 255, 228));
                }
            }
            if (c.x == 1 && (boardPiece[c.x + 2][c.y].image == null && boardPiece[c.x + 1][c.y].image == null)) {
                if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 2][c.y]))
                    boardPiece[c.x + 2][c.y].setBackground(new Color(145, 255, 228));
            }

            try {
                if ((boardPiece[c.x + 1][c.y + 1].image != null && boardPiece[c.x + 1][c.y + 1].piece.team % 2 == 1) && boardPiece[c.x + 1][c.y + 1].piece.team > -1) {
                    if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y + 1]))
                        boardPiece[c.x + 1][c.y + 1].setBackground(new Color(255, 97, 160));
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
            try {
                if ((boardPiece[c.x + 1][c.y - 1].image != null && boardPiece[c.x + 1][c.y - 1].piece.team % 2 == 1) && boardPiece[c.x + 1][c.y - 1].piece.team > -1) {
                    if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y - 1]))
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
		else if(this.team == 3)
		{
			 if (boardPiece[c.x][c.y - 1].piece == null) {
	                if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y - 1])) {
	                    boardPiece[c.x][c.y - 1].setBackground(new Color(145, 255, 228));
	                }
	            }
	            if (c.y == 12 && (boardPiece[c.x][c.y - 2].image == null && boardPiece[c.x][c.y - 1].image == null)) {
	                if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y - 2]))
	                    boardPiece[c.x][c.y - 2].setBackground(new Color(145, 255, 228));
	            }

	            try {
	                if ((boardPiece[c.x - 1][c.y - 1].image != null && boardPiece[c.x - 1][c.y - 1].piece.team % 2 == 0) && boardPiece[c.x - 1][c.y - 1].piece.team > -1) {
	                    if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y - 1]))
	                        boardPiece[c.x - 1][c.y - 1].setBackground(new Color(255, 97, 160));
	                }
	            } catch (ArrayIndexOutOfBoundsException ignored) {}
	            try {
	                if ((boardPiece[c.x + 1][c.y - 1].image != null && boardPiece[c.x + 1][c.y - 1].piece.team % 2 == 0) && boardPiece[c.x + 1][c.y - 1].piece.team > -1) {
	                    if(!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y - 1]))
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
	}
}
