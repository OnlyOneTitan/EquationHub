package allEquations;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

// Grabs all of the functions from the JPanel class.
public class Quadratic extends JPanel{

	double x_ = -1;
	private boolean breakOut = false;
	public Quadratic() {
		x_ = Double.parseDouble(JOptionPane.showInputDialog("Enter your a value"));
	}

	public void paintComponent(Graphics g) {
		if(!breakOut) {
			// The middle of the display area
			int x = 960;
			int y = 540;
			
			// Calls the super class of paintComponent
			super.paintComponent(g);
			// Sets the background of the display to gray
			this.setBackground(new Color(120, 120, 120));
			
			
			// Draws the grid
			for(int i = 0; i < 80; i++) {
				
				g.setColor(Color.BLACK);
				g.fillRect(0 , y - i * 20, 1920, 1);
				g.fillRect(0 , y + i * 20, 1920, 1);
				g.fillRect(x - i * 20, 0, 1, 1080);
				g.fillRect(x + i * 20, 0, 1, 1080);
				
			}
			
			
			// Draws the intercepts
			g.setColor(Color.YELLOW);
			g.fillRect(0 , y , 1920, 1);
			g.fillRect(x, 0, 1, 1080);
			
			
			// Drawing the numbers
			for(int i = 0; i <= 50; i++) {
				String coordinate = "" + i;
				
				g.setColor(new Color(255, 255, 255));
				g.drawString(coordinate, x + i * 20 - 3, y + 10);
				if(i != 0) {
					g.drawString("-" + coordinate, x - i * 20 - 5, y + 10);				
					g.drawString(coordinate, x - 15, y - i * 20 + 4);
					g.drawString("-" + coordinate, x - 18, y + i * 20 + 4);
				}
			}
			
			g.setColor(new Color(233, 43, 193));
			// Draws the parabola points
			for(int i = 0; i < 100; i++) {
				g.fillRect(x + i * 20, (int) (y - x_ * 20 * Math.pow(i, 2)), 3, 3);
				g.fillRect(x - i * 20, (int) (y - x_ * 20 * Math.pow(i, 2)), 3, 3);
			}
			
			// Draws the lines
			for(int i = 1; i < 100; i++) {
				g.drawLine(x + (i - 1) * 20, (int) (y - x_ * 20 * Math.pow((i - 1), 2)), x + i * 20, (int) (y - x_ * 20 * Math.pow(i, 2)));
				g.drawLine(x - (i - 1) * 20, (int) (y - x_ * 20 * Math.pow((i - 1), 2)), x - i * 20, (int) (y - x_ * 20 * Math.pow(i, 2)));
			}
			
			
			
		}
				
	}
}
