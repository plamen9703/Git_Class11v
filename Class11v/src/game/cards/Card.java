package game.cards;

import java.awt.Color;

public class Card {
	private String pow;
	private String suit;
	private Color c;
	public Card(int n) {
		setPow(n-1);
		setSuit(n-1);
	}

	private void setSuit(int n) {
		switch(n/13) {
		case 0:suit="hearts";c=Color.red;break;
		case 1:suit="clubs";c=Color.black;break;
		case 2:suit="diamonds";c=Color.RED;break;
		case 3:suit="spades";c=Color.black;break;
		}
	}

	private void setPow(int n) {
		switch(n%13) {
		case 0:pow="A";break;
		case 10:pow="J";break;
		case 11: pow="Q";break;
		case 12:pow="K";break;
		default: pow=""+(n%13+1);
		}
	}
	
	private int parsePow(String pow) {
		switch(pow) {
		case "A":return 14;
		case "J":return 11;
		case "Q": return 12;
		case "K":return 13;
		default: return Integer.parseInt(pow);
		}
	}
	
	public int compareByPow(Card c) {
		if(pow.equals(c.pow))return 0;
		int tP=parsePow(pow);
		int cP=parsePow(c.pow);
		if(tP>cP)return 1;
		return -1;
	}
	
	
	@Override
	public String toString() {
		return String.format("%s %s", pow,suit);
	}
}
