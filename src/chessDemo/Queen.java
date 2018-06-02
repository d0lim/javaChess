package chessDemo;

import java.awt.image.BufferedImage;

public class Queen extends Piece implements Highlight {
	ChessPieceSprite instance = ChessPieceSprite.getInstace();
	
	BufferedImage imageSetting(int team)
	{
		BufferedImage image1 = null;
		if(team == 1)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_QUEEN);
		else if(team == 2)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_QUEEN);
		return image1;
	}
	@Override
	public void highlight() {
		// TODO Auto-generated method stub
		
	}

}
