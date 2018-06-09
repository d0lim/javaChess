package managePackage;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import piecesPackage.*;

import javax.swing.*;

public class MoveManager {

	private static MoveManager instance = new MoveManager();
	TurnManager turnChecker = TurnManager.getInstance();


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

		if(gameType == 1) {
            Check1vs1 checkInstance1 = Check1vs1.getInstance();
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
			}
			else if (sequence >= 2 && sequence <= 5) {

				turn = TurnManager.turn;

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if ((boardPiece[i][j].piece != null
                                && boardPiece[i][j].piece.getClass().getName().equals("piecesPackage.Pawn"))
                                && boardPiece[i][j].piece.team != turn)
                            boardPiece[i][j].piece.SpecialMove = false;
                    }
                }
				if (selectedCoordinate.x == GameManager.kingC[turn].x && selectedCoordinate.y == GameManager.kingC[turn].y) {
					System.out.println("Moving King");
					GameManager.kingC[turn] = destinationC;
				}

				removePMC();
				Piece bPiece = boardPiece[selectedCoordinate.x][selectedCoordinate.y].getPiece();
                Piece dPiece = boardPiece[destinationC.x][destinationC.y].getPiece();
				System.out.println("Moving Piece is " + bPiece.getClass().getName() + " and its team is " + bPiece.team);

                if (sequence <= 3) {
                    if (!bPiece.SpecialMove && (bPiece.getClass().getName().equals("piecesPackage.Rook")
                            || bPiece.getClass().getName().equals("piecesPackage.King")))
                        bPiece.SpecialMove = true;
                    if (bPiece.getClass().getName().equals("piecesPackage.Pawn")) {
                        if ((selectedCoordinate.x - destinationC.x) * (selectedCoordinate.x - destinationC.x) == 4)
                            bPiece.SpecialMove = true;
                    }
                }

				boardPiece[selectedCoordinate.x][selectedCoordinate.y].resetPiece();
				boardPiece[destinationC.x][destinationC.y].resetPiece();
				boardPiece[destinationC.x][destinationC.y].setPiece(bPiece, bPiece.team);

                if ((sequence == 3 || sequence == 5) && dPiece != null)
                    moveDead(dPiece);
                if (sequence >= 4)
                    SpecialRule(boardPiece, destinationC);

				boardPiece[selectedCoordinate.x][selectedCoordinate.y].setVisible(false);
				boardPiece[selectedCoordinate.x][selectedCoordinate.y].setVisible(true);
				boardPiece[destinationC.x][destinationC.y].setVisible(false);
				boardPiece[destinationC.x][destinationC.y].setVisible(true);

				System.out.println("Check judgement started");
                GameManager.Checked[turn] = false;

				turnChecker.nextTurn1();

				checkInstance1.CheckCM(boardPiece,GameManager.kingC[TurnManager.turn]);
				reInsertBMC();

				System.out.println("reInsert Listener Completed");
			}
			else {  //sequence == 6
				removePMC();
				reInsertBMC();
				System.out.println("Wrong Destination Clicked so reInserted BListener..");
			}
		}
		else { //gameType == 2
		    Check2vs2 checkInstance2 = Check2vs2.getInstance();
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
            } else if (sequence >= 2 && sequence <= 5) {
                turn = TurnManager.turn;

                for (int i = 0; i < 14; i++) {
                    for (int j = 0; j < 14; j++) {
                        if ((boardPiece[i][j].piece != null && boardPiece[i][j].piece.team > -1)
                             && (boardPiece[i][j].piece.getClass().getName().equals("piecesPackage.Pawn")
                                && boardPiece[i][j].piece.team != turn))
                            boardPiece[i][j].piece.SpecialMove = false;
                    }
                }
                if (selectedCoordinate.x == GameManager.kingC[turn].x && selectedCoordinate.y == GameManager.kingC[turn].y) {
                    System.out.println("Moving King");
                    GameManager.kingC[turn] = destinationC;
                }

                removePMC();
                Piece bPiece = boardPiece[selectedCoordinate.x][selectedCoordinate.y].getPiece();
                Piece dPiece = boardPiece[destinationC.x][destinationC.y].getPiece();
                //System.out.println("Moving Piece is " + bPiece.getClass().getName() + " and its team is " + bPiece.team);

                if (sequence <= 3) {
                    if (!bPiece.SpecialMove && (bPiece.getClass().getName().equals("piecesPackage.Rook")
                            || bPiece.getClass().getName().equals("piecesPackage.King")))
                        bPiece.SpecialMove = true;
                    if (bPiece.getClass().getName().equals("piecesPackage.Pawn")) {
                        if (((destinationC.x == 3 || destinationC.x == 10) && (destinationC.y == 3 || destinationC.y == 10))
                            && ((Math.abs(selectedCoordinate.x - destinationC.x) == 2) || (Math.abs(selectedCoordinate.y - destinationC.y) == 2)))
                            bPiece.SpecialMove = true;
                    }
                }

                boardPiece[selectedCoordinate.x][selectedCoordinate.y].resetPiece();
                boardPiece[destinationC.x][destinationC.y].resetPiece();
                boardPiece[destinationC.x][destinationC.y].setPiece(bPiece, bPiece.team);

                if ((sequence == 3 || sequence == 5) && dPiece != null)
                    moveDead(dPiece);
                if (sequence >= 4)
                    SpecialRule(boardPiece, destinationC);


                boardPiece[selectedCoordinate.x][selectedCoordinate.y].setVisible(false);
                boardPiece[selectedCoordinate.x][selectedCoordinate.y].setVisible(true);
                boardPiece[destinationC.x][destinationC.y].setVisible(false);
                boardPiece[destinationC.x][destinationC.y].setVisible(true);

                System.out.println("Check judgement started");
                GameManager.Checked[turn] = false;

                turnChecker.nextTurn2();


                checkInstance2.CheckCM(boardPiece,GameManager.kingC[TurnManager.turn]);
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

                turnChecker.nextTurn2();

                checkInstance2.CheckCM(boardPiece,GameManager.kingC[TurnManager.turn]);

                reInsertBMC();

                System.out.println("reInsert Listener Completed");
            } else if (sequence == 6) {
                removePMC();
                reInsertBMC();
                System.out.println("Wrong Destination Clicked so reInserted BListener..");
            }
		}

	}


    void SpecialRule(ChessPanel[][] boardPiece, Coordinate destC) {
        if (boardPiece[destC.x][destC.y].piece.team == 0) {
            if (destC.x == 0) {  // Promotion



                // Piece UPiece = 쏼라쏼라쏼라쏼라 : GUI창에서 정해짐
                boardPiece[destC.x][destC.y].resetPiece();
                // boardPiece[destC.x][destC.y].setPiece(UPiece);
                String []promotion = {"Knight", "Queen", "Bishop", "Rook"};
                Object decision = JOptionPane.showInputDialog(null, "승격할 말을 정하시오", "승격", JOptionPane.QUESTION_MESSAGE, null, promotion, promotion[0]);
                // Piece UPiece = ?�눖�뵬?�눖�뵬?�눖�뵬?�눖�뵬 : GUI筌≪럩肉�???類λ퉸筌�?
                boardPiece[destC.x][destC.y].resetPiece();
                // boardPiece[destC.x][destC.y].setPiece(UPiece);
                if(decision.equals("Knight"))
                    boardPiece[destC.x][destC.y].setPiece(new Knight(destC.x, destC.y), 0); //?�뜆�뻻
                if(decision.equals("Queen"))
                    boardPiece[destC.x][destC.y].setPiece(new Queen(destC.x, destC.y), 0);
                if(decision.equals("Bishop"))
                    boardPiece[destC.x][destC.y].setPiece(new Bishop(destC.x, destC.y), 0);
                if(decision.equals("Rook"))
                    boardPiece[destC.x][destC.y].setPiece(new Rook(destC.x, destC.y), 0);


            }
        } else if (boardPiece[destC.x][destC.y].piece.team == 1) {
            if (destC.x == 7) {

                // Piece UPiece = 쏼라쏼라쏼라쏼라 : GUI창에서 정해짐
                boardPiece[destC.x][destC.y].resetPiece();
                // boardPiece[destC.x][destC.y].setPiece(UPiece);
                String []promotion = {"Knight", "Queen", "Bishop", "Rook"};
                Object decision = JOptionPane.showInputDialog(null, "승격할 말을 정하시오", "승격", JOptionPane.QUESTION_MESSAGE, null, promotion, promotion[0]);
                // Piece UPiece = ?�눖�뵬?�눖�뵬?�눖�뵬?�눖�뵬 : GUI筌≪럩肉�???類λ퉸筌�?
                boardPiece[destC.x][destC.y].resetPiece();
                // boardPiece[destC.x][destC.y].setPiece(UPiece);
                if(decision.equals("Knight"))
                    boardPiece[destC.x][destC.y].setPiece(new Knight(destC.x, destC.y), 1); //?�뜆�뻻
                if(decision.equals("Queen"))
                    boardPiece[destC.x][destC.y].setPiece(new Queen(destC.x, destC.y), 1);
                if(decision.equals("Bishop"))
                    boardPiece[destC.x][destC.y].setPiece(new Bishop(destC.x, destC.y), 1);
                if(decision.equals("Rook"))
                    boardPiece[destC.x][destC.y].setPiece(new Rook(destC.x, destC.y), 1);            }
        }
        if (boardPiece[destC.x][destC.y].piece.team == 0) {
            if (destC.x == 2) {  // 앙파상
                moveDead(boardPiece[destC.x + 1][destC.y].getPiece());
                boardPiece[destC.x + 1][destC.y].resetPiece();
            }
        }
        else if(boardPiece[destC.x][destC.y].piece.team == 1) {
            if (destC.x == 5) { // 앙파상
                moveDead(boardPiece[destC.x - 1][destC.y].getPiece());
                boardPiece[destC.x - 1][destC.y].resetPiece();
            }
        }
        // castleling

        if (boardPiece[destC.x][destC.y].piece.team == 0) {
            if (destC.x == 7 && destC.y == 6) {
                Piece rook = boardPiece[7][7].getPiece();
                boardPiece[7][5].resetPiece();
                boardPiece[7][7].resetPiece();
                boardPiece[7][5].setPiece(rook, 0);
                boardPiece[7][5].setVisible(false);
                boardPiece[7][5].setVisible(true);
            }
            if (destC.x == 7 && destC.y == 2) {
                Piece rook = boardPiece[7][0].getPiece();
                boardPiece[7][0].resetPiece();
                boardPiece[7][3].resetPiece();
                boardPiece[7][3].setPiece(rook, 0);
                boardPiece[7][3].setVisible(false);
                boardPiece[7][3].setVisible(true);
            }
        }
        if (boardPiece[destC.x][destC.y].piece.team == 1) {
            if (destC.x == 0 && destC.y == 6) {
                Piece rook = boardPiece[0][7].getPiece();
                boardPiece[0][5].resetPiece();
                boardPiece[0][7].resetPiece();
                boardPiece[0][5].setPiece(rook, 1);
                boardPiece[0][5].setVisible(false);
                boardPiece[0][5].setVisible(true);
            }
            if (destC.x == 0 && destC.y == 2) {
                Piece rook = boardPiece[0][0].getPiece();
                boardPiece[0][0].resetPiece();
                boardPiece[0][3].resetPiece();
                boardPiece[0][3].setPiece(rook, 1);
                boardPiece[0][3].setVisible(false);
                boardPiece[0][3].setVisible(true);
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
						boardPiece[i][j].setBackground(ColorM.origin1H);
					else
						boardPiece[i][j].setBackground(ColorM.origin2H);
                    if (GameManager.Checked[TurnManager.turn])
                        boardPiece[GameManager.kingC[TurnManager.turn].x][GameManager.kingC[TurnManager.turn].y].setBackground(ColorM.checkedH);
				}
			}
		}
		else {
            for (int i = 0; i < 14; i++) {
                for (int j = 0; j < 14; j++) {
                    boardPiece[i][j].removeMouseListener(GameManager.pieceMouseController);

                    if ((j + i) % 2 == 0)
                        boardPiece[i][j].setBackground(ColorM.origin1H);
                    else
                        boardPiece[i][j].setBackground(ColorM.origin2H);
                    if (GameManager.Checked[TurnManager.turn])
                        boardPiece[GameManager.kingC[TurnManager.turn].x][GameManager.kingC[TurnManager.turn].y].setBackground(ColorM.checkedH);

                }
            }
            for(int i = 0;i<3;i++) {
                for(int j = 0;j<3;j++)
                {
                    boardPiece[i][j].setBackground(ColorM.WallH);
                }
            }
            for(int i = 11;i<14;i++) {
                for(int j = 0;j<3;j++)
                {
                    boardPiece[i][j].setBackground(ColorM.WallH);
                }
            }
            for(int i = 0;i<3;i++) {
                for(int j = 11;j<14;j++)
                {
                    boardPiece[i][j].setBackground(ColorM.WallH);
                }
            }
            for(int i = 11; i < 14;i++) {
                for(int j = 11; j < 14;j++)
                {
                    boardPiece[i][j].setBackground(ColorM.WallH);
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