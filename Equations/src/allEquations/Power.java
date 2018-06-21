package allEquations;

import javax.swing.JOptionPane;

public class Power {

	// Initializes variables.
	private int counter = 0;
	private boolean v = false, i = false, r = false, p = false;
	private double power = -1, voltage = -1, current = -1, resistance = -1;
	private String power_ = "", voltage_ = "", current_ = "", resistance_ = "";
	private boolean error = true, breakOut = false;
	// Calls the Title class
	Title title = new Title();
	
	public Power() {

		// Keeps executing until the user either clicks cancel, x, or the user has inputted a value into two different inputs.
		while(counter != 2 && breakOut == false) {
			
			// Power
			while(error == true && counter != 2 && p == false && breakOut == false) {
				try {
					power_ = JOptionPane.showInputDialog(null, "Please enter your power. If blank, the program will try to solve it for you.", title.name + title.version, JOptionPane.PLAIN_MESSAGE);
					
					if(power_ == null) {
						breakOut = true;
						break;
					}
					
					else if(!power_.equals("")) {
						power = Double.parseDouble(power_);
						counter++;
						p = true;
					}
					error = false;
					
				}
				catch(NumberFormatException nfe) {
					System.out.println("Not a valid number");
					System.out.println(nfe);
				}
				
			}
			
			error = true;
			// Voltage
			while(error == true && counter != 2 && v == false && breakOut == false) {
				try {
					voltage_ = JOptionPane.showInputDialog(null, "Please enter your voltage. If blank, the program will try to solve it for you.", title.name + title.version, JOptionPane.PLAIN_MESSAGE);
					if(voltage_ == null) {
						breakOut = true;
						break;
					}
					
					else if(!voltage_.equals("")) {
						voltage = Double.parseDouble(voltage_);
						counter++;
						v = true;
					}
					error = false;
				}
				catch(NumberFormatException nfe) {
					System.out.println("Not a valid number");
					System.out.println(nfe);
				}
				
			}
			
			error = true;
			// Current
			while(error == true && counter != 2 && i == false && breakOut == false) {
				try {
					current_ = JOptionPane.showInputDialog(null, "Please enter your current. If blank, the program will try to solve it for you.", title.name + title.version, JOptionPane.PLAIN_MESSAGE);
					if(current_ == null) {
						breakOut = true;
						break;
					}
					
					else if(!current_.equals("")) {
						current = Double.parseDouble(current_);
						counter++;
						i = true;
					}
					error = false;
				}
				catch(NumberFormatException nfe) {
					System.out.println("Not a valid number");
					System.out.println(nfe);
				}
				
			}
			
			error = true;
			// Resistance
			while(error == true && counter != 2 && r == false && breakOut == false) {
				try {
					resistance_ = JOptionPane.showInputDialog(null, "Please enter your resistance. If blank, the program will try to solve it for you.", title.name + title.version, JOptionPane.PLAIN_MESSAGE);
					if(resistance_ == null) {
						breakOut = true;
						break;
					}
					
					else if(!resistance_.equals("")) {
						resistance = Double.parseDouble(resistance_);
						counter++;
						r = true;
					}
					error = false;
				}
				catch(NumberFormatException nfe) {
					System.out.println("Not a valid number");
					System.out.println(nfe);
				}
				
			}
			error = true;
			
		}
		
		// Outputs
		// I and R
		if(power == -1 && voltage == -1 && current != -1 && resistance != -1) {
			String output = title.setTitle();
			output += "Finding Power and Voltage\n";
			output += "----------------------------------------------------\n";
			output += "Known values:\n";
			output += "Current (I): " + current + "A\n";
			output += "Resistance (R): " + resistance + "Ω\n";
			output += "----------------------------------------------------\n";
			output += "1. Finding voltage\n";
			output += "   V = I*R\n";
			output += "   V = " + current + "*" + resistance + "\n";
			output += "   V = " + current * resistance + "V\n";
			voltage = current * resistance;
			output += "2. Finding power\n";
			output += "   P = V * I\n";
			output += "   P = " + voltage + " * " + current + "\n";
			output += "   P = " + voltage * current + "W\n";
			output += "OR\n";
			output += "   P = I^2 * R\n";
			output += "   P = " + current + "^2 * " + resistance + "\n";
			output += "   P = " + Math.pow(current, 2) * resistance + "W\n";
			power = voltage * current;
			JOptionPane.showMessageDialog(null, output, title.name + title.version, JOptionPane.PLAIN_MESSAGE);
		}
		
		// P and R
		else if(power != -1 && voltage == -1 && current == -1 && resistance != -1) {
			String output = title.setTitle();
			output += "Finding Voltage and Current\n";
			output += "----------------------------------------------------\n";
			output += "Known values:\n";
			output += "Power (P): " + power + "W\n";
			output += "Resistance (R): " + resistance + "Ω\n";
			output += "----------------------------------------------------\n";
			output += "1. Finding voltage\n";
			output += "   V = sqrt(P * R)\n";
			output += "   V = " + "sqrt(" + power + " * " + resistance + ")\n";
			output += "   V = " + Math.sqrt(power * resistance) + "V\n";
			voltage = Math.sqrt(power * resistance);
			output += "2. Finding current\n";
			output += "   I = P / V\n";
			output += "   I = " + power + "/" + voltage + "\n";
			output += "   I = " + power / voltage + "A\n";
			current = power / voltage;
			output += "OR\n";
			output += "   I = V / R\n";
			output += "   I = " + voltage + "/" + resistance + "\n";
			output += "   I = " + voltage / resistance + "A\n";
			JOptionPane.showMessageDialog(null, output, title.name + title.version, JOptionPane.PLAIN_MESSAGE);
		}
		
		// V and R
		else if(power == -1 && voltage != -1 && current == -1 && resistance != -1) {
			String output = title.setTitle();
			output += "Finding Power and Current\n";
			output += "----------------------------------------------------\n";
			output += "Known values:\n";
			output += "Voltage(V): " + voltage + "V\n";
			output += "Resistance (R): " + resistance + "Ω\n";
			output += "----------------------------------------------------\n";
			output += "1. Finding current\n";
			output += "   I = V / R\n";
			output += "   I = " + voltage + "/" + resistance + "\n";
			output += "   I = " + voltage / resistance + "A\n";
			current = voltage / resistance;
			output += "2. Finding power\n";
			output += "   P = V * I\n";
			output += "   P = " + voltage + "*" + current + "\n";
			output += "   P = " + voltage * current + "W\n";
			output += "OR\n";
			output += "   P = V^2 / R";
			output += "   P = " + voltage + "^2 / " + resistance + "\n";
			output += "   P = " + Math.pow(voltage, 2) / resistance + "W\n";
			power = voltage * current;
			JOptionPane.showMessageDialog(null, output, title.name + title.version, JOptionPane.PLAIN_MESSAGE);
		}
		
		// V and I
		else if (power == -1 && voltage != -1 && current != -1 && resistance == -1) {
			String output = title.setTitle();
			output += "Finding Power and Resistance\n";
			output += "----------------------------------------------------\n";
			output += "Known values:\n";
			output += "Voltage(V): " + voltage + "V\n";
			output += "Current (I): " + current + "A\n";
			output += "----------------------------------------------------\n";
			output += "1. Find Resistance\n";
			output += "   R = V / I\n";
			output += "   R = " + voltage + " / " + current + "\n";
			output += "   R = " + voltage / current + "Ω\n";
			resistance = voltage / current;
			output += "2. Find Power\n";
			output += "   P = V * I\n";
			output += "   P = " + voltage + " * " + current + "\n";
			output += "   P = " + voltage * current + "W\n";
			power = voltage * current;
			output += "OR\n";
			output += "   P = V^2 / R\n";
			output += "   P = " + voltage + "^2 / " + resistance + "\n";
			output += "   P = " + Math.pow(voltage, 2) / resistance + "W\n";
			JOptionPane.showMessageDialog(null, output, title.name + title.version, JOptionPane.PLAIN_MESSAGE);
		}
		
		// P and I
		else if (power != -1 && voltage == -1 && current != -1 && resistance == -1) {
			String output = title.setTitle();
			output += "Finding Voltage and Resistance\n";
			output += "----------------------------------------------------\n";
			output += "Known values:\n";
			output += "Power(P): " + power + "W\n";
			output += "Current (I): " + current + "A\n";
			output += "----------------------------------------------------\n";
			output += "1. Find Voltage\n";
			output += "   V = P / I";
			output += "   V = " + power + " / " + current + "\n";
			output += "   V = " + power / current + "V\n";
			voltage = power / current;
			output += "2. Find Resistance\n";
			output += "   R = V / I\n";
			output += "   R = " + voltage + " / " + current + "\n";
			output += "   R = " + voltage / current + "Ω\n";
			resistance = voltage / current;
			output += "OR\n";
			output += "   R = P / I^2\n";
			output += "   R = " + power + " / " + current + "^2\n";
			output += "   R = " + power / Math.pow(current, 2) + "Ω\n";
			JOptionPane.showMessageDialog(null, output, title.name + title.version, JOptionPane.PLAIN_MESSAGE);
			
		}
		
		// P and V
		else if (power != -1 && voltage != -1 && current == -1 && resistance == -1) {
			String output = title.setTitle();
			output += "Finding Voltage and Resistance\n";
			output += "----------------------------------------------------\n";
			output += "Known values:\n";
			output += "Power(P): " + power + "W\n";
			output += "Voltage (V): " + voltage + "V\n";
			output += "----------------------------------------------------\n";
			output += "1. Find Current\n";
			output += "   I = P / V\n";
			output += "   I = " + power + " / " + voltage + "\n";
			output += "   I = " + power / voltage + "A\n";
			current = power / voltage;
			output += "2. Find Resistance\n";
			output += "   R = V / I\n";
			output += "   R = " + voltage + " / " + current + "\n";
			output += "   R = " + voltage / current + "Ω\n";
			resistance = voltage / current;
			output += "OR\n";
			output += "   R = V^2 / P\n";
			output += "   R = " + voltage + "^2 / " + power + "\n";
			output += "   R = " + Math.pow(voltage, 2) / power + "Ω\n";
			JOptionPane.showMessageDialog(null, output, title.name + title.version, JOptionPane.PLAIN_MESSAGE);
		}
	}
	

}
