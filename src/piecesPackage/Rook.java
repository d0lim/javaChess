package piecesPackage;

import managePackage.ChessPanel;
import kr.ac.cau.mecs.lenerd.chess.ChessPieceSprite;
import managePackage.ColorM;
import managePackage.Coordinate;
import managePackage.GameManager;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Rook extends Piece {
    ChessPieceSprite instance = ChessPieceSprite.getInstace();

    public Rook(int x, int y) {
        super(x, y);
    }

    public BufferedImage imageSetting(int team)
    {
        BufferedImage image1 = null;
        if(GameManager.gameType == 1) {
            if(team == 0)
                image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_LOOK);
            else if(team == 1)
                image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_LOOK);

        }
        else if(GameManager.gameType == 2) {

            if (team == 0)
                image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_LOOK);
            else if (team == 1)
                image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.RED_LOOK);
            else if (team == 2)
                image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_LOOK);
            else if (team == 3)
                image1 = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.GREEN_LOOK);

        }
        return image1;
    }

    @Override
    public void highlight(ChessPanel[][] boardPiece, Coordinate c) {
        for (int i = -1; i < 2; i += 2) {
            try {
                for (int j = 1; ; j++) {
                    if (boardPiece[c.x + (i) * j][c.y].piece == null) {
                            if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + (i) * j][c.y]))
                            boardPiece[c.x + (i) * j][c.y].setBackground(ColorM.moveH);
                    } else {
                        if (boardPiece[c.x + (i) * j][c.y].piece.team % 2 != this.team % 2 && boardPiece[c.x + i * j][c.y].piece.team > -1) {
                            if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x + (i) * j][c.y]))
                                boardPiece[c.x + (i) * j][c.y].setBackground(ColorM.attackH);
                        }
                        break;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {
            }
        }
        for (int i = -1; i < 2; i += 2) {
            try {
                for (int j = 1; ; j++) {
                    if (boardPiece[c.x][c.y + (i) * j].piece == null) {
                        if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y + (i) * j]))
                            boardPiece[c.x][c.y + (i) * j].setBackground(ColorM.moveH);
                    } else {
                        if (boardPiece[c.x][c.y + (i) * j].piece.team % 2 != this.team % 2 && boardPiece[c.x][c.y + i * j].piece.team > -1) {
                            if (!src.selfrisk(boardPiece, boardPiece[c.x][c.y], boardPiece[c.x][c.y + (i) * j]))
                                boardPiece[c.x][c.y + (i) * j].setBackground(ColorM.attackH);
                        }
                        break;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {
            }
        }
    }
}
