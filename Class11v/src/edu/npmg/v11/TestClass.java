package edu.npmg.v11;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestClass {

	public static void main(String[] args) {
		JFrame f=new JFrame();
		f.setSize(500,500);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setVisible(true);
		JPanel p=new JPanel();
		p.setBounds(0, 0, 350, 350);
		p.setBackground(Color.BLACK);
		f.add(p);
		Graphics2D g=(Graphics2D)p.getGraphics();
		
		g.setColor(Color.YELLOW);
		g.fillRect(50, 50, 100, 100);
	}

}
