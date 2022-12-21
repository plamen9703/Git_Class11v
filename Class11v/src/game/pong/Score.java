package game.pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score extends GameObject{
	
	Font f=new Font("Times new Roman", Font.PLAIN,20);
	int p1;
	int p2;
	public Score() {
		c=Color.pink;
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.setFont(f);
		g.setColor(c);
		g.drawString(String.format("%d - %d", p1,p2), 300, 300);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
	
}
