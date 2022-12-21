package game.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private GameObject[] objects = new GameObject[5];
	boolean pause = false;
	boolean run = false;

	public GamePanel() {
		setSize(500 - 18, 400);
		setBackground(Color.BLACK);
		objects[0] = new Padle(0);
		objects[1] = new Padle(1);
		objects[2] = new Ball();
		objects[3]=new Clock();
		objects[4]=new Score();
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				GameObject go;
				int move = 2;
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					go = objects[1];
					go.setMoveY(-move);
					break;
				case KeyEvent.VK_DOWN:
					go = objects[1];
					go.setMoveY(move);
					break;
				case KeyEvent.VK_W:
					go = objects[0];
					go.setMoveY(-move);
					break;
				case KeyEvent.VK_S:
					go = objects[0];
					go.setMoveY(move);
					break;
				case KeyEvent.VK_SPACE:
					if (run)
						pause = !pause;
					if (!run) {
						run = true;
						return;
					}

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				GameObject go;
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					go = objects[1];
					go.setMoveY(0);
					break;
				case KeyEvent.VK_DOWN:
					go = objects[1];
					go.setMoveY(0);
					break;
				case KeyEvent.VK_W:
					go = objects[0];
					go.setMoveY(0);
					break;
				case KeyEvent.VK_S:
					go = objects[0];
					go.setMoveY(0);
					break;
				}
			}
		});

		Timer t = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				for (int i = 0; i < objects.length; i++) {
					if(i==3)continue;
					if (objects[i] != null)
						objects[i].move();
					if(i==2) {
						Ball b=(Ball) objects[2];
						Score s=(Score) objects[4];
						s.p2+=b.checkColision(objects[0]);
						s.p1+=b.checkColision(objects[1]);
					}
				}
				repaint();
			}
		};
		t.scheduleAtFixedRate(task, 0, 1000 / 60);
		t=new Timer();
		task=new TimerTask() {
			@Override
			public void run() {
				objects[3].move();
			}
		};
		t.scheduleAtFixedRate(task, 0, 1000);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (GameObject go : objects) {
			if (go != null)
				go.paint(g);
		}
	}
}
