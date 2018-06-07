package piecesPackage;

import managePackage.*;
import kr.ac.cau.mecs.lenerd.chess.ChessPieceSprite;

import java.awt.*;
import java.awt.image.BufferedImage;

public class King extends Piece {
	ChessPieceSprite instance = ChessPieceSprite.getInstace();
	CheckCheck checkInstance = CheckCheck.getInstance();

	public King(int x, int y) {
		super(x, y);
	}

	public BufferedImage imageSetting(int team) {
		BufferedImage image1 = null;
		if(GameManager.gameType == 1) {
			if(team == 0)
				image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_KING);
			else if(team == 1)
				image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_KING);

		}
		else if(GameManager.gameType == 2) {

			if (team == 0)
				image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_KING);
			else if (team == 1)
				image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.RED_KING);
			else if (team == 2)
				image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_KING);
			else if (team == 3)
				image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.GREEN_KING);

		}
		return image1;
	}

	@Override
	public void highlight(ChessPanel[][] boardPiece, Coordinate c) {

		try {
			if (boardPiece[c.x - 1][c.y - 1].piece == null) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y - 1]))
					boardPiece[c.x - 1][c.y - 1].setBackground(ColorM.moveH);
			} else if (boardPiece[c.x - 1][c.y - 1].piece.team != TurnManager.turn && boardPiece[c.x - 1][c.y - 1].piece.team > -1) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y - 1]))
					boardPiece[c.x - 1][c.y - 1].setBackground(ColorM.attackH);
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {}

		try {
			if (boardPiece[c.x - 1][c.y].piece == null) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y]))
					boardPiece[c.x - 1][c.y].setBackground(ColorM.moveH);
			} else if (boardPiece[c.x - 1][c.y].piece.team != TurnManager.turn && boardPiece[c.x - 1][c.y].piece.team > -1) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y]))
					boardPiece[c.x - 1][c.y].setBackground(ColorM.attackH);
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {}
		try {
			if (boardPiece[c.x - 1][c.y + 1].piece == null) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y + 1]))
					boardPiece[c.x - 1][c.y + 1].setBackground(ColorM.moveH);
			} else if (boardPiece[c.x - 1][c.y + 1].piece.team != TurnManager.turn && boardPiece[c.x - 1][c.y + 1].piece.team > -1) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x - 1][c.y + 1]))
					boardPiece[c.x - 1][c.y + 1].setBackground(ColorM.attackH);
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {}
		try {
			if (boardPiece[c.x][c.y - 1].piece == null) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y - 1]))
					boardPiece[c.x][c.y - 1].setBackground(ColorM.moveH);
			} else if (boardPiece[c.x][c.y - 1].piece.team != TurnManager.turn && boardPiece[c.x][c.y - 1].piece.team > -1) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y - 1]))
					boardPiece[c.x][c.y - 1].setBackground(ColorM.attackH);
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {}

		try {
			if (boardPiece[c.x][c.y + 1].piece == null) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y + 1]))
					boardPiece[c.x][c.y + 1].setBackground(ColorM.moveH);
			} else if (boardPiece[c.x][c.y + 1].piece.team != TurnManager.turn && boardPiece[c.x][c.y + 1].piece.team > -1) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y + 1]))
					boardPiece[c.x][c.y + 1].setBackground(ColorM.attackH);
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {}

		try {
			if (boardPiece[c.x + 1][c.y - 1].piece == null) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y - 1]))
					boardPiece[c.x + 1][c.y - 1].setBackground(ColorM.moveH);
			} else if (boardPiece[c.x + 1][c.y - 1].piece.team != TurnManager.turn && boardPiece[c.x + 1][c.y - 1].piece.team > -1) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y - 1]))
					boardPiece[c.x + 1][c.y - 1].setBackground(ColorM.attackH);
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {}

		try {
			if (boardPiece[c.x + 1][c.y].piece == null) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y]))
					boardPiece[c.x + 1][c.y].setBackground(ColorM.moveH);
			} else if (boardPiece[c.x + 1][c.y].piece.team != TurnManager.turn && boardPiece[c.x + 1][c.y].piece.team > -1) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y]))
					boardPiece[c.x + 1][c.y].setBackground(ColorM.attackH);
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {}

		try {
			if (boardPiece[c.x + 1][c.y + 1].piece == null) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y + 1]))
					boardPiece[c.x + 1][c.y + 1].setBackground(ColorM.moveH);
			} else if (boardPiece[c.x + 1][c.y + 1].piece.team != TurnManager.turn && boardPiece[c.x + 1][c.y + 1].piece.team > -1) {
				if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + 1][c.y + 1]))
					boardPiece[c.x + 1][c.y + 1].setBackground(ColorM.attackH);
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {}
		// Castleling

		if(GameManager.gameType == 1) {
			if (this.team == 0) {
				if (!this.SpecialMove) {
					if (boardPiece[7][7].piece != null && !boardPiece[7][7].piece.SpecialMove) {
						if (boardPiece[7][6].piece == null && boardPiece[7][5].piece == null) {
							if ((!GameManager.Checked[0]
									&& checkInstance.checkCheck(boardPiece, new Coordinate(7, 5)) == 0)
									&& checkInstance.checkCheck(boardPiece, new Coordinate(7, 6)) == 0)
								boardPiece[7][6].setBackground(ColorM.SpecialH);
						}
					}
				}
				if (!this.SpecialMove) {
					if (boardPiece[7][0].piece != null && !boardPiece[7][0].piece.SpecialMove) {
						if ((boardPiece[7][1].piece == null && boardPiece[7][2].piece == null) && boardPiece[7][3].piece == null) {
							if ((!GameManager.Checked[0]
									&& checkInstance.checkCheck(boardPiece, new Coordinate(7, 3)) == 0)
									&& checkInstance.checkCheck(boardPiece, new Coordinate(7, 2)) == 0)
								boardPiece[7][2].setBackground(ColorM.SpecialH);
						}
					}
				}
			}
			if (this.team == 1) {
				if (!this.SpecialMove) {
					if (boardPiece[0][7].piece != null && !boardPiece[0][7].piece.SpecialMove) {
						if (boardPiece[0][6].piece == null && boardPiece[0][5].piece == null) {
							if ((!GameManager.Checked[1]
									&& checkInstance.checkCheck(boardPiece, new Coordinate(0, 5)) == 0)
									&& checkInstance.checkCheck(boardPiece, new Coordinate(0, 6)) == 0)
								boardPiece[0][6].setBackground(ColorM.SpecialH);
						}
					}
				}
				if (!this.SpecialMove) {
					if (boardPiece[0][0].piece != null && !boardPiece[0][0].piece.SpecialMove) {
						if ((boardPiece[0][1].piece == null && boardPiece[0][2].piece == null) && boardPiece[0][3].piece == null) {
							if ((!GameManager.Checked[1]
									&& checkInstance.checkCheck(boardPiece, new Coordinate(0, 3)) == 0)
									&& checkInstance.checkCheck(boardPiece, new Coordinate(0, 2)) == 0)
								boardPiece[0][2].setBackground(ColorM.SpecialH);
						}
					}
				}
			}
		}
		else {
			if (this.team == 0) {
				if (!this.SpecialMove) {
					if (boardPiece[13][10].piece != null && !boardPiece[13][10].piece.SpecialMove) {
						if (boardPiece[13][9].piece == null && boardPiece[13][8].piece == null) {
							if ((!GameManager.Checked[0]
									&& checkInstance.checkCheck(boardPiece, new Coordinate(13, 9)) == 0)
									&& checkInstance.checkCheck(boardPiece, new Coordinate(13, 8)) == 0)
								boardPiece[13][9].setBackground(ColorM.SpecialH);
						}
					}
				}
				if (!this.SpecialMove) {
					if (boardPiece[13][3].piece != null && !boardPiece[13][3].piece.SpecialMove) {
						if ((boardPiece[13][4].piece == null && boardPiece[13][5].piece == null) && boardPiece[13][6].piece == null) {
							if ((!GameManager.Checked[0]
									&& checkInstance.checkCheck(boardPiece, new Coordinate(13, 6)) == 0)
									&& checkInstance.checkCheck(boardPiece, new Coordinate(13, 5)) == 0)
								boardPiece[13][5].setBackground(ColorM.SpecialH);
						}
					}
				}
			}
			if (this.team == 1) {
				if (!this.SpecialMove) {
					if (boardPiece[3][0].piece != null && !boardPiece[3][0].piece.SpecialMove) {
						if (boardPiece[4][0].piece == null && boardPiece[5][0].piece == null) {
							if ((!GameManager.Checked[1]
									&& checkInstance.checkCheck(boardPiece, new Coordinate(5, 0)) == 0)
									&& checkInstance.checkCheck(boardPiece, new Coordinate(4, 0)) == 0)
								boardPiece[4][0].setBackground(ColorM.SpecialH);
						}
					}
				}
				if (!this.SpecialMove) {
					if (boardPiece[10][0].piece != null && !boardPiece[10][0].piece.SpecialMove) {
						if ((boardPiece[9][0].piece == null && boardPiece[8][0].piece == null) && boardPiece[7][0].piece == null) {
							if ((!GameManager.Checked[1]
									&& checkInstance.checkCheck(boardPiece, new Coordinate(7, 0)) == 0)
									&& checkInstance.checkCheck(boardPiece, new Coordinate(8, 0)) == 0)
								boardPiece[8][0].setBackground(ColorM.SpecialH);
						}
					}
				}
			}
			if (this.team == 2) {
				if (!this.SpecialMove) {
					if (boardPiece[0][3].piece != null && !boardPiece[0][3].piece.SpecialMove) {
						if (boardPiece[0][4].piece == null && boardPiece[0][5].piece == null) {
							if ((!GameManager.Checked[2]
									&& checkInstance.checkCheck(boardPiece, new Coordinate(0, 4)) == 0)
									&& checkInstance.checkCheck(boardPiece, new Coordinate(0, 5)) == 0)
								boardPiece[0][4].setBackground(ColorM.SpecialH);
						}
					}
				}
				if (!this.SpecialMove) {
					if (boardPiece[0][10].piece != null && !boardPiece[0][10].piece.SpecialMove) {
						if ((boardPiece[0][9].piece == null && boardPiece[0][8].piece == null) && boardPiece[0][7].piece == null) {
							if ((!GameManager.Checked[2]
									&& checkInstance.checkCheck(boardPiece, new Coordinate(0, 7)) == 0)
									&& checkInstance.checkCheck(boardPiece, new Coordinate(0, 8)) == 0)
								boardPiece[0][8].setBackground(ColorM.SpecialH);
						}
					}
				}
			}
			if (this.team == 3) {
				if (!this.SpecialMove) {
					if (boardPiece[13][10].piece != null && !boardPiece[13][10].piece.SpecialMove) {
						if (boardPiece[13][9].piece == null && boardPiece[13][8].piece == null) {
							if ((!GameManager.Checked[3]
									&& checkInstance.checkCheck(boardPiece, new Coordinate(13, 9)) == 0)
									&& checkInstance.checkCheck(boardPiece, new Coordinate(13, 8)) == 0)
								boardPiece[13][9].setBackground(ColorM.SpecialH);
						}
					}
				}
				if (!this.SpecialMove) {
					if (boardPiece[13][3].piece != null && !boardPiece[13][3].piece.SpecialMove) {
						if ((boardPiece[13][4].piece == null && boardPiece[13][5].piece == null) && boardPiece[13][6].piece == null) {
							if ((!GameManager.Checked[3]
									&& checkInstance.checkCheck(boardPiece, new Coordinate(13, 6)) == 0)
									&& checkInstance.checkCheck(boardPiece, new Coordinate(13, 5)) == 0)
								boardPiece[13][6].setBackground(ColorM.SpecialH);
						}
					}
				}
			}
		}
	}
}

