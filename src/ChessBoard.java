	import java.awt.*;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.awt.image.BufferedImage;
	import javax.swing.JPanel;

	public class ChessBoard {
		
		public static Color pc;
		public static Color qc;
		private int i, j;
		ChessPanel boardPanel = new ChessPanel();
	    ChessPanel[][] boardPiece = new ChessPanel[8][8];
	    public ChessPanel makeBoard() {
	        	
	            boardPanel.setSize(575, 575);
	            boardPanel.setLayout(new GridLayout(8, 8));
	            
	            for(i = 0; i < 8; ++i) {
	                for(j = 0; j < 8; ++j) {
	                    boardPiece[i][j] = new ChessPanel();
	                    boardPiece[i][j].setSize(575 / 8, 575 / 8);
	                    boardPiece[i][j].setOpaque(true);  
	                    if((j + i) % 2 == 0)
	                        boardPiece[i][j].setBackground(new Color(254, 253, 207));
	                    else
	                        boardPiece[i][j].setBackground(new Color(242, 157, 76));
	                    
	                    boardPanel.add(boardPiece[i][j]);
	                    
	                    boardPiece[i][j].setIndex(i, j);
	                    
	                }
	            }
			return boardPanel;
	    }
}


