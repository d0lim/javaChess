package piecesPackage;

import managePackage.ChessPanel;
import kr.ac.cau.mecs.lenerd.chess.ChessPieceSprite;
import managePackage.Coordinate;
import managePackage.GameManager;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Knight extends Piece {
	ChessPieceSprite instance = ChessPieceSprite.getInstace();

    public Knight(int x, int y) {
        this.x = x;
        this.y = y;
    }
	public BufferedImage imageSetting(int team)
	{
        BufferedImage image1 = null;
        if(GameManager.gameType == 1) {
            if(team == 0)
                image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_KNIGHT);
            else if(team == 1)
                image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_KNIGHT);

        }
        else if(GameManager.gameType == 2) {

            if (team == 0)
                image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_KNIGHT);
            else if (team == 1)
                image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.RED_KNIGHT);
            else if (team == 2)
                image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_KNIGHT);
            else if (team == 3)
                image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.GREEN_KNIGHT);

        }
        return image1;
	}
	@Override
	public void highlight(ChessPanel[][] boardPiece, Coordinate c)
	{
		for (int i = -1; i < 2; i += 2) {
			for (int j = -1; j < 2; j += 2) {
				try {
                    if (boardPiece[c.x + i][c.y + 2 * j].piece == null) {
                        if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + i][c.y + 2 * j]))
                            boardPiece[c.x + i][c.y + 2 * j].setBackground(new Color(145, 255, 228));
                    }
                    else {
                        if (boardPiece[c.x + i][c.y + 2 * j].piece.team % 2 != this.team % 2 && boardPiece[c.x + i][c.y + 2 * j].piece.team > -1) {
                            if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + i][c.y + 2 * j]))
                                boardPiece[c.x + i][c.y + 2 * j].setBackground(new Color(255, 97, 160));
                        }
                    }
				} catch (ArrayIndexOutOfBoundsException ignored) {}
                try {
                    if (boardPiece[c.x + 2 * i][c.y + j].piece == null) {
                        if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 2 * i][c.y + j]))
                            boardPiece[c.x + 2 * i][c.y + j].setBackground(new Color(145, 255, 228));
                    }
                    else {
                        if (boardPiece[c.x + 2 * i][c.y + j].piece.team % 2 != this.team % 2 && boardPiece[c.x + 2 * i][c.y + j].piece.team > -1) {
                            if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 2 * i][c.y + j]))
                                boardPiece[c.x + 2 * i][c.y + j].setBackground(new Color(255, 97, 160));
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {}
			}
		}

	}

}
