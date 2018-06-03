package piecesPackage;

import chessDemo.ChessPanel;
import chessDemo.Coordinate;

import java.awt.image.BufferedImage;

public abstract class Piece implements Highlight, CheckPath {
	//constructor!!!!

	public int team;
	boolean alive = true;
	
	void haveAttacked() {
	    alive = false;
    }
	

    public abstract BufferedImage imageSetting(int team);
	@Override
	public void highlight(ChessPanel[][] boardPiece, Coordinate c) {}
}
        
     

    

