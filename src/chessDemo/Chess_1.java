package chessDemo;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
	private JPanel oneGame = new JPanel();
	private JLabel title = new JLabel("CHESS");
	private JButton btnOne = new JButton("1vs1");
	private JButton btnTwo = new JButton("2vs2");
	private JButton btnExit = new JButton("EXIT");
	private Color b1 = new Color(76, 120, 200);
	private Font f1 = new Font("D2Coding", Font.PLAIN, 30);
	ChessBoard oneBoard = new ChessBoard();
	GameManager gm = new GameManager();
	
	public Chess_1() {

		main.setOpaque(true);
		oneGame.setOpaque(true);

		setTitle("CHESS");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 드래그 못하게
		setLocationRelativeTo(null); // ()안이 'null'이면 창을 가운데에 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로세스 닫는 코드
		setVisible(true); // 보이게
		setLayout(new BorderLayout(10, 20)); //
	
		title.setBounds(585, 20, 1280, 360);
		title.setFont(f1);
		
		btnOne.setBounds(450, 280, 380, 80);
		btnOne.setBackground(b1);
		btnOne.setForeground(Color.white);
		btnOne.setFont(f1);
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
				oneGame.setLayout(new BorderLayout());
				oneGame.add(oneBoard.makeBoard(), BorderLayout.CENTER);
				add(oneGame);
				gm.setPosition(oneBoard.boardPiece);
				MoveManager instance = MoveManager.getInstance();
				instance.setBoard(oneBoard.boardPiece);
				gm.initListener(oneBoard.boardPiece);
				oneGame.setVisible(true);

				
			}
		});
		
		btnTwo.setBounds(450, 380, 380, 80);
		btnTwo.setBackground(b1);
		btnTwo.setForeground(Color.white);
		btnTwo.setFont(f1);
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
		btnExit.setFont(f1);
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
