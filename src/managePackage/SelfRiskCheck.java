package managePackage;

import piecesPackage.Piece;

public class SelfRiskCheck {
	
	Piece temp = null;
	CheckCheck checkInstance = CheckCheck.getInstance();
	private boolean riskCheck = false;
	
	public boolean selfrisk(ChessPanel[][] boardPiece, ChessPanel start,ChessPanel dest)
	{
        System.out.println("Before invisible Move " + start.piece.getClass().getName() +", "+ dest.piece +" Dest: "+dest.c.x+","+dest.c.y);
		invisibleMove(start, dest);

		System.out.printf("\n\nKing0 is at x : %d, y : %d\nKing1 is at x : %d, y : %d\n\n", GameManager.kingC[0].x, GameManager.kingC[0].y, GameManager.kingC[1].x, GameManager.kingC[1].y);

		System.out.println(start.piece +", "+ dest.piece +" Dest: "+dest.c.x+","+dest.c.y);
		if(checkInstance.checkCheck(boardPiece, GameManager.kingC[TurnManager.turn]) == 0)
			riskCheck = false;
		else if(checkInstance.checkCheck(boardPiece,GameManager.kingC[TurnManager.turn]) == 1)
			riskCheck = true;

		moveReturn(start, dest);
		System.out.println(start.piece +", "+ dest.piece);
		return riskCheck;
	}
	public void invisibleMove(ChessPanel start, ChessPanel dest)
	{

		if(start.c.x == GameManager.kingC[TurnManager.turn].x && start.c.y == GameManager.kingC[TurnManager.turn].y) {
			dest.setIsKing(TurnManager.turn);
		}
		temp = dest.piece;
		dest.piece = start.piece;
		start.piece = null;
	}
	public void moveReturn(ChessPanel start, ChessPanel dest)
	{
		if(dest.c.x == GameManager.kingC[TurnManager.turn].x && dest.c.y == GameManager.kingC[TurnManager.turn].y) {
			start.setIsKing(TurnManager.turn);
		}
		start.piece = dest.piece;
		dest.piece = temp;
	}
}