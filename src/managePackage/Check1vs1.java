package managePackage;

public class Check1vs1 extends CheckCheck
{
    private static Check1vs1 instance1 = new Check1vs1();
    boolean movable = true;

    public static Check1vs1 getInstance() {
        return instance1;
    }

    void CheckCM(ChessPanel[][] boardPiece, Coordinate kc) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (boardPiece[i][j].piece != null) {
                    if (boardPiece[i][j].piece.team % 2 == TurnManager.turn % 2) {
                        boardPiece[i][j].piece.highlight(boardPiece, new Coordinate(i,j));
                    }
                }
            }
        }
        ColorCheck:
        for (int i = 0; i < 8; i++) {
            movable = false;
            for (int j = 0; j < 8; j++) {
                if (boardPiece[i][j].getBackground().equals(ColorM.moveH) ||
                        boardPiece[i][j].getBackground().equals(ColorM.attackH)) {
                    movable = true;
                    break ColorCheck;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((j + i) % 2 == 0)
                    boardPiece[i][j].setBackground(ColorM.origin1H);
                else
                    boardPiece[i][j].setBackground(ColorM.origin2H);
            }
        }
        if (!movable) {
            if (checkCheck(boardPiece, kc) == 1)
                System.out.println("\nCHECKMATE!!!!!!!!\n");
            else
                System.out.println("\nSTALEMATE!!!!!!!!\n");
        }
        else {
            if (checkCheck(boardPiece, kc) == 1)
                System.out.println("\nCHECK!!!!!!!!\n");
        }
    }
}
