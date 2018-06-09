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

public class MainMenu extends JFrame {
	
	private static JPanel main = new JPanel();
	private JPanel game1v1Panel = new JPanel();
	private JPanel game2v2Panel = new JPanel();
	private JLabel title = new JLabel("CHESS");
	private JButton btnOne = new JButton("1vs1");
	private JButton btnTwo = new JButton("2vs2");
	private JButton btnExit = new JButton("EXIT");
	private JButton goHome = new JButton("Main");
	private Color b1 = new Color(76, 120, 200);

	ChessBoard oneBoard = new ChessBoard();
	GameManager gm = new GameManager();
	
	public MainMenu() {

		main.setOpaque(true);
		game1v1Panel.setOpaque(true);
		game2v2Panel.setOpaque(true);
		
		setTitle("CHESS");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);

		title.setBounds(560, 20, 200, 200);
		main.setBounds(0, 0, 1280, 720);
		
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

			public void mouseClicked(MouseEvent e) {
				GameManager.gameType = 1;
				game1v1Start();
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
			public void mouseClicked(MouseEvent e)
			{
				GameManager.gameType = 2;
				game2v2Start();
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
			public void mouseClicked(MouseEvent e)
			{
				System.exit(0);
			}
		});
		goHome.setBounds(1050, 596, 128, 64);
		goHome.setBackground(Color.white);
		goHome.setForeground(Color.black);
		
		goHome.addMouseListener(new MouseAdapter() {
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
			public void mouseClicked(MouseEvent e)
			{
				if(GameManager.gameType == 1)
					game1v1Panel.setVisible(false);
				if(GameManager.gameType == 2)
					game2v2Panel.setVisible(false);
				TurnManager instance = TurnManager.getInstance();
				instance.resetTurn();
				goHome.setVisible(false);
				main.setVisible(true);
			}
		});
		main.setLayout(null);
		main.add(title);
		main.add(btnOne);
		main.add(btnTwo);
		main.add(btnExit);
		add(main);
		add(goHome);
		main.setVisible(true);
		goHome.setVisible(false);
		
		
	}

	public void game1v1Start() {
		main.setVisible(false);
		game1v1Panel = oneBoard.makeGamePanel(1);

		add(game1v1Panel);

		gm.setPosition(oneBoard.boardPiece);

		MoveManager instance = MoveManager.getInstance();
		instance.setBoard(oneBoard.boardPiece);
		gm.initListener(oneBoard.boardPiece);
		game1v1Panel.setVisible(true);
		
		goHome.setVisible(true);
	}
	public void game2v2Start()
	{
		main.setVisible(false);
		game2v2Panel = oneBoard.makeGamePanel(2);
		
		add(game2v2Panel);
		gm.setPosition2(oneBoard.boardPiece);

		MoveManager instance = MoveManager.getInstance();
		instance.setBoard(oneBoard.boardPiece);
		gm.initListener2(oneBoard.boardPiece);
		game2v2Panel.setVisible(true);
		
		goHome.setVisible(true);
	}
	
}
