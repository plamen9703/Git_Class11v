package game.cards;

import java.util.Arrays;

public class Player {
	private Card[] deck;
	
	public Player() {
		deck=new Card[52];
	}
	
	public void addCard(Card c) {
		for(int i=0;i<deck.length;i++) {
			if(deck[i]==null) {
				deck[i]=c;
				return;
			}
		}
	}
	
	public void addCard(Card[] c) {
		for(Card c1:c) 
			addCard(c1);
		
	}
	
	public Card takeCard() {
		Card c=deck[0];
		for(int i=0;i<deck.length-1;i++) {
			deck[i]=deck[i+1];
		}
		deck[deck.length-1]=null;
		return c;
	}
	
	public Card[] takeCard(int n) {
		Card[] cards=new Card[n];
		for (int i = 0; i < cards.length; i++) {
			cards[i]=takeCard();
		}
		return cards;
	}
	
	public boolean hasCards() {
		return deck[0]!=null;
	}
	
	public void printDeck() {
		System.out.println(Arrays.toString(deck));
	}
	
	public Card[] getDeck() {
		int br=0;
		for (int i = 0; i < deck.length; i++) {
			if(deck[i]==null)break;
			br++;
		}
		Card[] cards=new Card[br];
		for (int i = 0; i < cards.length; i++) {
			cards[i]=deck[i];
		}
		deck=new Card[52];
		return cards;
	}
	
	public int numberCards() {
		int br=0;
		for(int i=0;deck[i]!=null;i++) {
			br++;
		}
		return br;
	}
}
