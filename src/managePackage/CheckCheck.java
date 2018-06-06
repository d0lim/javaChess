package managePackage;

public class CheckCheck {
    private static CheckCheck instance = new CheckCheck();
    Coordinate c;

    public static CheckCheck getInstance() {
        return instance;
    }

    public int checkCheck(ChessPanel[][] boardPiece, Coordinate kc) {

        // Rook & Queen Check
        for (int i = -1; i < 2; i += 2) {
            try {
                for (int j = 1; ; j++) {
                    if (boardPiece[kc.x + (i) * j][kc.y].piece != null) {
                        if (boardPiece[kc.x + (i) * j][kc.y].piece.team % 2 != TurnManager.turn% 2) {
                            if (boardPiece[kc.x + (i) * j][kc.y].piece.getClass().getName().equals("piecesPackage.Rook")
                                    || boardPiece[kc.x + (i) * j][kc.y].piece.getClass().getName().equals("piecesPackage.Queen")) {
                                System.out.print("\n\nRQ will Return 1\n\n");
                                return 1;
                            }
                            else break;

                        }
                        else
                            break;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ignore) { }
        }
        for (int i = -1; i < 2; i += 2) {
            try {
                for (int j = 1; ; j++) {
                    if (boardPiece[kc.x][kc.y + (i) * j].piece != null) {
                        if (boardPiece[kc.x][kc.y + (i) * j].piece.team % 2 != TurnManager.turn % 2) {
                            if (boardPiece[kc.x][kc.y + (i) * j].piece.getClass().getName().equals("piecesPackage.Rook")
                                    || boardPiece[kc.x][kc.y + (i) * j].piece.getClass().getName().equals("piecesPackage.Queen")) {
                                System.out.print("\n\nRQ will Return 1\n\n");
                                return 1;
                            }
                            else break;

                        }
                        else
                            break;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ignore) { }
        }
        System.out.println("룩, 퀸 검사 완료");
        // Bishop & Queen Check

        for (int i = -1; i < 2; i += 2) {
            try {
                for (int j = 1; ;j++) {
                    if (boardPiece[kc.x + (i) * j][kc.y + (i) * j].piece != null) {
                        if (boardPiece[kc.x + (i) * j][kc.y + (i) * j].piece.team % 2 != TurnManager.turn % 2) {
                            if (boardPiece[kc.x + (i) * j][kc.y + (i) * j].piece.getClass().getName().equals("piecesPackage.Bishop")
                                    || boardPiece[kc.x + (i) * j][kc.y + (i) * j].piece.getClass().getName().equals("piecesPackage.Queen")) {
                                System.out.print("\n\nBQ will Return 1\n\n");
                                return 1;
                            }
                            else break;

                        } else
                            break;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ignore) { }
        }
        for (int i = -1; i < 2; i += 2) {
            try {
                for (int j = 1; ; j++) {
                    if (boardPiece[kc.x - i*j][kc.y + i*j].piece != null) {
                        if (boardPiece[kc.x - i*j][kc.y + i*j].piece.team % 2 != TurnManager.turn % 2) {
                            if (boardPiece[kc.x - i*j][kc.y + i*j].piece.getClass().getName().equals("piecesPackage.Bishop")
                                    || boardPiece[kc.x - i*j][kc.y + i*j].piece.getClass().getName().equals("piecesPackage.Queen")) {
                                System.out.print("\n\nBQ will Return 1\n\n");
                                return 1;
                            }
                            else break;

                        }
                        else
                            break;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {}
        }
        System.out.println("비숍, 퀸 검사 완료");
        // Pawn Check

        if(TurnManager.turn == 0) {
            try {
                if (boardPiece[kc.x - 1][kc.y - 1].piece != null) {
                    if (boardPiece[kc.x - 1][kc.y - 1].piece.team % 2 != TurnManager.turn % 2) {
                        if (boardPiece[kc.x - 1][kc.y - 1].piece.getClass().getName().equals("piecesPackage.Pawn")) {
                            System.out.println("\n\nPawn will return 1\n\n");
                            return 1;
                        }


                    }
                }
            } catch (ArrayIndexOutOfBoundsException ignore) { }
            try {
                if (boardPiece[kc.x - 1][kc.y + 1].piece != null) {
                    if (boardPiece[kc.x - 1][kc.y + 1].piece.team % 2 != TurnManager.turn % 2) {
                        if (boardPiece[kc.x - 1][kc.y + 1].piece.getClass().getName().equals("piecesPackage.Pawn")) {
                            System.out.println("\n\nPawn will return 1\n\n");
                            return 1;
                        }

                    }
                }
            } catch (ArrayIndexOutOfBoundsException ignore) { }
        }
        else if(TurnManager.turn == 1) {
            try {
                if (boardPiece[kc.x + 1][kc.y - 1].piece != null) {
                    if (boardPiece[kc.x + 1][kc.y - 1].piece.team % 2 != TurnManager.turn % 2) {
                        if (boardPiece[kc.x + 1][kc.y - 1].piece.getClass().getName().equals("piecesPackage.Pawn")) {
                            System.out.print("\n\nPawn will return 1\n\n");
                            return 1;
                        }

                    }
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {
            }
            try {
                if (boardPiece[kc.x + 1][kc.y + 1].piece != null) {
                    if (boardPiece[kc.x + 1][kc.y + 1].piece.team % 2 != TurnManager.turn % 2) {
                        if (boardPiece[kc.x + 1][kc.y + 1].piece.getClass().getName().equals("piecesPackage.Pawn")) {
                            System.out.print("\n\nPawn will return 1\n\n");
                            return 1;
                        }

                    }
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {
            }
        }
        System.out.println("폰 검사 완료");
        //Knight Check
        for (int i = -1; i < 2; i += 2) {
            for (int j = -1; j < 2; j += 2) {
                try {
                    if (boardPiece[kc.x + i][kc.y + 2 * j].piece != null) {
                        if (boardPiece[kc.x + i][kc.y + 2 * j].piece.team %  2 != TurnManager.turn % 2) {
                            if (boardPiece[kc.x + i][kc.y + 2 * j].piece.getClass().getName().equals("piecesPackage.Knight")) {
                                System.out.print("\n\nKnight will return 1\n\n");
                                return 1;
                            }

                        }

                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {}
                try {
                    if (boardPiece[kc.x + 2*i][kc.y + j].piece != null) {
                        if (boardPiece[kc.x + 2*i][kc.y + j].piece.team % 2 != TurnManager.turn % 2) {
                            if (boardPiece[kc.x + 2 * i][kc.y + j].piece.getClass().getName().equals("piecesPackage.Knight")) {
                                System.out.println("\n\nKnight will return 1\n\n");
                                return 1;
                            }

                        }

                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {}
            }
        }
        System.out.println("나이트 검사 완료");
        return 0;
    }
}
