package piecesPackage;

import managePackage.SelfRiskCheck;
import managePackage.ChessPanel;
import managePackage.Coordinate;

import java.awt.image.BufferedImage;

public abstract class Piece implements Highlight{
	public Piece(int x, int y) {
		this.x = x;
		this.y = y;
}
	//constructor!!!!
	public int x;
	public int y;
	public int team;
	boolean alive = true;
	SelfRiskCheck src = new SelfRiskCheck();

	protected Piece() {
	}

	public abstract BufferedImage imageSetting(int team);
	@Override
	public void highlight(ChessPanel[][] boardPiece, Coordinate c) {}
}