package allEquations;


import javax.swing.JOptionPane;

public class MainHUB {

	public static void main(String[] args) {
		
		// *** Initialized Variables ***
		String user = "";
		// Version is measured by year.release.iteration.developmentday
		String version = "dev18.1.1.2";
		String spacers = "";
		
		// Adds an equals for the title in the console, mainly to make the title look nice as versions change.
		for(int i = 0; i < version.length(); i++) {
			spacers += "=";
		}
		
		// Title
		System.out.println("   --==================" + spacers + "--   ");
		System.out.println("---=== EquationHub V-" + version + " ===---");
		System.out.println("   --==================" + spacers + "--   ");
		System.out.println();
		System.out.println();
		System.out.println();
		
		// FIRST INPUT
		String[] options = {"Power", "Velocity", "Linear Equation", "Parabola"};
		// SECOND INPUT
		String[] powerOptions = {"P = V * I", "I = P / V", "I = V / R", "V = P / I", "V = I * R", "R = V / I"};
		
		// Infinite loop: Will keep executing until the user pressees the cancel button.
		while(user != null) {
			// FIRST INPUT
			user = (String) JOptionPane.showInputDialog(null, "Which equation would you like to use?", "Equation Program", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			
			// Option 0 - Power
			if(user == options[0]) {
				// SECOND INPUT
				String powerOption = (String) JOptionPane.showInputDialog(null, "What are you looking for in the power equation?", "Equation Program", JOptionPane.PLAIN_MESSAGE, null, powerOptions, powerOptions[0]);
				
				// Option 0/0 - Power
				if(powerOption == powerOptions[0]) {
					Power power = new Power();
					double voltage = Double.parseDouble(JOptionPane.showInputDialog("What is your voltage?"));
					double current = Double.parseDouble(JOptionPane.showInputDialog("What is your current?"));
					power.PowerP(voltage, current);
				}
				
				// Option 0/1 - Current
				else if(powerOption == powerOptions[1]) {
					Power power = new Power();
					double powerWatts = Double.parseDouble(JOptionPane.showInputDialog("What is your power?"));
					double voltage = Double.parseDouble(JOptionPane.showInputDialog("What is your current?"));
					power.PowerI1(powerWatts, voltage);
				}
				
				// Option 0/2 - Current
				else if (powerOption == powerOptions[2]) {
					Power power = new Power();
					double voltage = Double.parseDouble(JOptionPane.showInputDialog("What is your voltage?"));
					double resistance = Double.parseDouble(JOptionPane.showInputDialog("What is your resistance?"));
					power.PowerI2(voltage, resistance);
				}

				// Option 0/3 - Voltage
				else if(powerOption == powerOptions[3]) {
					Power power = new Power();
					double powerWatts = Double.parseDouble(JOptionPane.showInputDialog("What is your power?"));
					double current = Double.parseDouble(JOptionPane.showInputDialog("What is your current?"));
					power.PowerV1(powerWatts, current);
				}
				// Option 0/4 - Voltage
				else if(powerOption == powerOptions[4]) {
					Power power = new Power();
					double resistance = Double.parseDouble(JOptionPane.showInputDialog("What is your resistance?"));
					double current = Double.parseDouble(JOptionPane.showInputDialog("What is your current?"));
					power.PowerV2(resistance, current);
				}
				// Option 0/5 - Resistance
				else if(powerOption == powerOptions[5]) {
					Power power = new Power();
					double voltage = Double.parseDouble(JOptionPane.showInputDialog("What is your voltage?"));
					double current = Double.parseDouble(JOptionPane.showInputDialog("What is your current?"));
					power.PowerR1(voltage, current);
				}
				
				
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
