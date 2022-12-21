package game.pong;

import java.awt.Color;
import java.awt.Graphics;

public class Padle extends GameObject{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Padle(int id) {
		width=20;
		height=100;
		switch(id) {
		case 0:
			x=0;
			y=(400-100)/2;
			c=Color.green;
			break;
		case 1:
			x=(500-18-width);
			y=(400-100)/2;
			c=Color.red;
			break;
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void move() {
		int newY=y+moveY;
		if(newY>=0 && newY+100<=400)
			y=newY;
	}

}
