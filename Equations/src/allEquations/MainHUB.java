package allEquations;


import javax.swing.JOptionPane;

public class MainHUB {

	public static void main(String[] args) {
		
		// *** Initialized Variables ***
		String user = "";
		
		// Title
		Title title = new Title();
		
		// FIRST INPUT
		String[] options = {"Power", "Velocity", "Linear Equation", "Parabola"};
		
		// Infinite loop: Will keep executing until the user pressees the cancel button.
		while(user != null) {
			// FIRST INPUT
			user = (String) JOptionPane.showInputDialog(null, "Which equation would you like to use?", title.name, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			
			// Option 0 - Power
			if(user == options[0]) {
				Power power = new Power();
			}
		
			// Option 1 - Velocity
			else if(user == options[1]) {
				System.out.println("WIP");
			}
			
			// Option 2 - Linear Equation
			else if(user == options[2]) {
				System.out.println("WIP");
			}
			
			// Option 3 - Parabola
			else if(user == options[3]) {
				System.out.println("WIP");
			}
		}
	}

}
