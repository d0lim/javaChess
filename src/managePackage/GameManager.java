package managePackage;

import piecesPackage.*;

public class GameManager {
	public static int gameType;
	static BoardMouseController boardMouseController = new BoardMouseController();
	static PieceMouseController pieceMouseController = new PieceMouseController();
	static Coordinate[] kingC = new Coordinate[4];
	public static boolean Checked[] = {false, false, false, false};

	void initListener(ChessPanel[][] boardPiece) {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(boardPiece[i][j].piece != null)
					boardPiece[i][j].addMouseListener(boardMouseController);
			}
		}
	}
	void initListener2(ChessPanel[][] boardPiece)
	{
		for(int i = 0; i < 14; i++) {
			for(int j = 0; j < 14; j++) {
				if(boardPiece[i][j].piece != null && boardPiece[i][j].piece.team > -1)
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

	}
	public void setPosition2(ChessPanel boardPiece[][])
	{
		boardPiece[1][3].setPiece(new Pawn2(1, 3), 2);
		boardPiece[1][4].setPiece(new Pawn2(1, 4), 2);
		boardPiece[1][5].setPiece(new Pawn2(1, 5), 2);
		boardPiece[1][6].setPiece(new Pawn2(1, 6), 2);
		boardPiece[1][7].setPiece(new Pawn2(1, 7), 2);
		boardPiece[1][8].setPiece(new Pawn2(1, 8), 2);
		boardPiece[1][9].setPiece(new Pawn2(1, 9), 2);
		boardPiece[1][10].setPiece(new Pawn2(1, 10), 2);
		boardPiece[0][4].setPiece(new Knight(0, 4), 2);
		boardPiece[0][9].setPiece(new Knight(0, 9), 2);
		boardPiece[0][3].setPiece(new Rook(0, 3), 2);
		boardPiece[0][10].setPiece(new Rook(0, 10), 2);
		boardPiece[0][5].setPiece(new Bishop(0, 5), 2);
		boardPiece[0][8].setPiece(new Bishop(0, 8), 2);
		boardPiece[0][7].setPiece(new Queen(0, 6), 2);
		boardPiece[0][6].setPiece(new King(0, 7), 2);
		kingC[2] = new Coordinate(0, 6);
		
		boardPiece[12][3].setPiece(new Pawn2(12, 3), 0);
		boardPiece[12][4].setPiece(new Pawn2(12, 4), 0);
		boardPiece[12][5].setPiece(new Pawn2(12, 5), 0);
		boardPiece[12][6].setPiece(new Pawn2(12, 6), 0);
		boardPiece[12][7].setPiece(new Pawn2(12, 7), 0);
		boardPiece[12][8].setPiece(new Pawn2(12, 8), 0);
		boardPiece[12][9].setPiece(new Pawn2(12, 9), 0);
		boardPiece[12][10].setPiece(new Pawn2(12, 10), 0);
		boardPiece[13][4].setPiece(new Knight(13, 4), 0);
		boardPiece[13][9].setPiece(new Knight(13, 9), 0);
		boardPiece[13][3].setPiece(new Rook(13, 3), 0);
		boardPiece[13][10].setPiece(new Rook(13, 10), 0);
		boardPiece[13][5].setPiece(new Bishop(13, 5), 0);
		boardPiece[13][8].setPiece(new Bishop(13, 8), 0);
		boardPiece[13][6].setPiece(new Queen(13, 6), 0);
		boardPiece[13][7].setPiece(new King(13, 7), 0);
		kingC[0] = new Coordinate(13, 7);
		
		boardPiece[3][1].setPiece(new Pawn2(3, 1), 1);
		boardPiece[4][1].setPiece(new Pawn2(4, 1), 1);
		boardPiece[5][1].setPiece(new Pawn2(5, 1), 1);
		boardPiece[6][1].setPiece(new Pawn2(6, 1), 1);
		boardPiece[7][1].setPiece(new Pawn2(7, 1), 1);
		boardPiece[8][1].setPiece(new Pawn2(8, 1), 1);
		boardPiece[9][1].setPiece(new Pawn2(9, 1), 1);
		boardPiece[10][1].setPiece(new Pawn2(10, 1), 1);
		boardPiece[4][0].setPiece(new Knight(4, 0), 1);
		boardPiece[9][0].setPiece(new Knight(9, 0), 1);
		boardPiece[3][0].setPiece(new Rook(3, 0), 1);
		boardPiece[10][0].setPiece(new Rook(10, 0), 1);
		boardPiece[5][0].setPiece(new Bishop(5, 0), 1);
		boardPiece[8][0].setPiece(new Bishop(8, 0), 1);
		boardPiece[7][0].setPiece(new Queen(6, 0), 1);
		boardPiece[6][0].setPiece(new King(7, 0), 1);
		kingC[1] = new Coordinate(6, 0);
		
		boardPiece[3][12].setPiece(new Pawn2(3, 12), 3);
		boardPiece[4][12].setPiece(new Pawn2(4, 12), 3);
		boardPiece[5][12].setPiece(new Pawn2(5, 12), 3);
		boardPiece[6][12].setPiece(new Pawn2(6, 12), 3);
		boardPiece[7][12].setPiece(new Pawn2(7, 12), 3);
		boardPiece[8][12].setPiece(new Pawn2(8, 12), 3);
		boardPiece[9][12].setPiece(new Pawn2(9, 12), 3);
		boardPiece[10][12].setPiece(new Pawn2(10, 12), 3);
		boardPiece[4][13].setPiece(new Knight(4, 13), 3);
		boardPiece[9][13].setPiece(new Knight(9, 13), 3);
		boardPiece[3][13].setPiece(new Rook(3, 13), 3);
		boardPiece[10][13].setPiece(new Rook(10, 13), 3);
		boardPiece[5][13].setPiece(new Bishop(5, 13), 3);
		boardPiece[8][13].setPiece(new Bishop(8, 13), 3);
		boardPiece[6][13].setPiece(new Queen(6, 13), 3);
		boardPiece[7][13].setPiece(new King(7, 13), 3);
		kingC[3] = new Coordinate(7, 13);

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				boardPiece[i][j].setPiece(new Wall(i, j), -1);
			}
			for(int j = 11; j < 14; j++) {
				boardPiece[i][j].setPiece(new Wall(i, j), -1);
			}
		}
		for(int i = 11; i < 14; i++) {
			for(int j = 0; j < 3; j++) {
				boardPiece[i][j].setPiece(new Wall(i, j), -1);
			}
			for(int j = 11; j < 14; j++) {
				boardPiece[i][j].setPiece(new Wall(i, j), -1);
			}
		}

		
	}
}