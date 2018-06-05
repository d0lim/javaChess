package piecesPackage;

import managePackage.ChessPanel;
import kr.ac.cau.mecs.lenerd.chess.ChessPieceSprite;
import managePackage.Coordinate;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Knight extends Piece {
	ChessPieceSprite instance = ChessPieceSprite.getInstace();
	
	public BufferedImage imageSetting(int team)
	{
		BufferedImage image1 = null;
		if(team == 0)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_KNIGHT);
		else if(team == 1)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_KNIGHT);
		return image1;
	}
	@Override
	public void highlight(ChessPanel[][] boardPiece, Coordinate c)
	{
		for (int i = -1; i < 2; i += 2) {
			for (int j = -1; j < 2; j += 2) {
				try {
                    if (boardPiece[c.x + i][c.y + 2 * j].image == null) {
                        if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + i][c.y + 2 * j]))
                            boardPiece[c.x + i][c.y + 2 * j].setBackground(new Color(145, 255, 228));
                    }
                    else {
                        if (boardPiece[c.x + i][c.y + 2 * j].piece != null && boardPiece[c.x + i][c.y + 2 * j].piece.team % 2 != this.team % 2) {
                            if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + i][c.y + 2 * j]))
                                boardPiece[c.x + i][c.y + 2 * j].setBackground(new Color(255, 97, 160));
                        }
                    }
				} catch (ArrayIndexOutOfBoundsException ignored) {}
                try {
                    if (boardPiece[c.x + 2 * i][c.y + j].image == null) {
                        if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 2 * i][c.y + j]))
                            boardPiece[c.x + 2 * i][c.y + j].setBackground(new Color(145, 255, 228));
                    }
                    else {
                        if (boardPiece[c.x + 2 * i][c.y + j].piece != null && boardPiece[c.x + 2 * i][c.y + j].piece.team % 2 != this.team % 2) {
                            if (!checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 2 * i][c.y + j]))
                                boardPiece[c.x + 2 * i][c.y + j].setBackground(new Color(255, 97, 160));
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {}
			}
		}

	}

	@Override
	public boolean checkPath(ChessPanel[][] boardPiece, Coordinate panelC) {
		if(this.team == 0) {
			for(int k = 0; k < 4; k++) {
				if(k == 0)
					continue;
                if (knightCheck(boardPiece, panelC, k)) {
                    System.out.println("Knight made Check team 0");
                    return true;
                }
            }
		}
		if(this.team == 1) {
			for(int k = 0; k < 4; k++) {
				if(k == 1)
					continue;
                if (knightCheck(boardPiece, panelC, k)) {
                    System.out.println("Knight made Check team 1");
                    return true;
                }
            }
		}
		return false;
	}

    private boolean knightCheck(ChessPanel[][] boardPiece, Coordinate panelC, int k) {
        for (int i = -1; i < 2; i += 2) {
            for (int j = -1; j < 2; j += 2) {
                try {
                    if (boardPiece[panelC.x+i][panelC.y+2*j].isKing[k])
                        return true;
                }
                catch (ArrayIndexOutOfBoundsException ignored) {}
                try {
                    if (boardPiece[panelC.x+2*i][panelC.y+j].isKing[k])
                        return true;

                } catch (ArrayIndexOutOfBoundsException ignored) {}

            }
        }
        return false;
    }

}
