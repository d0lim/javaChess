package piecesPackage;

import managePackage.ChessPanel;
import managePackage.Coordinate;

public interface CheckPath {
    boolean checkPath(ChessPanel[][] boardPiece, Coordinate panelC);
}
