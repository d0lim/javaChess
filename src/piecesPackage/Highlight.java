package piecesPackage;

import chessDemo.ChessPanel;
import chessDemo.Coordinate;

public interface Highlight {
    public void highlight(ChessPanel[][] boardPiece, Coordinate c);
}