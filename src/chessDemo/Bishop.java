package chessDemo;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Bishop extends Piece implements Highlight {
	ChessPieceSprite instance = ChessPieceSprite.getInstace();
	
	BufferedImage imageSetting(int team)
	{
		BufferedImage image1 = null;
		if(team == 1)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_BISHOP);
		else if(team == 2)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_BISHOP);
		return image1;
	}
	@Override
	public void highlight(ChessPanel[][] boardPiece, Coordinate c)
	{
		for(int i=-1 ; i<2 ; i+=2)
		{
			try {
				for(int j=1;;j++)
				{
					if(boardPiece[c.x+(i)*j][c.y+(i)*j].image == null)
						boardPiece[c.x+(i)*j][c.y+(i)*j].setBackground(new Color(145, 255, 228));
					else
					{
						if(boardPiece[c.x+(i)*j][c.y+(i)*j].piece.team%2 != this.team%2)
							boardPiece[c.x+(i)*j][c.y+(i)*j].setBackground(new Color(255, 97, 160));
						break;
					}
				}
			} catch (ArrayIndexOutOfBoundsException a) {};
		}
		for(int i=-1 ; i<2 ; i+=2)
		{
			try {
				for(int j=1;;j++)
				{
					if(boardPiece[c.x+(i)*j][c.y-(i)*j].image == null)
						boardPiece[c.x+(i)*j][c.y-(i)*j].setBackground(new Color(145, 255, 228));
					else
					{
						if(boardPiece[c.x+(i)*j][c.y-(i)*j].piece.team%2 != this.team%2)
							boardPiece[c.x+(i)*j][c.y-(i)*j].setBackground(new Color(255, 97, 160));
						break;
					}
				}
			} catch (ArrayIndexOutOfBoundsException a) {};
		}
	}
}
