package game.pong;

import javax.swing.JFrame;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	GamePanel gp;
	public Frame(String title) {
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);
		
		gp=new GamePanel();
		add(gp);
		
		repaint();
		gp.requestFocus();
	}
	
	
	
	public static void main(String[] args) {
		new Frame("Pong");

	}

}
