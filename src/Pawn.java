import java.awt.image.BufferedImage;

public class Pawn extends Piece {


    ChessPieceSprite instance = ChessPieceSprite.getInstace();

    BufferedImage imageSetting(int team) {
        BufferedImage pieceSprite = null;
        if (team == 1) {
            pieceSprite = instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.WHITE_PAWN);
        }


        return pieceSprite;
    }




}
