package managePackage;

public class CheckCheck {
    private static CheckCheck instance = new CheckCheck();
    int selfRisk = 1;
    private CheckCheck() {
        System.out.println("You've Loaded CheckChecker");
    }

    public static CheckCheck getInstance() {
        return instance;
    }

    public int checkCheck(ChessPanel boardPiece[][]) {
        selfRisk = 1;
    	for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(boardPiece[i][j].piece != null) {
                    Coordinate c = new Coordinate(i, j);
                    if(boardPiece[i][j].piece.checkPath(boardPiece, c)) {
                        if(boardPiece[i][j].piece.team == TurnManager.turn) {
                            String name = boardPiece[i][j].piece.getClass().getName();
                            System.out.println();
                            System.out.println(name + " have made Check!!");
                            System.out.println();
                            selfRisk = 1;
                        }
                        else
                            selfRisk = 0;
                    }
                    else {
                        /*String name = boardPiece[i][j].piece.getClass().getName();
                        System.out.println(name + " do not make Check!");*/
                    	continue;
                        
                    }

                }
               
            }
        }
        return selfRisk;
    }

 


}
