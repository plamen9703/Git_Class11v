package game.cards;

import java.awt.Color;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class CardGameFrameHelper {
	private Player[] p;
	private JLabel[] l;
	JLabel info=new JLabel("Click \"Start\" to begin game!");
	
	boolean runGame;
	boolean game;
	
	private Random r=new Random();
	private int turnPlayer=0;
	private Player holder;
	private int chalange;
	
	public CardGameFrameHelper(int numPlayers) {
		p=createPlayers(numPlayers);
		l=createPlayerLables(p);
		game=true;
		info.setBorder(new LineBorder(Color.BLACK));
		info.setBounds(20, 300, 450, 30);
		info.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	private boolean game(Player[] p) {
		int i=0;
		for (int j = 0; j < p.length; j++) {
			if(p[i].hasCards())i++;
			if(i>1)return true;
		}
		return false;
	}
	
	private JLabel[] createPlayerLables(Player[] p) {
		int space=60;
		JLabel[] l=new JLabel[p.length*2];
		for(int i=0;i<l.length;i+=2) {
			l[i]=new JLabel(p[i/2].numberCards()+"");
			l[i].setBounds(30+i*space,30,40,60);
			l[i].setHorizontalAlignment(SwingConstants.CENTER);
			l[i].setOpaque(true);
			l[i].setBackground((i==0)?Color.green:Color.red);
			l[i].setForeground((i==0)?Color.blue:Color.white);
			
			l[i+1]=new JLabel();
			l[i+1].setBounds(30+i*space, 150, 40, 60);
			l[i+1].setHorizontalAlignment(SwingConstants.CENTER);
			l[i+1].setOpaque(true);
			l[i+1].setBorder(new LineBorder(Color.black));
		}
		return l;
	}
	
	private Player[] createPlayers(int numPlayers) {
		Player[] p=new Player[numPlayers];
		for (int i = 0; i < p.length; i++) {
			p[i]=new Player();
		}
		Card[] deck=createDeck();
		for (int i = 0; i < deck.length; i+=numPlayers) {
			for (int j = 0; j < p.length; j++) {
				if(i+j<deck.length)
					p[j].addCard(deck[i+j]);
			}
		}
		return p;
	}
	
	private Card[] createDeck() {
		Card[] deck=new Card[52];
		for (int i = 0; i < deck.length; i++) {
			deck[i]=new Card(i+1);
		}
		return deck;
	}
	
	public JLabel[] getLabels() {
		return l;
	}
	
	public Player[] getPlayers() {
		return p;
	}

	public int perfomeStep(int step) {
		int i=0;
		switch(step) {
		case 0://TODO:show chalange of players
			getChalange();
			i=1;
			break;
		case 1://TODO: players pressend cards
			break;
		case 2://TODO: compare cards and return to prev step if war
			break;
		case 3://TODO: the winning player gets the cards
			break;
		case 4://TODO: go to the next turn player
			break;
		}
		return  i;
	}

	private void getChalange() {
		if(turnPlayer==0) {
			if(p.length==2)chalange=1;
			else {
				String p=(this.p.length==3)?"2 3":"2 3 4";
				chalange=Integer.parseInt((String) JOptionPane.showInputDialog(null,"Choose player to chalange:","Input",0,null,p.split(" "),"2"));
			}
		}else {
			do {
				chalange=r.nextInt(p.length);
			}while(chalange==turnPlayer);
		}
		info.setText(String.format("Player %d chalanges Player %d.", turnPlayer, chalange));
	}
	
}
