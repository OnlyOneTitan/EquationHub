package allEquations;

import javax.swing.JFrame;

import javax.swing.JOptionPane;

/* Matt McBurnie
 * June 20, 2018
 * Purpose: This project is meant to put together what was learned throughout the course.
 */
public class MainHUB {

	public static void main(String[] args) {

		// *** Initialized Variables ***
		String user = "";

		// Title
		Title title = new Title();
		// Creates a new window
		JFrame frame = new JFrame(title.name + title.version);

		// FIRST INPUT
		String[] options = { "Power", "Velocity", "Linear Equation", "Parabola", "Data"/* , "Area" */ };

		// Infinite loop: Will keep executing until the user pressees the cancel button.
		while (user != null) {
			// FIRST INPUT
			user = (String) JOptionPane.showInputDialog(null, "Which equation would you like to use?",title.name + title.version, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

			// Option 0 - Power
			if (user == options[0]) {
				// Calls the Power class
				Power power = new Power();
			}

			// Option 1 - Velocity
			else if (user == options[1]) {
				// Calls the Velocity class
				Velocity velocity = new Velocity();
			}

			// Option 2 - Linear Equation
			else if (user == options[2]) {
				// Calls the Line class
				Line line = new Line();

				// When it is on EXIT_ON_CLOSE, then the window will exit out of the program instead of leaving it running in the background.
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// Does not allow the project to be resizable.
				frame.setResizable(false);
				// Sets the size of the window to be 1080p (1920 x 1080 pixels)
				frame.setSize(1920, 1080);
				// Adds the properties from the Line class to the window (Ex. The JPanel will display on the window instead of it just being a blank window).
				frame.add(line);
				// Allows the window to actually be visible.
				frame.setVisible(true);

			}

			// Option 3 - Quadratic
			else if (user == options[3]) {
				Quadratic quadratic = new Quadratic();

				// When it is on EXIT_ON_CLOSE, then the window will exit out of the program instead of leaving it running in the background.
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// Does not allow the project to be resizable.
				frame.setResizable(false);
				// Sets the size of the window to be 1080p (1920 x 1080 pixels)
				frame.setSize(1920, 1080);
				// Adds the properties from the Quadratic class to the window (Ex. The JPanel will display on the window instead of it just being a blank window).
				frame.add(quadratic);
				// Allows the window to actually be visible.
				frame.setVisible(true);
			}

			// Option 4 - Data (Mean, Median, Mode, Standard Deviation, Range, Quartiles, Interquartile Range, Outliers)
			else if (user == options[4]) {
				// Calls the Data class.
				Data data = new Data();
			}

			
			/*
			 * else if(user == options[5]) { 
			 * Area area = new Area(); 
			 * }
			 */
		}
		// Closes the entire program.
		System.exit(0);
	}

}
