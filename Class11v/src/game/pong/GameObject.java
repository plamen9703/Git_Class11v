package game.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject extends Rectangle{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Color c;
	protected int moveY;
	protected int moveX;
	public void setMoveY(int moveY) {
		this.moveY = moveY;
	}
	
	public void setMoveX(int moveX) {
		this.moveX = moveX;
	}

	
	public int getMoveY() {
		return moveY;
	}

	public int getMoveX() {
		return moveX;
	}

	public abstract void paint(Graphics g);
	public abstract void move();
	
}
