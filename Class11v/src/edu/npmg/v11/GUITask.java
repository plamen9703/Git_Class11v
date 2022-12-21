package edu.npmg.v11;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUITask {
	static JFrame mainFrame;
	static JPanel mainPanel;
	static JButton[] deleteEmp=new JButton[50];
	static JTextField[] nameEmp=new JTextField[50];
	static JTextField[] positionEmp=new JTextField[50];
	static JTextField[] salaryEmp=new JTextField[50];
	static JButton[] editEmp=new JButton[50];
	static Employ[] emps=new Employ[50];
	static int index=0;
	public static void main(String[] args) {
		mainFrame=new JFrame("Employ manager");
		mainFrame.setSize(500,500);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		
		JButton addEmploy=new JButton("Add Employ");
		addEmploy.setBounds(30, 30, 100, 30);
		mainFrame.add(addEmploy);
		addEmploy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showAddEmployFrame(emps);
			}
		});
		
		mainPanel=new JPanel();
		mainPanel.setBounds(30,100,450,350);
		mainPanel.setBackground(Color.BLUE);
		
		
		
		mainPanel.repaint();
		mainFrame.add(mainPanel);
		mainFrame.repaint();
	}
	
	public static void showAddEmployFrame(Employ[] emps) {
		JFrame f=new JFrame("New Employ");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setSize(500,500);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setLayout(null);
		
		String[] information= {"Name:","Position:","Salary:","Year experience","Salary bonus"};
		JTextField[] infoText=new JTextField[5];
		for (int i = 0; i < infoText.length; i++) {
			JLabel l=new JLabel(information[i]);
			l.setHorizontalAlignment(SwingConstants.RIGHT);
			l.setBounds(30, 30+i*35, 100, 30);
			JTextField t=new JTextField();
			t.setBounds(l.getX()+l.getWidth()+5, l.getY(), 300, 30);
			f.add(t);
			f.add(l);
			infoText[i]=t;
		}
		information= new String[]{"Add","Cancel","Edit"};
		JButton[] b=new JButton[information.length];
		for (int i = 0; i < b.length; i++) {
			JButton b1=new JButton(information[i]);
			b1.setBounds(30+i*105, infoText[infoText.length-1].getY()+infoText[infoText.length-1].getHeight()+10, 100, 30);
			f.add(b1);
			b[i]=b1;
		}
		b[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Employ e1=new Employ();
				e1.setName(infoText[0].getText());
				e1.setPosition(infoText[1].getText());
				e1.setSalary(Double.parseDouble(infoText[2].getText()));
				e1.setExperiance(Integer.parseInt(infoText[3].getText()));
				e1.setSalaryBonus(Double.parseDouble(infoText[4].getText()));
				for(int i=0;i<emps.length;i++) {
					if(emps[i]==null) {
						emps[i]=e1;
						break;
					}
				}
				f.dispose();
				addEmpToPanel(index);
				index++;
			}
		});
		
		f.repaint();
	}
	
	
	public static void addEmpToPanel(int index) {
		Container c=new Container(index);
		JButton delete=new JButton("X");
		delete.setForeground(Color.RED);
		delete.setBounds(10,30+35*index,50,30);
		mainPanel.add(delete);
		JTextField name=new JTextField(emps[index].getName());
		name.setBounds(delete.getX()+delete.getWidth()+5, delete.getY(), 100, 30);
		mainPanel.add(name);
		JTextField position=new JTextField(emps[index].getName());
		position.setBounds(name.getX()+name.getWidth()+5, delete.getY(), 100, 30);
		mainPanel.add(position);
		JTextField salary=new JTextField(emps[index].getSalary()+"");
		salary.setBounds(position.getX()+position.getWidth()+5, delete.getY(), 100, 30);
		mainPanel.add(salary);
		JButton edit=new JButton("Edit");
		edit.setForeground(Color.RED);
		edit.setBounds(salary.getX()+salary.getWidth()+5,30+35*index,80,30);
		mainPanel.add(edit);
		deleteEmp[index]=delete;
		nameEmp[index]=name;
		positionEmp[index]=position;
		salaryEmp[index]=salary;
		editEmp[index]=edit;
		mainPanel.repaint();
		
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.remove(delete);
				mainPanel.remove(edit);
				mainPanel.remove(name);
				mainPanel.remove(salary);
				mainPanel.remove(position);
				for(int i=index;i<deleteEmp.length && deleteEmp[i]!=null;i++) {
					deleteEmp[i+1].setLocation(delete.getLocation());
					nameEmp[i+1].setLocation(name.getLocation());
					positionEmp[i+1].setLocation(position.getLocation());
					salaryEmp[i+1].setLocation(salary.getLocation());
					editEmp[i+1].setLocation(edit.getLocation());
					
					deleteEmp[i]=deleteEmp[i+1];
					nameEmp[i]=nameEmp[i+1];
					positionEmp[i]=positionEmp[i+1];
					salaryEmp[i]=salaryEmp[i+1];
					editEmp[i]=editEmp[i+1];
					emps[i]=emps[i+1];
				}
				deleteEmp[deleteEmp.length-1]=null;
				nameEmp[nameEmp.length-1]=null;
				positionEmp[positionEmp.length-1]=null;
				salaryEmp[salaryEmp.length-1]=null;
				editEmp[editEmp.length-1]=null;
				emps[emps.length-1]=null;
				mainPanel.repaint();
			}
		});
	}
}
