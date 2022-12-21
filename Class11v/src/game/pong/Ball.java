package game.pong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Ball() {
		x=(500-18-20)/2;
		y=(400-20)/2;
		width=20;
		height=20;
		c=Color.ORANGE;
		moveX=2;
		moveY=-2;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(c);
		g.fillOval(x, y, width, height);
	}

	@Override
	public void move() {
		/*int newX=x+moveX;
		if(newX>=0 && newX+width<=500-18) {
			x=newX;	
		}else {
			moveX=-moveX;
			x=x+moveX;
		}*/
		x+=moveX;
		int newY=y+moveY;
		if(newY>=0 && newY+height<=400) {
			y=newY;	
		}else {
			moveY=-moveY;
			y=y+moveY;
		}
	}
	
	
	public int checkColision(GameObject go) {
		if(intersects(go)) {
			moveX=-moveX;
			System.out.println(moveX);
			x+=moveX;
			return 0;
		}else {
			if(x<=0) {
				System.out.println("h1");
				x=(500-18-width)/2;
				moveX=-moveX;
				return -1;
			}else if(x+width>=500-18){
				System.out.println("h2");
				x=(500-18-width)/2;
				moveX=-moveX;
				return 1;
			}
		}
		return 0;
	}

}
