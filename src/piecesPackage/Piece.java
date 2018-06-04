package piecesPackage;

import chessDemo.Checkmate;
import chessDemo.ChessPanel;
import chessDemo.Coordinate;

import java.awt.image.BufferedImage;

public abstract class Piece implements Highlight, CheckPath {
	//constructor!!!!

	public int team;
	boolean alive = true;
	Checkmate checkmate = new Checkmate();
	void haveAttacked() {
	    alive = false;
    }
	

    public abstract BufferedImage imageSetting(int team);
	@Override
	public void highlight(ChessPanel[][] boardPiece, Coordinate c) {}
	public void movable(ChessPanel[][] boardPiece, Coordinate c) {}
}