package managePackage;

import piecesPackage.Piece;

public class SelfRiskCheck {
	
	Piece temp = null;
	CheckCheck checkInstance = CheckCheck.getInstance();
	boolean selfriskCheck = false;
	
	public boolean selfrisk(ChessPanel[][] boardPiece, ChessPanel start,ChessPanel dest)
	{
        System.out.println("Before invisible Move " + start.piece +", "+ dest.piece +" Dest: "+dest.c.x+","+dest.c.y);
		invisibleMove(start, dest);
		System.out.println(start.piece +", "+ dest.piece +" Dest: "+dest.c.x+","+dest.c.y);
		if(checkInstance.checkCheck(boardPiece) == 1)
			selfriskCheck = false;
		else if(checkInstance.checkCheck(boardPiece) == 0)
			selfriskCheck = true;


		moveReturn(start, dest);
		System.out.println(start.piece +", "+ dest.piece);
		return selfriskCheck;
	}
	public void invisibleMove(ChessPanel start, ChessPanel dest)
	{
		if(start.isKing[TurnManager.turn]) {
			start.notKing();
			dest.setIsKing(TurnManager.turn);
		}
		temp = dest.piece;
		dest.piece = start.piece;
		start.piece = null;
	}
	public void moveReturn(ChessPanel start, ChessPanel dest)
	{
		if(dest.isKing[TurnManager.turn]) {
			dest.notKing();
			start.setIsKing(TurnManager.turn);
		}
		start.piece = dest.piece;
		dest.piece = temp;
	}
}

