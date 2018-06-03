package chessDemo;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Knight extends Piece implements Highlight {
	ChessPieceSprite instance = ChessPieceSprite.getInstace();
	
	BufferedImage imageSetting(int team)
	{
		BufferedImage image1 = null;
		if(team == 1)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_KNIGHT);
		else if(team == 2)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_KNIGHT);
		return image1;
	}
	@Override
	public void highlight(ChessPanel[][] boardPiece, Coordinate c)
	{

		for (int i = -1; i < 2; i += 2) {
			for (int j = -1; j < 2; j += 2) {
				try {
					if (boardPiece[c.x+i][c.y+2*j].image == null) 
						boardPiece[c.x+i][c.y+2*j].setBackground(new Color(145, 255, 228));
					else {
						if (boardPiece[c.x+i][c.y+2*j].piece != null
								&& boardPiece[c.x+i][c.y+2*j].piece.team%2 != this.team%2) {
							boardPiece[c.x+i][c.y+2*j].setBackground(new Color(255, 97, 160));
						}
					}
				}
				catch (ArrayIndexOutOfBoundsException a) {}
				try {
					if (boardPiece[c.x+2*i][c.y+j].image == null)
						boardPiece[c.x+2*i][c.y+j].setBackground(new Color(145, 255, 228));
					else {
						if (boardPiece[c.x+2*i][c.y+j].piece != null
								&& boardPiece[c.x+2*i][c.y+j].piece.team%2 != this.team%2) {
							boardPiece[c.x+2*i][c.y+j].setBackground(new Color(255, 97, 160));
						}
					}
				} catch (ArrayIndexOutOfBoundsException a) {}
				// TODO Auto-generated method stub
			}
		}

	}
}
