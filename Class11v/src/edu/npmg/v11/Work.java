package edu.npmg.v11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import java.awt.Insets;

public class Work extends JFrame {

	class Container{
		int i;
		
		public Container(int i) {
			this.i=i;
		}
		
	}
	
	private JPanel contentPane;
	private Employ[] emps=new Employ[10];
	private int index;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Work frame = new Work();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Work() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnShowEmplyees = new JButton("Show emplyees");
		btnShowEmplyees.setBounds(157, 5, 123, 25);
		panel.add(btnShowEmplyees);
		final Work w=this;
		JButton btnShowEmplyees_1 = new JButton("Add employ");
		btnShowEmplyees_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index==emps.length) {
					JOptionPane.showMessageDialog(null, "Array full!","Warning!", JOptionPane.WARNING_MESSAGE);
					return;
				}
				Employ em=new Employ();
				emps[index]=em;
				index++;
				em.setSalary(500);
				JButton b=new JButton("X");
				b.setForeground(Color.red);
				b.setBounds(20, 100+35*index, 50, 30);
				b.setMargin(new Insets(1, 1, 1, 1));
				panel.add(b);
				Container c=new Container(index-1);
				JTextField t=new JTextField();
				t.setBounds(b.getX()+b.getWidth()+5,b.getY(),200,30);
				panel.add(t);
				JTextField t1=new JTextField(em.getSalary()+"");
				t1.setBounds(t.getX()+t.getWidth()+5,t.getY(),200,30);
				panel.add(t1);
				JButton b1=new JButton("Edit");
				b1.setBounds(t1.getX()+t1.getWidth(), t1.getY(), 100, 30);
				b1.setMargin(new Insets(1, 1, 1, 1));
				panel.add(b1);
				b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						emps[c.i]=null;
						for(int i=c.i;i<emps.length-1;i++) {
							emps[i]=emps[i+1];
						}
						emps[emps.length-1]=null;
						panel.remove(b);
						panel.remove(t);
						panel.remove(t1);
						panel.remove(b1);
						panel.repaint();
					}
				});
				panel.repaint();
			}
		});
		btnShowEmplyees_1.setBounds(335, 5, 99, 25);
		panel.add(btnShowEmplyees_1);
	}
}
