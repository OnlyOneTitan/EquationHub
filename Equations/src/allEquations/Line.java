package allEquations;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Line extends JPanel {
	
	Title title = new Title();
	private double mx = -1, my = -1, b = -1;
	public boolean breakOut = false;
	
	public Line() {
		boolean error = true;
		
		// SLOPE (Numerator)
		while(error && !breakOut) {
			try {
				String m_ = JOptionPane.showInputDialog(null, "Please enter your slope (Numerator)", title.name + title.version, JOptionPane.PLAIN_MESSAGE);
				if(m_ == null) {
					breakOut = true;
					break;
				}
				else {
					my = Double.parseDouble(m_);
					error = false;					
				}
			}
			catch(NumberFormatException nfe) {
				System.out.println("Not a valid number");
			}
		}
		error = true;
		// SLOPE (Denominator)
		while(error && !breakOut) {
			try {
				String m_ = JOptionPane.showInputDialog(null, "Please enter your slope (Denominator)", title.name + title.version, JOptionPane.PLAIN_MESSAGE);
				if(m_ == null) {
					breakOut = true;
					break;
				}
				else {
					mx = Double.parseDouble(m_);
					error = false;					
				}
			}
			catch(NumberFormatException nfe) {
				System.out.println("Not a valid number");
			}
		}
		error = true;
		// Y-INTERCEPT
		while(error && !breakOut) {
			try {
				String b_ = JOptionPane.showInputDialog(null, "Please enter your y-intercept", title.name + title.version, JOptionPane.PLAIN_MESSAGE);
				if(b_ == null) {
					breakOut = true;
					break;
				}
				else {
					b = Double.parseDouble(b_);
					error = false;					
				}
			}
			catch(NumberFormatException nfe) {
				System.out.println("Not a valid number");
			}
		}
		
		
		

		
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
			// Displays information of the graph
			g.setColor(new Color(233, 145, 43));
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Slope: " + my + "/" + mx, 10, 20);
			g.drawString("Y - Intercept: " + b, 10, 40);
			
			// Draws the intercepts
			g.setColor(Color.YELLOW);
			g.fillRect(0 , y , 1920, 1);
			g.fillRect(x, 0, 1, 1080);
			
			
			// Drawing the numbers
			for(int i = 0; i <= 50; i++) {
				String coordinate = "" + i;
				
				g.setColor(new Color(255, 255, 255));
				g.setFont(new Font("Arial", Font.PLAIN, 11));
				g.drawString(coordinate, x + i * 20 - 3, y + 10);
				if(i != 0) {
					g.drawString("-" + coordinate, x - i * 20 - 5, y + 10);				
					g.drawString(coordinate, x - 15, y - i * 20 + 4);
					g.drawString("-" + coordinate, x - 18, y + i * 20 + 4);
				}
			}
			
			for(int i = 0; i < 100; i++) {
				g.setColor(new Color(233, 43, 193));
				// i = for loop iteration
				// x = half of 1920, mx = slope numerator
				// y = half of 1080, my = slope denominator
				// 20 or -20 = spacing
				g.fillRect((int) (x + i * 20 * mx), (int) ((y + (b * -20)) - (i * (20 * my))), 3, 3);
				g.fillRect((int) (x - i * 20 * mx), (int) ((y + (b * -20)) - (-i * (20 * my))), 3, 3);
				g.drawLine((int) (x + i * 20 * mx), (int) ((y + (b * -20)) - (i * (20 * my))), (int) (x + (i - 1) * 20 * mx), (int) ((y + (b * -20)) - ((i - 1) * (20 * my))));
				g.drawLine((int) (x - i * 20 * mx), (int) ((y + (b * -20)) - (-i * (20 * my))), (int) (x + (i - 1) * 20 * mx), (int) ((y + (b * -20)) - ((i - 1) * (20 * my))));
			}
			
		}
				
	}
}
