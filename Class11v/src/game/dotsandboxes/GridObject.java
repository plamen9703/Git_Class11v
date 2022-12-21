package game.dotsandboxes;

import java.awt.Color;

import javax.swing.JLabel;

public class GridObject extends JLabel {
	private boolean clicked;
	public GridObject(final int x, final int y,final int w, final int h) {
		setBounds(x,y,w,h);
		setOpaque(true);
	}
	public boolean isClicked() {
		return clicked;
	}
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

//	@Override
//	public String toString() {
//		String []s=this.getClass().getName().split(".");
//		return s[s.length-1];
//	}
	
	
}
