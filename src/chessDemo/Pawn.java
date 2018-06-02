package chessDemo;

import java.awt.image.BufferedImage;

public class Pawn extends Piece {

    ChessPieceSprite instance = ChessPieceSprite.getInstace();
	
	BufferedImage imageSetting(int team)
	{
		BufferedImage image1 = null;
		if(team == 1)
			return instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_PAWN);
		else if(team == 2)
			return instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_PAWN);
		else {
            System.out.println("There's Error~ Fuck you~");
            return instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_KING);
        }
            
            
	}
	@Override
	public void highlight() {
		
		
	}

}
