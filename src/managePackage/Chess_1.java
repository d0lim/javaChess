package managePackage;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Chess_1 extends JFrame {
	
	private JPanel main = new JPanel();
	private JPanel game1v1Panel = new JPanel();
	private JLabel title = new JLabel("CHESS");
	private JButton btnOne = new JButton("1vs1");
	private JButton btnTwo = new JButton("2vs2");
	private JButton btnExit = new JButton("EXIT");
	private Color b1 = new Color(76, 120, 200);

	ChessBoard oneBoard = new ChessBoard();
	GameManager gm = new GameManager();
	
	public Chess_1() {

		main.setOpaque(true);
		game1v1Panel.setOpaque(true);


		setTitle("CHESS");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout(10, 20));
	
		title.setBounds(585, 20, 1280, 360);

		
		btnOne.setBounds(450, 280, 380, 80);
		btnOne.setBackground(b1);
		btnOne.setForeground(Color.white);

		btnOne.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e)
			{
				btnOne.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				btnOne.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e)
			{
				main.setVisible(false);
				game1v1Panel = oneBoard.makeGamePanel();

				add(game1v1Panel);

				gm.setPosition(oneBoard.boardPiece);

				MoveManager instance = MoveManager.getInstance();
				instance.setBoard(oneBoard.boardPiece);
				gm.initListener(oneBoard.boardPiece);
				game1v1Panel.setVisible(true);

				
			}
		});
		
		btnTwo.setBounds(450, 380, 380, 80);
		btnTwo.setBackground(b1);
		btnTwo.setForeground(Color.white);

		btnTwo.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e)
			{
				btnTwo.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				btnTwo.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e)
			{
				
			}
		});
		
		btnExit.setBounds(450, 480, 380, 80);
		btnExit.setBackground(b1);
		btnExit.setForeground(Color.white);

		btnExit.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e)
			{
				btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				btnExit.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e)
			{
				System.exit(0);
			}
		});
		main.setLayout(null);
		main.add(title);
		main.add(btnOne);
		main.add(btnTwo);
		main.add(btnExit);
		add(main, BorderLayout.CENTER);
		main.setVisible(true);
		
	}
	
}
