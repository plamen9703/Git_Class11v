package edu.npmg.v11;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
public class ButtonTest extends JButton{
	List<Integer> l=new LinkedList<>();
	
	public ButtonTest(String s) {
		setText(s);
		addActionListener(e->{
			
		});
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("", 10, 20);
	}
	
	public static void main(String[] args) {
//		JFrame f=new JFrame();
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setSize(500,500);
//		f.setLocationRelativeTo(null);
//		f.setLayout(null);
//		f.setVisible(true);
//		ButtonTest b=new ButtonTest("4");
//		b.setBounds(50,50,100,100);
//		f.add(b);
//		f.repaint();
		
		Scanner input = new Scanner (System.in);
		String string = input.nextLine();
		int id = 0;
		int [] arr = new int [100];
		int last = 0;
		for (int i=0; i<string.length(); i++) {
			if (string.charAt(i) >= '0' && string.charAt(i) <= '9' ) {
			arr[last] = Integer.parseInt(string.substring(i, i+1));
			last ++;
			}
	 	}
		int [] arr2=new int[last];
		for (int i=0; i<last; i++) {
			arr2[i] = arr[i];
		}
		Arrays.sort(arr2);
		for (int i=0; i<last; i++) {
			System.out.print(arr2[i]);
		}
	}
}
