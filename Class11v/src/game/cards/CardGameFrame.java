package game.cards;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Timer;
//import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class CardGameFrame {
	public static void main(String[] args) {
		String text="Choose number of players:";
		Integer[] options= {2,3,4};
		String input=""+JOptionPane.showInputDialog(null, text,"Input",JOptionPane.INFORMATION_MESSAGE,null,options,-1);
		if(input.equals("null"))return;
		int numPlayers=Integer.parseInt(input);
		
		CardGameFrameHelper ch=new CardGameFrameHelper(numPlayers);
		
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,500);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		f.setVisible(true);
		
		JLabel[] l=ch.getLabels();
		for (int i = 0; i < l.length; i++) {
			f.add(l[i]);
		}
		
		
		f.add(ch.info);

		JButton control=new JButton("Start");
		control.setBounds(175, 340, 150, 50);
		control.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text=control.getText();
				if(text.equals("Start")|| text.equals("Resume")) 
					control.setText("Pause");
				else
					control.setText("Resume");
				ch.runGame=!ch.runGame;
			}
		});
		f.add(control);
		f.repaint();
		Timer t=null;
		t=new Timer(1000,new ActionListener() {
			int step=0;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ch.game && !ch.runGame)return;
//				step+=ch.perfomeStep(step);
				ch.perfomeStep(numPlayers);
			}
		});
		t.start();
		t.stop();
//		TimerTask task=new TimerTask() {
//			int step=0;
//			@Override
//			public void run() {
//				System.out.println("hello");
//				if(!ch.runGame)return;
//				ch.perfomeStep(step);
//				step++;
//			}
//		};
//		t.scheduleAtFixedRate(task, 5000, 1000);
	}

	

}
