package piecesPackage;

import chessDemo.ChessPanel;
import chessDemo.Coordinate;

public interface CheckPath {
    boolean checkPath(ChessPanel[][] boardPiece, Coordinate panelC);
}
