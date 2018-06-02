package chessDemo;

import chessDemo.ChessPanel;

public class MoveManager {


    private static MoveManager instance = new MoveManager();

    private MoveManager() {
        System.out.println("Loading MoveManager instance");
    }
    private ChessPanel[][] boardPiece;
    Coordinate selectedCoordinate;

    public static MoveManager getInstance() {
        return instance;
    }

    public void setBoard(ChessPanel[][] boardPiece) {
        this.boardPiece = boardPiece;
    }
    public void setPiece(Coordinate selectedCoordinate) {
        this.selectedCoordinate = selectedCoordinate;
    }

    public void move(int sequence, Coordinate destinationC) {

        if(sequence == 1) {
            System.out.println("Sequence 1 entered");
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    if(boardPiece[i][j].piece != null)
                        boardPiece[i][j].removeMouseListener(GameManager.boardMouseController);
                }
            }
            boardPiece[selectedCoordinate.x][selectedCoordinate.y].piece.highlight();

            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    boardPiece[i][j].addMouseListener(GameManager.pieceMouseController);
                }
            }
        }
        else {
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    boardPiece[i][j].removeMouseListener(GameManager.pieceMouseController);
                }
            }
            Piece bPiece = boardPiece[selectedCoordinate.x][selectedCoordinate.y].getPiece();
            boardPiece[selectedCoordinate.x][selectedCoordinate.y].setPiece(null, 0);
            boardPiece[destinationC.x][destinationC.y].setPiece(bPiece, bPiece.team);
            boardPiece[selectedCoordinate.x][selectedCoordinate.y].setVisible(false);
            boardPiece[selectedCoordinate.x][selectedCoordinate.y].setVisible(true);
            boardPiece[destinationC.x][destinationC.y].setVisible(false);
            boardPiece[destinationC.x][destinationC.y].setVisible(true);
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    if(boardPiece[i][j].piece != null)
                        boardPiece[i][j].addMouseListener(GameManager.boardMouseController);
                }
            }
            System.out.println("reInsert Listener Completed");
        }



    }
}