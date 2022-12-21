package game.pong;

import java.awt.Color;
import java.awt.Graphics;

public class Clock extends GameObject {
	public int seconds;
	public Clock() {
		c=Color.white;
		y=400-30;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(c);
		int hours=seconds/3600;
		int min=seconds/60;
		g.drawString(String.format("%d:%d:%d", hours,min,seconds%60), x, y);
	}

	
	
	@Override
	public void move() {
		seconds++;
	}

}
