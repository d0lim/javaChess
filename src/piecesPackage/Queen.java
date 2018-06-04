package piecesPackage;

import chessDemo.ChessPanel;
import kr.ac.cau.mecs.lenerd.chess.ChessPieceSprite;
import chessDemo.Coordinate;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Queen extends Piece {
	ChessPieceSprite instance = ChessPieceSprite.getInstace();
	
	public BufferedImage imageSetting(int team)
	{
		BufferedImage image1 = null;
		if(team == 0)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_QUEEN);
		else if(team == 1)
			image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_QUEEN);
		return image1;
	}
	@Override
	public void highlight(ChessPanel[][] boardPiece, Coordinate c) {
		for (int i = -1; i < 2; i += 2) {
			try {
				for (int j = 1;; j++) {
					if (checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y],
							boardPiece[c.x + (i) * j][c.y + (i) * j]) == false) {
						if (boardPiece[c.x + (i) * j][c.y + (i) * j].image == null)
							boardPiece[c.x + (i) * j][c.y + (i) * j].setBackground(new Color(145, 255, 228));
						else {
							if (boardPiece[c.x + (i) * j][c.y + (i) * j].piece.team % 2 != this.team % 2)
								boardPiece[c.x + (i) * j][c.y + (i) * j].setBackground(new Color(255, 97, 160));
							break;
						}
					}
				}
			} catch (ArrayIndexOutOfBoundsException a) {
			}
			;
		}
		for (int i = -1; i < 2; i += 2) {
			try {
				for (int j = 1;; j++) {
					if (checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y],
							boardPiece[c.x + (i) * j][c.y - (i) * j]) == false) {
						if (boardPiece[c.x + (i) * j][c.y - (i) * j].image == null)
							boardPiece[c.x + (i) * j][c.y - (i) * j].setBackground(new Color(145, 255, 228));
						else {
							if (boardPiece[c.x + (i) * j][c.y - (i) * j].piece.team % 2 != this.team % 2)
								boardPiece[c.x + (i) * j][c.y - (i) * j].setBackground(new Color(255, 97, 160));
							break;
						}
					}
				}
			} catch (ArrayIndexOutOfBoundsException a) {
			}
			;
		}
		for (int i = -1; i < 2; i += 2) {
			try {
				for (int j = 1;; j++) {
					if (checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + (i) * j][c.y]) == false) {
						if (boardPiece[c.x + (i) * j][c.y].image == null)
							boardPiece[c.x + (i) * j][c.y].setBackground(new Color(145, 255, 228));
						else {
							if (boardPiece[c.x + (i) * j][c.y].piece.team % 2 != this.team % 2)
								boardPiece[c.x + (i) * j][c.y].setBackground(new Color(255, 97, 160));
							break;
						}
					}
				}
			} catch (ArrayIndexOutOfBoundsException a) {
			}
			;
		}
		for (int i = -1; i < 2; i += 2) {
			try {
				for (int j = 1;; j++) {
					if (checkmate.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y + (i) * j]) == false) {
						if (boardPiece[c.x][c.y + (i) * j].image == null)
							boardPiece[c.x][c.y + (i) * j].setBackground(new Color(145, 255, 228));
						else {
							if (boardPiece[c.x][c.y + (i) * j].piece.team % 2 != this.team % 2)
								boardPiece[c.x][c.y + (i) * j].setBackground(new Color(255, 97, 160));
							break;
						}
					}
				}
			} catch (ArrayIndexOutOfBoundsException a) {
			}
			;
		}
	}

	@Override
	public boolean checkPath(ChessPanel[][] boardPiece, Coordinate panelC) {
        if(this.team == 0) {
            for(int k = 0; k < 4; k++) {
                if(k == 0)
                    continue;
                for(int i = -1 ; i < 2 ; i += 2)
                {
                    try {
                        for(int j=1;;j++)
                        {

                            if(boardPiece[panelC.x+(i)*j][panelC.y+(i)*j].piece != null) {
                                if(boardPiece[panelC.x + (i) * j][panelC.y + (i) * j].isKing[k]) {
                                    System.out.println("Queen Made Check team 0 bishop 0");
                                    return true;
                                }
                                else
                                    break;
                            }

                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}
                }
                for(int i=-1 ; i<2 ; i+=2)
                {
                    try {
                        for(int j=1;;j++)
                        {
                            if(boardPiece[panelC.x+(i)*j][panelC.y-(i)*j].piece != null) {
                                if(boardPiece[panelC.x + (i) * j][panelC.y - (i) * j].isKing[k]) {
                                    System.out.println("Queen Made Check team 0 bishop 1");
                                    return true;
                                }
                                //when code goes into else, then the method do not judge other location.
                                else
                                    break;

                            }

                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}
                }
                for(int i=-1 ; i<2 ; i+=2)
                {
                    try {
                        for(int j=1;;j++)
                        {
                            if(boardPiece[panelC.x+(i)*j][panelC.y].piece != null) {
                                if(boardPiece[panelC.x + (i) * j][panelC.y].isKing[k]) {
                                    System.out.println("Quuen Made Check team 0 rook 1");
                                    return true;
                                }
                                else
                                    break;

                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}
                }
                for(int i=-1 ; i<2 ; i+=2)
                {
                    try {
                        for(int j=1;;j++)
                        {
                            if(boardPiece[panelC.x][panelC.y+(i)*j].piece != null) {
                                if(boardPiece[panelC.x][panelC.y + (i) * j].isKing[k]) {
                                    System.out.println("Queen Made Check team 0 rook 2");
                                    return true;
                                }
                                else
                                    break;

                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}
                }
            }
        }
        else if(this.team == 1) {
            for(int k = 0; k < 4; k++) {
                if(k == 1)
                    continue;
                for(int i = -1 ; i < 2 ; i += 2)
                {
                    try {
                        for(int j=1;;j++)
                        {
                            if(boardPiece[panelC.x+(i)*j][panelC.y+(i)*j].piece != null) {
                                if(boardPiece[panelC.x + (i) * j][panelC.y + (i) * j].isKing[k]) {
                                    System.out.println("Queen Made Check team 1 bishop 0");
                                    return true;
                                }
                                else
                                    break;


                            }

                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}
                }
                for(int i=-1 ; i<2 ; i+=2)
                {
                    try {
                        for(int j=1;;j++)
                        {
                            if(boardPiece[panelC.x+(i)*j][panelC.y-(i)*j].piece != null) {
                                if(boardPiece[panelC.x + (i) * j][panelC.y - (i) * j].isKing[k]) {
                                    System.out.println("Queen Made Check team 1 bishop 1");
                                    return true;
                                }
                                else
                                    break;

                            }

                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}
                }
                for(int i=-1 ; i<2 ; i+=2)
                {
                    try {
                        for(int j=1;;j++)
                        {
                            if(boardPiece[panelC.x+(i)*j][panelC.y].piece != null) {
                                if(boardPiece[panelC.x + (i) * j][panelC.y].isKing[k]) {
                                    System.out.println("Quuen Made Check team 1 rook 1");
                                    return true;
                                }
                                else
                                    break;

                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}
                }
                for(int i=-1 ; i<2 ; i+=2)
                {
                    try {
                        for(int j=1;;j++)
                        {
                            if(boardPiece[panelC.x][panelC.y+(i)*j].piece != null) {
                                if(boardPiece[panelC.x][panelC.y + (i) * j].isKing[k]) {
                                    System.out.println("Queen Made Check team 1 rook 2");
                                    return true;
                                }
                                else
                                    break;

                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}
                }
            }
        }





		return false;
	}

}
