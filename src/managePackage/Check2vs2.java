package managePackage;

    public class Check2vs2 extends Check1vs1 {
        private static Check2vs2 instance2 = new Check2vs2();
        int tCheck1;
        int tCheck2;

        public static Check2vs2 getInstance() {
            return instance2;
        }

        @Override
        void CheckCM(ChessPanel[][] boardPiece, Coordinate kc) {
            tCheck1 = checkCheck(boardPiece, kc);
            tCheck2 = checkCheck(boardPiece, GameManager.kingC[(TurnManager.turn + 2) %4]);

            if(tCheck1 == 1) {
                for (int i = 0; i < 14; i++) {
                    for (int j = 0; j < 14; j++) {
                        if (boardPiece[i][j].piece != null && boardPiece[i][j].piece.team > -1) {
                            if (boardPiece[i][j].piece.team % 4 == TurnManager.turn % 4) {
                                boardPiece[i][j].piece.highlight(boardPiece, new Coordinate(i,j));
                            }
                        }
                    }
                }
                ColorCheck:
                for (int i = 0; i < 14; i++) {
                    movable = false;
                    for (int j = 0; j < 14; j++) {
                        if (boardPiece[i][j].getBackground().equals(ColorM.moveH) ||
                                boardPiece[i][j].getBackground().equals(ColorM.attackH)) {
                            movable = true;
                            break ColorCheck;
                        }
                    }
                }
                for (int i = 0; i < 14; i++) {
                    for (int j = 0; j < 14; j++) {
                        if(i < 3 && j < 3)
                            continue;
                        if(i < 3 && j > 10)
                            continue;
                        if(i > 10 && j < 3)
                            continue;
                        if(i > 10 && j > 10)
                            continue;

                        if ((j + i) % 2 == 0)
                            boardPiece[i][j].setBackground(ColorM.origin1H);
                        else
                            boardPiece[i][j].setBackground(ColorM.origin2H);
                    }
                }
                if (!movable) {
                    if (checkCheck(boardPiece, kc) == 1) {
                        System.out.println("\nCHECKMATE!!!!!!!!\n");
                        TurnManager turnChecker = TurnManager.getInstance();
                        turnChecker.cmTurn(TurnManager.turn);
                    }

                    else
                        System.out.println("\nSTALEMATE!!!!!!!!\n");
                }
                else {
                    if (checkCheck(boardPiece, kc) == 1)
                        System.out.println("\nCHECK!!!!!!!!\n");
                }
            }


            else if(tCheck2 == 1) {
                for (int i = 0; i < 14; i++) {
                    for (int j = 0; j < 14; j++) {
                        if (boardPiece[i][j].piece != null && boardPiece[i][j].piece.team > -1) {
                            if (boardPiece[i][j].piece.team % 2 == TurnManager.turn % 2) {
                                boardPiece[i][j].piece.highlight(boardPiece, new Coordinate(i, j));
                            }
                        }
                    }
                }
                ColorCheck:
                for (int i = 0; i < 14; i++) {
                    movable = false;
                    for (int j = 0; j < 14; j++) {
                        if (boardPiece[i][j].getBackground().equals(ColorM.moveH) ||
                                boardPiece[i][j].getBackground().equals(ColorM.attackH)) {
                            movable = true;
                            break ColorCheck;
                        }
                    }
                }
                for (int i = 0; i < 14; i++) {
                    for (int j = 0; j < 14; j++) {
                        if (i < 3 && j < 3)
                            continue;
                        if (i < 3 && j > 10)
                            continue;
                        if (i > 10 && j < 3)
                            continue;
                        if (i > 10 && j > 10)
                            continue;

                        if ((j + i) % 2 == 0)
                            boardPiece[i][j].setBackground(ColorM.origin1H);
                        else
                            boardPiece[i][j].setBackground(ColorM.origin2H);
                    }
                }
                if (!movable) {
                    if (checkCheck(boardPiece, kc) == 1) {
                        System.out.println("\nCHECKMATE!!!!!!!!\n");
                        TurnManager turnChecker = TurnManager.getInstance();
                        turnChecker.cmTurn(TurnManager.turn);
                    } else
                        System.out.println("\nSTALEMATE!!!!!!!!\n");
                } else {
                    if (checkCheck(boardPiece, kc) == 1)
                        System.out.println("\nCHECK!!!!!!!!\n");
                }
            }


        }
        //util here next turn checkmate


    }
