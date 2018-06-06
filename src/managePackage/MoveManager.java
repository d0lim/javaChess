package managePackage;

import java.awt.Color;

import piecesPackage.Piece;
import piecesPackage.Wall;

public class MoveManager {

	private static MoveManager instance = new MoveManager();
	TurnManager turnChecker = new TurnManager();


	private MoveManager() {
		System.out.println("Loading MoveManager instance");
	}

	private ChessPanel[][] boardPiece;
	Coordinate selectedCoordinate;
	int gameType = 0;

	public static MoveManager getInstance() {
		return instance;
	}

	public void setBoard(ChessPanel[][] boardPiece) {
		this.boardPiece = boardPiece;
		if(this.boardPiece.length == 8)
			gameType = 1;
		else
			gameType = 2;
	}

	public void setPiece(Coordinate selectedCoordinate) {
		this.selectedCoordinate = selectedCoordinate;
	}

	public void move(int sequence, Coordinate destinationC) {
		int turn;
		CheckCheck checkInstance = CheckCheck.getInstance();
		Check1vs1 checkInstance1 = Check1vs1.getInstance();
		if(gameType == 1) {
			if (sequence == 1) {
				System.out.println("Highlighting Start");
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (boardPiece[i][j].piece != null)
							boardPiece[i][j].removeMouseListener(GameManager.boardMouseController);
					}
				}

				boardPiece[selectedCoordinate.x][selectedCoordinate.y].piece.highlight(boardPiece, selectedCoordinate);

				System.out.print("\nThe Highlighting has completed..!\n");
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						boardPiece[i][j].addMouseListener(GameManager.pieceMouseController);
					}
				}
			} else if (sequence == 2) {
				turn = TurnManager.turn;
				if (selectedCoordinate.x == GameManager.kingC[turn].x && selectedCoordinate.y == GameManager.kingC[turn].y) {
					System.out.println("Moving King");
					GameManager.kingC[turn] = destinationC;
				}

				removePMC();
				Piece bPiece = boardPiece[selectedCoordinate.x][selectedCoordinate.y].getPiece();
				System.out.println("Moving Piece is " + bPiece.getClass().getName() + " and its team is " + bPiece.team);
				boardPiece[selectedCoordinate.x][selectedCoordinate.y].resetPiece();
				boardPiece[destinationC.x][destinationC.y].resetPiece();
				boardPiece[destinationC.x][destinationC.y].setPiece(bPiece, bPiece.team);

				boardPiece[selectedCoordinate.x][selectedCoordinate.y].setVisible(false);
				boardPiece[selectedCoordinate.x][selectedCoordinate.y].setVisible(true);
				boardPiece[destinationC.x][destinationC.y].setVisible(false);
				boardPiece[destinationC.x][destinationC.y].setVisible(true);

				System.out.println("Check judgement started");

				turnChecker.nextTurn();
				turnChecker.turnCheck();

				checkInstance1.CheckCM(boardPiece,GameManager.kingC[TurnManager.turn]);
				reInsertBMC();

				System.out.println("reInsert Listener Completed");
			} else if (sequence == 3) {
				turn = TurnManager.turn;

				if (selectedCoordinate.x == GameManager.kingC[turn].x && selectedCoordinate.y == GameManager.kingC[turn].y) {
					System.out.println("Moving King");
					GameManager.kingC[turn] = destinationC;
				}


				removePMC();
				Piece bPiece = boardPiece[selectedCoordinate.x][selectedCoordinate.y].getPiece();
				Piece dPiece = boardPiece[destinationC.x][destinationC.y].getPiece();
				System.out.println("Moving Piece is " + bPiece.getClass().getName() + " and its team is " + bPiece.team);
				boardPiece[selectedCoordinate.x][selectedCoordinate.y].resetPiece();
				boardPiece[destinationC.x][destinationC.y].resetPiece();
				boardPiece[destinationC.x][destinationC.y].setPiece(bPiece, bPiece.team);
				moveDead(dPiece);

				boardPiece[selectedCoordinate.x][selectedCoordinate.y].setVisible(false);
				boardPiece[selectedCoordinate.x][selectedCoordinate.y].setVisible(true);
				boardPiece[destinationC.x][destinationC.y].setVisible(false);
				boardPiece[destinationC.x][destinationC.y].setVisible(true);

				System.out.println("Check judgement started");

				turnChecker.nextTurn();
				turnChecker.turnCheck();
				checkInstance1.CheckCM(boardPiece,GameManager.kingC[TurnManager.turn]);

				reInsertBMC();

				System.out.println("reInsert Listener Completed");
			} else if (sequence == 4) {
				removePMC();
				reInsertBMC();
				System.out.println("Wrong Destination Clicked so reInserted BListener..");
			}
		}
		else {
            if (sequence == 1) {
                System.out.println("Highlighting Start");
                for (int i = 0; i < 14; i++) {
                    for (int j = 0; j < 14; j++) {
                        if (boardPiece[i][j].piece != null && boardPiece[i][j].piece.team > -1)
                            boardPiece[i][j].removeMouseListener(GameManager.boardMouseController);
                    }
                }

                boardPiece[selectedCoordinate.x][selectedCoordinate.y].piece.highlight(boardPiece, selectedCoordinate);

                System.out.print("\nThe Highlighting has completed..!\n");
                for (int i = 0; i < 14; i++) {
                    for (int j = 0; j < 14; j++) {
                        boardPiece[i][j].addMouseListener(GameManager.pieceMouseController);
                    }
                }
            } else if (sequence == 2) {
                turn = TurnManager.turn;
                if (selectedCoordinate.x == GameManager.kingC[turn].x && selectedCoordinate.y == GameManager.kingC[turn].y) {
                    System.out.println("Moving King");
                    GameManager.kingC[turn] = destinationC;
                }

                removePMC();
                Piece bPiece = boardPiece[selectedCoordinate.x][selectedCoordinate.y].getPiece();
                //System.out.println("Moving Piece is " + bPiece.getClass().getName() + " and its team is " + bPiece.team);
                boardPiece[selectedCoordinate.x][selectedCoordinate.y].resetPiece();
                boardPiece[destinationC.x][destinationC.y].resetPiece();
                boardPiece[destinationC.x][destinationC.y].setPiece(bPiece, bPiece.team);

                boardPiece[selectedCoordinate.x][selectedCoordinate.y].setVisible(false);
                boardPiece[selectedCoordinate.x][selectedCoordinate.y].setVisible(true);
                boardPiece[destinationC.x][destinationC.y].setVisible(false);
                boardPiece[destinationC.x][destinationC.y].setVisible(true);

                System.out.println("Check judgement started");

                turnChecker.nextTurn();
                turnChecker.turnCheck2();

                //checkInstance1.CheckCM(boardPiece,GameManager.kingC[TurnManager.turn]);
                reInsertBMC();

                System.out.println("reInsert Listener Completed");
            } else if (sequence == 3) {
                turn = TurnManager.turn;

                if (selectedCoordinate.x == GameManager.kingC[turn].x && selectedCoordinate.y == GameManager.kingC[turn].y) {
                    System.out.println("Moving King");
                    GameManager.kingC[turn] = destinationC;
                }


                removePMC();
                Piece bPiece = boardPiece[selectedCoordinate.x][selectedCoordinate.y].getPiece();
                Piece dPiece = boardPiece[destinationC.x][destinationC.y].getPiece();
                System.out.println("Moving Piece is " + bPiece.getClass().getName() + " and its team is " + bPiece.team);
                boardPiece[selectedCoordinate.x][selectedCoordinate.y].resetPiece();
                boardPiece[destinationC.x][destinationC.y].resetPiece();
                boardPiece[destinationC.x][destinationC.y].setPiece(bPiece, bPiece.team);
                moveDead(dPiece);

                boardPiece[selectedCoordinate.x][selectedCoordinate.y].setVisible(false);
                boardPiece[selectedCoordinate.x][selectedCoordinate.y].setVisible(true);
                boardPiece[destinationC.x][destinationC.y].setVisible(false);
                boardPiece[destinationC.x][destinationC.y].setVisible(true);

                System.out.println("Check judgement started");

                turnChecker.nextTurn();
                turnChecker.turnCheck2();
                //checkInstance1.CheckCM(boardPiece,GameManager.kingC[TurnManager.turn]);

                reInsertBMC();

                System.out.println("reInsert Listener Completed");
            } else if (sequence == 4) {
                removePMC();
                reInsertBMC();
                System.out.println("Wrong Destination Clicked so reInserted BListener..");
            }
		}

	}

	private void reInsertBMC() {
		if(gameType == 1) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (boardPiece[i][j].piece != null)
						boardPiece[i][j].addMouseListener(GameManager.boardMouseController);
				}
			}
		}
		else {
            for (int i = 0; i < 14; i++) {
                for (int j = 0; j < 14; j++) {
                    if (boardPiece[i][j].piece != null && boardPiece[i][j].piece.team > -1)
                        boardPiece[i][j].addMouseListener(GameManager.boardMouseController);
                }
            }
        }

	}

	private void removePMC() {
		if(gameType == 1) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					boardPiece[i][j].removeMouseListener(GameManager.pieceMouseController);
					if ((j + i) % 2 == 0)
						boardPiece[i][j].setBackground(new Color(219, 219, 219));
					else
						boardPiece[i][j].setBackground(new Color(156, 156, 156));
				}
			}
		}
		else {
            for (int i = 0; i < 14; i++) {
                for (int j = 0; j < 14; j++) {
                    boardPiece[i][j].removeMouseListener(GameManager.pieceMouseController);

                    if ((j + i) % 2 == 0)
                        boardPiece[i][j].setBackground(new Color(219, 219, 219));
                    else
                        boardPiece[i][j].setBackground(new Color(156, 156, 156));

                }
            }
            for(int i = 0;i<3;i++) {
                for(int j = 0;j<3;j++)
                {
                    boardPiece[i][j].setBackground(new Color(0, 0, 0));
                }
            }
            for(int i = 11;i<14;i++) {
                for(int j = 0;j<3;j++)
                {
                    boardPiece[i][j].setBackground(new Color(0, 0, 0));
                }
            }
            for(int i = 0;i<3;i++) {
                for(int j = 11;j<14;j++)
                {
                    boardPiece[i][j].setBackground(new Color(0, 0, 0));
                }
            }
            for(int i = 11; i < 14;i++) {
                for(int j = 11; j < 14;j++)
                {
                    boardPiece[i][j].setBackground(new Color(0, 0, 0));
                }
            }

        }
	}

	void moveDead(Piece dPiece) {
		System.out.println("");
		System.out.println("");
		System.out.println("Move Dead Loaded");
		System.out.println("");
		System.out.println("");
		if(gameType == 1) {

            if (TurnManager.turn == 0) {
                label:
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (ChessBoard.deathPieceLeft1v1[j][i].piece == null) {
                            ChessBoard.deathPieceLeft1v1[j][i].setPiece(dPiece, 1);
                            ChessBoard.deathPieceLeft1v1[j][i].setVisible(false);
                            ChessBoard.deathPieceLeft1v1[j][i].setVisible(true);
                            break label;
                        }
                    }
                }
            } else if (TurnManager.turn == 1) {
                label:
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (ChessBoard.deathPieceRight1v1[j][i].piece == null) {
                            ChessBoard.deathPieceRight1v1[j][i].setPiece(dPiece, 0);
                            ChessBoard.deathPieceRight1v1[j][i].setVisible(false);
                            ChessBoard.deathPieceRight1v1[j][i].setVisible(true);
                            break label;
                        }
                    }
                }
            }
        }
        else {
		    if(dPiece.team == 0) {
                label:
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (ChessBoard.deathPieceDown2v2[i][j].piece == null) {
                            ChessBoard.deathPieceDown2v2[i][j].setPiece(dPiece, 0);
                            ChessBoard.deathPieceDown2v2[i][j].setVisible(false);
                            ChessBoard.deathPieceDown2v2[i][j].setVisible(true);
                            break label;
                        }
                    }
                }
            }
            else if(dPiece.team == 1) {
                label:
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (ChessBoard.deathPieceLeft2v2[j][i].piece == null) {
                            ChessBoard.deathPieceLeft2v2[j][i].setPiece(dPiece, 1);
                            ChessBoard.deathPieceLeft2v2[j][i].setVisible(false);
                            ChessBoard.deathPieceLeft2v2[j][i].setVisible(true);
                            break label;
                        }
                    }
                }
            }
            else if(dPiece.team == 2) {
                label:
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (ChessBoard.deathPieceUp2v2[i][j].piece == null) {
                            ChessBoard.deathPieceUp2v2[i][j].setPiece(dPiece, 2);
                            ChessBoard.deathPieceUp2v2[i][j].setVisible(false);
                            ChessBoard.deathPieceUp2v2[i][j].setVisible(true);
                            break label;
                        }
                    }
                }
            }
            else if(dPiece.team == 3) {
                label:
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (ChessBoard.deathPieceRight2v2[j][i].piece == null) {
                            ChessBoard.deathPieceRight2v2[j][i].setPiece(dPiece, 3);
                            ChessBoard.deathPieceRight2v2[j][i].setVisible(false);
                            ChessBoard.deathPieceRight2v2[j][i].setVisible(true);
                            break label;
                        }
                    }
                }
            }
        }
	}
}