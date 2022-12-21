package game.dotsandboxes;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class Panel extends JPanel {

	public Panel(final int width, final int height, final int gridLayout) {
		setBackground(Color.white);
		setLayout(null);
		setSize(width - 18, height - 35);

		createGrid(gridLayout);
	}

	private void createGrid(final int gridLayout) {
		GridObject[][] grid = new GridObject[gridLayout][gridLayout];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[i][j]=new GridObject(j*40,i*40,40,40);
				final int row,col;
				row=i;
				col=j;
				if (i % 2 != 0 && j%2==0) {
					grid[i][j].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(row-1>=0) {
								if(grid[row-1][col+1].isClicked() && grid[row+1][col-1].isClicked()) {
									
								}
							}
						}
					});
				}
				
			}
		}
	}
}
