import javax.swing.*;

public class Game1 {
    public static void main(String args[]) {
        JFrame frame = new JFrame("1v1");
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        ChessPieceSprite instance = ChessPieceSprite.getInstace();
        ImageIcon pieceSprite = new ImageIcon(instance.getChessPiece(ChessPieceSprite.ChessPieceSpriteType.BLACK_KING));
        JLabel lb = new JLabel(pieceSprite);
        frame.add(lb);

        frame.setVisible(true);

    }
}
