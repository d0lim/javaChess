package managePackage;

import piecesPackage.*;

public class GameManager {
	static BoardMouseController boardMouseController = new BoardMouseController();
	static PieceMouseController pieceMouseController = new PieceMouseController();
	static Coordinate[] kingC = new Coordinate[2];
	
	void initListener(ChessPanel[][] boardPiece) {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(boardPiece[i][j].piece != null)
                    boardPiece[i][j].addMouseListener(boardMouseController);
            }
        }
    }

	public void setPosition(ChessPanel boardPiece[][])
	{
		boardPiece[1][0].setPiece(new Pawn(1, 0), 1);
		boardPiece[1][1].setPiece(new Pawn(1, 1), 1);
		boardPiece[1][2].setPiece(new Pawn(1, 2), 1);
		boardPiece[1][3].setPiece(new Pawn(1, 3), 1);
		boardPiece[1][4].setPiece(new Pawn(1, 4), 1);
		boardPiece[1][5].setPiece(new Pawn(1, 5), 1);
		boardPiece[1][6].setPiece(new Pawn(1, 6), 1);
		boardPiece[1][7].setPiece(new Pawn(1, 7), 1);
		boardPiece[0][1].setPiece(new Knight(0, 1), 1);
	    boardPiece[0][6].setPiece(new Knight(0, 6), 1);
	    boardPiece[0][0].setPiece(new Rook(0, 0), 1);
	    boardPiece[0][7].setPiece(new Rook(0, 7), 1);
	    boardPiece[0][2].setPiece(new Bishop(0, 2), 1);
	    boardPiece[0][5].setPiece(new Bishop(0, 5), 1);
	    boardPiece[0][3].setPiece(new Queen(0, 3), 1);
	    boardPiece[0][4].setPiece(new King(0, 4), 1);
	    kingC[1] = new Coordinate(0, 4);
	    boardPiece[0][4].setIsKing(1);
	    boardPiece[6][0].setPiece(new Pawn(6, 0), 0);
		boardPiece[6][1].setPiece(new Pawn(6, 1), 0);
		boardPiece[6][2].setPiece(new Pawn(6, 2), 0);
		boardPiece[6][3].setPiece(new Pawn(6, 3), 0);
		boardPiece[6][4].setPiece(new Pawn(6, 4), 0);
		boardPiece[6][5].setPiece(new Pawn(6, 5), 0);
		boardPiece[6][6].setPiece(new Pawn(6, 6), 0);
		boardPiece[6][7].setPiece(new Pawn(6, 7), 0);
		boardPiece[7][1].setPiece(new Knight(7, 1), 0);
	    boardPiece[7][6].setPiece(new Knight(7, 6), 0);
	    boardPiece[7][0].setPiece(new Rook(7, 0), 0);
	    boardPiece[7][7].setPiece(new Rook(7, 7), 0);
	    boardPiece[7][2].setPiece(new Bishop(7, 2), 0);
	    boardPiece[7][5].setPiece(new Bishop(7, 5), 0);
	    boardPiece[7][3].setPiece(new Queen(7, 3), 0);
	    boardPiece[7][4].setPiece(new King(7, 4), 0);
	    kingC[0] = new Coordinate(7, 4);
		boardPiece[7][4].setIsKing(0);

	}
}
