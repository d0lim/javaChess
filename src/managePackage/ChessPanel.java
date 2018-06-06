package managePackage;

import kr.ac.cau.mecs.lenerd.chess.ImagePanel;
import piecesPackage.Piece;

import java.awt.image.BufferedImage;

public class ChessPanel extends ImagePanel {
	public Piece piece;
	public Coordinate c = new Coordinate();
	public BufferedImage image;
	
	public void setPiece(Piece piece, int team)
	{
        this.piece = piece;
		piece.team = team;
        image = piece.imageSetting(team);

        setImage(image);
	}
	public void resetPiece()
	{
		this.image = null;

		setImage(null);
		this.piece = null;
	}
	public Piece getPiece()
	{
		return piece;
	}

	public void setIndex(int i, int j) {
		this.c.x = i;
		this.c.y = j;
	}
	
	public Coordinate getIndex()
	{
		return c;
	}

	public void setIsKing(int team){
		GameManager.kingC[team] = c;
	}


}
