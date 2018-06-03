package chessDemo;

import piecesPackage.*;

public class GameManager {
	static BoardMouseController boardMouseController = new BoardMouseController();
	static PieceMouseController pieceMouseController = new PieceMouseController();
	
	void initListener(ChessPanel[][] boardPiece) {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(boardPiece[i][j].piece != null)
                    boardPiece[i][j].addMouseListener(boardMouseController);
            }
        }
    }

	Pawn white_pawn1 = new Pawn();
	Pawn white_pawn2 = new Pawn();
	Pawn white_pawn3 = new Pawn();
	Pawn white_pawn4 = new Pawn();
	Pawn white_pawn5 = new Pawn();
	Pawn white_pawn6 = new Pawn();
	Pawn white_pawn7 = new Pawn();
	Pawn white_pawn8 = new Pawn();
	Bishop white_bishop1 = new Bishop();
	Rook white_rook1 = new Rook();
	Knight white_knight1 = new Knight();
	Queen white_queen = new Queen();
	King white_king = new King();
	Bishop white_bishop2 = new Bishop();
	Rook white_rook2 = new Rook();
	Knight white_knight2 = new Knight();
	
	Pawn black_pawn1 = new Pawn();
	Pawn black_pawn2 = new Pawn();
	Pawn black_pawn3 = new Pawn();
	Pawn black_pawn4 = new Pawn();
	Pawn black_pawn5 = new Pawn();
	Pawn black_pawn6 = new Pawn();
	Pawn black_pawn7 = new Pawn();
	Pawn black_pawn8 = new Pawn();
	Bishop black_bishop1 = new Bishop();
	Rook black_rook1 = new Rook();
	Knight black_knight1 = new Knight();
	Queen black_queen = new Queen();
	King black_king = new King();
	Bishop black_bishop2 = new Bishop();
	Rook black_rook2 = new Rook();
	Knight black_knight2 = new Knight();
	
	
	public void setPosition(ChessPanel boardPiece[][])
	{
		boardPiece[1][0].setPiece(black_pawn1, 1);
		boardPiece[1][1].setPiece(black_pawn2, 1);
		boardPiece[1][2].setPiece(black_pawn3, 1);
		boardPiece[1][3].setPiece(black_pawn4, 1);
		boardPiece[1][4].setPiece(black_pawn5, 1);
		boardPiece[1][5].setPiece(black_pawn6, 1);
		boardPiece[1][6].setPiece(black_pawn7, 1);
		boardPiece[1][7].setPiece(black_pawn8, 1);
		boardPiece[0][1].setPiece(black_knight1, 1);
	    boardPiece[0][6].setPiece(black_knight2, 1);
	    boardPiece[0][0].setPiece(black_rook1, 1);
	    boardPiece[0][7].setPiece(black_rook2, 1);
	    boardPiece[0][2].setPiece(black_bishop1, 1);
	    boardPiece[0][5].setPiece(black_bishop2, 1);
	    boardPiece[0][3].setPiece(black_queen, 1);
	    boardPiece[0][4].setPiece(black_king, 1);
	    boardPiece[0][4].setIsKing(1);
	    boardPiece[6][0].setPiece(white_pawn1, 0);
		boardPiece[6][1].setPiece(white_pawn2, 0);
		boardPiece[6][2].setPiece(white_pawn3, 0);
		boardPiece[6][3].setPiece(white_pawn4, 0);
		boardPiece[6][4].setPiece(white_pawn5, 0);
		boardPiece[6][5].setPiece(white_pawn6, 0);
		boardPiece[6][6].setPiece(white_pawn7, 0);
		boardPiece[6][7].setPiece(white_pawn8, 0);
		boardPiece[7][1].setPiece(white_knight1, 0);
	    boardPiece[7][6].setPiece(white_knight2, 0);
	    boardPiece[7][0].setPiece(white_rook1, 0);
	    boardPiece[7][7].setPiece(white_rook2, 0);
	    boardPiece[7][2].setPiece(white_bishop1, 0);
	    boardPiece[7][5].setPiece(white_bishop2, 0);
	    boardPiece[7][3].setPiece(white_queen, 0);
	    boardPiece[7][4].setPiece(white_king, 0);
		boardPiece[7][4].setIsKing(0);
	}
}
