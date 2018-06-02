import javax.swing.*;

public class GUIManager {
    public void show1Chess() {
        JFrame frame = new JFrame();

        ChessBoard chess1 = new ChessBoard();
        JPanel centerPanel;
        centerPanel = chess1.makePanel(1);
        frame.add(centerPanel);
        frame.setSize(1280,720);
        frame.setVisible(true);
    }
}
