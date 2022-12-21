package game.dotsandboxes;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frame extends JFrame{
	
	private static final int width=600;
	private static final int height=600;
	public Frame(final int gridLayout) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width,height);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		Panel p=new Panel(width,height, gridLayout);
		add(p);
		repaint();
	}
	
	
	public static void main(String[] args) {
		Integer choises[]= {6,8,10};
		Integer i=(Integer)JOptionPane.showInputDialog(null,"Choose game layout:","Input",JOptionPane.INFORMATION_MESSAGE,null,choises, choises[0]);
		if(i==null)return;
		new Frame(i*2-1);
	}
}
