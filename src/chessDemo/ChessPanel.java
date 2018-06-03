package chessDemo;

import java.awt.image.BufferedImage;

public class ChessPanel extends ImagePanel {
	Piece piece;
	private Coordinate c = new Coordinate();
	BufferedImage image;
	boolean[] isKing = {false, false, false, false};
	boolean[] movable = {false, false, false, false};
	
	public void setPiece(Piece piece, int team)
	{
        this.piece = piece;
		piece.team = team;
        image = piece.imageSetting(team);

        setImage(image);
	}
	public void resetPiece()
	{
		image = null;
		setImage(null);
		this.piece = null;
	}
	public Piece getPiece()
	{
		return piece;
	}

	public void setIndex(Coordinate c)
	{
		this.c = c;
	}

	public void setIndex(int i, int j) {
		this.c.x = i;
		this.c.y = j;
	}
	
	public Coordinate getIndex()
	{
		return c;
	}

	public void setIsKing(int team) {
		isKing[team] = true;
	}

	public void notKing() {
		for(int i = 0; i < 4; i++) {
			isKing[i] = false;
		}
	}

	public void setMovable(int team) {
		movable[team] = true;
	}

	public void resetMovable() {
		for(int i = 0; i < 4; i++) {
			movable[i] = false;
		}
	}

}
