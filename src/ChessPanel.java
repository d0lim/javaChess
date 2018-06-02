

public class ChessPanel extends ImagePanel{
	Piece piece;
	
	public void setPiece(Piece piece)
	{
		this.piece = piece;
		setImage(piece.imageSetting(1));
	}
	
	public Piece getPiece()
	{
		
		return piece;
	}
	
}
