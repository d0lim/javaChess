package piecesPackage;

import managePackage.ChessPanel;
import managePackage.Coordinate;

public interface Highlight {
    public void highlight(ChessPanel[][] boardPiece, Coordinate c);
}