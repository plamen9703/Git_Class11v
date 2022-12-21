package game.cards;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CardGames {
	private Card[] deck = new Card[52];
	private Player[] players;
	private Random r = new Random();
	private Scanner s = new Scanner(System.in);
	private int turnPlayer;
	private Player holder=new Player();
	public CardGames() {
		for (int i = 0; i < deck.length; i++) {
			deck[i] = new Card(i + 1);
		}
	}

	private void createPlayers(int n) {
		players = new Player[n];
		for (int i = 0; i < players.length; i++) {
			players[i]=new Player();
		}
		for (int j = 0; j < deck.length; j += n) {
			for (int i = 0; i < n; i++) {
				if (i + j >= deck.length)
					return;
				players[i].addCard(deck[i + j]);
			}
		}
		for (Player p:players) {
			p.printDeck();
		}
	}

	public void shufleDeck(Card[] d) {
		for (int i = 0; i < d.length; i++) {
			int rC = r.nextInt(d.length);
			if (d[rC] != null && rC != i) {
				Card temp = d[i];
				d[i] = d[rC];
				d[rC] = temp;
			} else
				i--;
		}
	}

	public void gameWar(int numP) {
		shufleDeck(deck);
		createPlayers(numP);
		while (game(players)) {
			chalange(chalangePlayer());
			nextTurnPlayer();
		}
	}

	private int chalangePlayer() {
		int chalange;
		if (turnPlayer == 0 ) {
			if(players.length==2)chalange=1;
			else{
				System.out.print("Select player to chalange: ");
				chalange = s.nextInt() - 1;
			}
		} else {
			do {
				chalange = r.nextInt(players.length);
			} while (chalange == turnPlayer);
		}
		System.out.printf("Player %d chalanges Player %d!\n",turnPlayer,chalange);
		return chalange;
		
	}

	private void chalange(int chalange) {
		int index=0;
		Card tP=players[turnPlayer].takeCard();
		System.out.printf("Player %d presents %s\n",turnPlayer,tP);
		Card cP=players[chalange].takeCard();
		System.out.printf("Player %d presents %s\n",chalange,cP);
		holder.addCard(tP);
		holder.addCard(cP);
		int result=tP.compareByPow(cP);
		boolean turnPlayerWin=true;
		if(result==1) turnPlayerWin=true;
		else if(result==-1)turnPlayerWin=false;
		else {
			do {
				System.out.println("WAR!!!!");
				index+=3;
				holder.addCard(players[turnPlayer].takeCard());
				holder.addCard(players[turnPlayer].takeCard());
				tP=players[turnPlayer].takeCard();
				holder.addCard(tP);
				System.out.printf("Player %d presents %s\n",turnPlayer,tP);
				holder.addCard(players[chalange].takeCard());
				holder.addCard(players[chalange].takeCard());
				cP=players[chalange].takeCard();
				holder.addCard(cP);
				System.out.printf("Player %d presents %s\n",chalange,cP);
				if(tP==null)turnPlayerWin=false;
				if(cP==null)turnPlayerWin=true;
				result=tP.compareByPow(cP);
				if(result==1)turnPlayerWin=true;
				else if(result==-1)turnPlayerWin=false;
			}while(result==0);
		}
		System.out.printf("Player %d wins %d cards.\n", (turnPlayerWin)?turnPlayer:chalange,(index+1)*2);
		playerWinCards(turnPlayer,chalange,turnPlayerWin);
		for(Player c:players) {
			c.printDeck();
		}
	}

	private void playerWinCards(int turnP,int chalange, boolean b) {
		Card[] cardsTaken=holder.getDeck();
		if(b)players[turnP].addCard(cardsTaken);
		else players[chalange].addCard(cardsTaken);
	}



	private void nextTurnPlayer() {
		turnPlayer++;
		if (turnPlayer >= players.length) {
			turnPlayer = 0;
		}
		if(!players[turnPlayer].hasCards() && game(players))nextTurnPlayer();
	}

	private boolean game(Player[] p) {
		int i = 0;
		for (Player p1 : p) {
			if (p1.hasCards())
				i++;
		}
		return i >= 2;
	}

	public static void main(String[] args) {
		CardGames cg = new CardGames();
		cg.gameWar(2);
	}
}
