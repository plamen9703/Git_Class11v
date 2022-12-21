package edu.npmg.v11;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class GUI {
	public static void main(String[] args) {
		JFrame frame=new JFrame("Frame 1");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		
		JTextField text1=new JTextField();
		JTextField text2=new JTextField();
		text1.setBounds(30,30,150,30);
		text2.setBounds(text1.getX()+text1.getWidth()+50,text1.getY(),150,30);
		frame.add(text1);
		frame.add(text2);
		
		JLabel l=new JLabel("Result:");
		l.setBounds(text2.getX()+text2.getWidth()+20, text2.getY(), 200, 30);
		frame.add(l);
		JButton b=new JButton("Calculate");
		b.setBounds(text1.getX()+20, text1.getY()+text1.getHeight()+30, 200, 30);
		frame.add(b);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double num1;
				double num2;
				num1=Double.parseDouble(text1.getText());
				num2=Double.parseDouble(text2.getText());
				double sum=num1+num2;
				l.setText(String.format("Result: %.2f", sum));
			}
		});
		
		JLabel picture=new JLabel();
		ImageIcon image=new ImageIcon("sun.jpg");
		picture.setBounds(30,250,150,150);
		picture.setIcon(new ImageIcon(image.getImage().getScaledInstance(picture.getWidth(), picture.getHeight(), Image.SCALE_DEFAULT)));
		frame.add(picture);
		
		frame.repaint();
	}
}
