package chessDemo;

import java.awt.image.BufferedImage;

public class Wall extends Piece{

    private static Wall wallInstance = new Wall();

    private Wall() {
        System.out.println("You have loaded wall Instance!");
    }
    public static Wall getInstance() {
        return wallInstance;
    }

    @Override
    BufferedImage imageSetting(int team) {
        return null;
    }


    @Override
    public boolean checkPath(ChessPanel[][] boardPiece, Coordinate panelC) {
        return false;
    }
}
