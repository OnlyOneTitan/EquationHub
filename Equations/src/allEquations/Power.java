package allEquations;

public class Power {

	// P = V * I
	public void PowerP(double voltage, double current) {
		System.out.println("=================================");
		System.out.println("P = V * I");
		System.out.println("P = " +  voltage * current + "W");
		System.out.println("=================================");

	}
	
	// V = P / I
	public void PowerV1(double power, double current) {
		System.out.println("=================================");
		System.out.println("V = P / I");
		System.out.println("V = " + power / current + "V");
		System.out.println("=================================");

	}
	
	// V = I * R
	public void PowerV2(double current, double resistance) {
		System.out.println("=================================");
		System.out.println("V = I * R");
		System.out.println("V = " + current * resistance + "V");
		System.out.println("=================================");

	}
	
	// I = P / V
	public void PowerI1(double power, double voltage) {
		System.out.println("=================================");
		System.out.println("I = P / V");
		System.out.println("I = " + power / voltage + "A");
		System.out.println("=================================");
	}
	
	// I = V / R
	public void PowerI2(double voltage, double resistance) {
		System.out.println("=================================");
		System.out.println("I = V / R");
		System.out.println("I = " + voltage / resistance + "A");
		System.out.println("=================================");
	}
	
	// R = V / I
	public void PowerR1(double voltage, double current) {
		System.out.println("=================================");
		System.out.println("R = V / I");
		System.out.println("R = " + voltage / current + "ohms");
		System.out.println("=================================");
	}
	
	
	
	
	

}
