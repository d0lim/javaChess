package piecesPackage;

import managePackage.ChessPanel;
import managePackage.Coordinate;

import java.awt.image.BufferedImage;

public class Wall extends Piece{

    public Wall(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public BufferedImage imageSetting(int team) {
        return null;
    }

}
