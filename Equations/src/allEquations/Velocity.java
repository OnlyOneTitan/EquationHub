package allEquations;

import javax.swing.JOptionPane;

public class Velocity {

	// Initializes Variables
	Title title = new Title();
	int counter = 0;
	boolean error = true, breakOut = false;
	double velocity = 0, distance = 0, time = 0;
	boolean v = false, d = false, t = false;
	String output = title.setTitle();
	
	public Velocity() {
		
		// Keeps executing until the user either clicks cancel, x, or the user has inputted a value into two different inputs.
		while(counter != 2 && !breakOut) {
			
			// Velocity
			while(error && !v && counter != 2 && !breakOut) {
				// user input: allows the user to input a number. The input dialog also has a title
				String v_ = JOptionPane.showInputDialog(null, "Please enter your velocity (m/s)", title.name + title.version, JOptionPane.PLAIN_MESSAGE);
				if(v_ == null) {
					breakOut = true;
					break;
				}
				if(v_.equals("")) {
					break;
				}
				// Converts string to double, changes values so this while loop does not execute again
				try {
					velocity = Double.parseDouble(v_);
					error = false;
					counter++;
					v = true;
				}
				// Catches any errors found by entering an invalid number
				catch(NumberFormatException nfe) {
					System.out.println(nfe);
				}
				
			}
			if(breakOut) {
				break;
			}
			error = true;
			
			// Distance
			while(error && !d && counter != 2 && !breakOut) {
	
				String d_ = JOptionPane.showInputDialog(null, "Please enter your distance (meters)", title.name + title.version, JOptionPane.PLAIN_MESSAGE);
				if(d_ == null) {
					breakOut = true;
					break;
				}
				if(d_.equals("")) {
					break;
				}
				// Converts string to double, changes values so this while loop does not execute again
				try {
					distance = Double.parseDouble(d_);
					
					error = false;
					counter++;
					d = true;
				}
				// Catches any errors found by entering an invalid number
				catch(NumberFormatException nfe) {
					System.out.println(nfe);
				}
				
			}
			if(breakOut) {
				break;
			}
			
			error = true;
			
			// Time
			while(error && !t && counter != 2 && !breakOut) {
				
				String t_ = JOptionPane.showInputDialog(null, "Please enter your time (seconds)", title.name + title.version, JOptionPane.PLAIN_MESSAGE);
				if(t_ == null) {
					breakOut = true;
					break;
				}
				if(t_.equals("")) {
					break;
				}
				// Converts string to double, changes values so this while loop does not execute again
				try {
					time = Double.parseDouble(t_);
					
					error = false;
					counter++;
					t = true;
				}
				// Catches any errors found by entering an invalid number
				catch(NumberFormatException nfe) {
					System.out.println(nfe);
				}
				
			}
			if(breakOut) {
				break;
			}
			
			
		}
		
		// Outputs
		if(velocity == 0) {
			
			output += "Finding Velocity\n";
			output += "----------------------------------------\n";
			output += "Known Values:\n";
			output += "Distance (d) = " + distance + "\n";
			output += "Time (t) = " + time + "\n";
			output += "----------------------------------------\n";
			output += "v = d / t\n";
			output += "v = " + distance + " / " + time + "\n";
			velocity = distance / time;
			output += "v = " + velocity + "m/s\n";
			
			
		}
		
		else if(distance == 0) {
			
			output += "Finding Distance\n";
			output += "----------------------------------------\n";
			output += "Known Values:\n";
			output += "Velocity (v) = " + velocity + "\n";
			output += "Time (t) = " + time + "\n";
			output += "----------------------------------------\n";
			output += "d = v * t\n";
			output += "d = " + velocity + " * " + time + "\n";
			distance = velocity * time;
			output += "d = " + distance + "m\n";
			
			
		}
		
		else if(time == 0) {
			
			output += "Finding Time\n";
			output += "----------------------------------------\n";
			output += "Known Values:\n";
			output += "Distance (d) = " + distance + "\n";
			output += "Velocity (v) = " + velocity + "\n";
			output += "----------------------------------------\n";
			output += "t = d / v\n";
			output += "t = " + distance + " / " + velocity + "\n";
			time = distance / velocity;
			output += "t = " + time + "s\n";
			
			
		}
		if(!breakOut) {
			JOptionPane.showMessageDialog(null, output, title.name + title.version, JOptionPane.PLAIN_MESSAGE);			
		}
	}
}
