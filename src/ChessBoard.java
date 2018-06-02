

	import java.awt.*;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.awt.image.BufferedImage;
	import javax.swing.JPanel;

	public class ChessBoard {
		

		JPanel boardPanel = new JPanel();
		ChessPanel[][] boardPiece = new ChessPanel[8] [8];
	    public JPanel makePanel(int type) {
	    	makeBoard(boardPanel, type);
	        return boardPanel;
	    }

	    void makeBoard(JPanel boardPanel, int type) {
	        if(type == 1) {
	            boardPanel.setSize(575, 575);
	            boardPanel.setLayout(new GridLayout(8, 8));
	            
	            for(int i = 0; i < 8; ++i) {
	                for(int j = 0; j < 8; ++j) {
	                    boardPiece[i][j] = new ChessPanel();
	                    boardPiece[i][j].setSize(575 / 8, 575 / 8);
	                    boardPiece[i][j].setOpaque(true);

	                    
	                }
	            }

	            for(int i = 0; i < 8; i++) {
	                for(int j = 0; j < 8; j++) {
	                    if((j + i) % 2 == 0)
	                        boardPiece[i][j].setBackground(new Color(254, 253, 207));
	                    else
	                        boardPiece[i][j].setBackground(new Color(242, 157, 76));
	                }
	            }

	            resetPiece(boardPiece, 1);
	            
	            for(int i = 0; i < 8; i++) {
	                for(int j = 0; j < 8; j++) {
	                    boardPanel.add(boardPiece[i][j]);
	                }
	            }
	            
	        }

	    }

	    void resetPiece(ChessPanel boardPiece[][], int type) {
	        if(type == 1) {
	            Pawn bP1 = new Pawn();
	        	boardPiece[5][6].setPiece(bP1);
			}

	    }
	    
	    

	}



