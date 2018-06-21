package allEquations;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Data {

	public ArrayList<Double> nums = new ArrayList<Double>();
	private double x_ = 0;
	private double standardDeviationS = 0;
	private double standardDeviationP = 0;
	private String output = "";
		
	public Data() {
		Title title = new Title();
		boolean error = true;
		boolean breakOut = false;
		
		// Loop: breaks if the user enters in valid numbers into the input
		while(error) {
			String user = JOptionPane.showInputDialog(null, "Please enter your numbers (Separated by spaces)", title.name, JOptionPane.PLAIN_MESSAGE);
			// Breaks if the user inputs nothing.
			if(user == null) {
				breakOut = true;
				error = false;
				break;
			}
			// 
			try {
				String[] splitter = user.split(" ");
				for(int i = 0; i < splitter.length; i++) {
					nums.add(Double.parseDouble(splitter[i]));
				}
				error = false;
				
			}
			catch(NumberFormatException nfe) {
				System.out.println(nfe);
			}
			
		}
		
		if(nums.size() == 0) {
			breakOut = true;
		}
		
		// Bubble sort
		for(int i = 1; i < nums.size(); i++) {
			for(int o = 0; o < nums.size() - 1; o++) {
				
				if(nums.get(o) > nums.get(o + 1)) {
					sorting(nums, o, o + 1);
				}
			}
		}
		
		// If the user did not click cancel or x, the program will call the methods.
		if(!breakOut) {
			Mean();
			Median();
			Range();
			StandardDeviation();
			Quartiles();
			JOptionPane.showMessageDialog(null, output, title.name + title.version, JOptionPane.PLAIN_MESSAGE);			
		}
	}
	
	// Sorting
	public void sorting(ArrayList<Double> numbers, int x, int y) {
		double temp = numbers.get(x);
		numbers.set(x, numbers.get(y));
		numbers.set(y, temp);
	}
	public void sortingAlt(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
	
	
	// Calculates the Mean
	public void Mean() {
		double average = 0;
		
		// Adds up the numbers
		for(int i = 0; i < nums.size(); i++) {
			average += nums.get(i);
		}
		
		// Divides the total by the size of the array.
		x_ = average / nums.size();
		output += "Mean = " + x_ + "\n";
	}
	
	// Calculates the Median
	public void Median() {
		if(nums.size() % 2 != 0) {
			output += "Median = " + nums.get((int) Math.floor(nums.size() / 2)) + "\n";
		}
		
		else {
			double median = (nums.get(nums.size() / 2) + nums.get((nums.size() / 2) - 1)) / 2;
			output += "Median = " + median + "\n";
		}
	}
	
	
	
	// Calculates Standard Deviation and Variance
	public void StandardDeviation() {
		// Adds up totals for standard deviation
		for(int i = 0; i < nums.size(); i++) {
			standardDeviationS += Math.pow((nums.get(i) - x_), 2);
			standardDeviationP += Math.pow((nums.get(i) - x_), 2);
		}
		// Calculates the rest of the standard deviation equation
		standardDeviationS = Math.sqrt(standardDeviationS / (nums.size() - 1));
		standardDeviationP = Math.sqrt(standardDeviationP / (nums.size()));
		output += "Standard Deviation (Population) = " + standardDeviationP + "\n";
		output += "Variance (Population) = " + standardDeviationP * standardDeviationP + "\n";
		output += "Standard Deviation (Sample) = " + standardDeviationS + "\n";
		output += "Variance (Sample) = " + standardDeviationS * standardDeviationS+ "\n";
		
	}
	
	public void Quartiles() {
		// Percentiles
		double p1 =  Math.floor(0.25 * (nums.size() - 1));
		double p3 =  Math.floor(0.75 * (nums.size() - 1));
		
		// Quartiles
		double q1 = nums.get((int) Math.round(p1));
		double q3 = nums.get((int) Math.round(p3));
		
		// Inter Quartile Range
		double iqr = q3 - q1;
		
		// Outliers
		ArrayList<Double> outliersL = new ArrayList<Double>();
		ArrayList<Double> outliersU = new ArrayList<Double>();
		
		double lowerExtreme = q1 - (1.5 * iqr);
		double upperExtreme = q3 + (1.5 * iqr);
		
		// Loop: Checking if any numbers are outliers.
		for(int i = 0; i < nums.size(); i++) {
			// Checks to see if the number is an outlier
			if(nums.get(i) < lowerExtreme) {
				outliersL.add(nums.get(i));
			}
			// Checks to see if the number is an outlier
			if(nums.get(i) > upperExtreme) {
				outliersU.add(nums.get(i));
			}
		}
		
		output += "Quartile 1 = " + q1 + "\n";
		output += "Quartile 3 = " + q3 + "\n";
		output += "Inter Quartile Range = " + iqr + "\n";
		
		// Outputs any outliers.
		for(int i = 0; i < outliersL.size(); i++) {
			if(i == 0) {
				output += "Lower Extreme Outliers = ";							
			}
			
			if(i == outliersL.size() - 1) {
				output += outliersL.get(i);
				output += "\n";
			}
			else {
				output += outliersL.get(i) + ", ";
				
			}
		}
		
		for(int i = 0; i < outliersU.size(); i++) {
			if(i == 0) {
				output += "Upper Extreme Outliers = ";							
			}
			
			if(i == outliersU.size() - 1) {
				output += outliersU.get(i);
				output += "\n";
			}
			else {
				output += outliersU.get(i) + ", ";				
			}
		}
		
	}
	
	// Calculates the range of the numbers.
	public void Range() {
		double ranges = nums.get(nums.size() - 1) - nums.get(0);
		output += "Range: " + ranges + "\n";
	}
	
	
	
	
}
