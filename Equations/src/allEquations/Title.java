package allEquations;

public class Title {
	
	// Name of the program
	public String name = "EquationHub ";
	// Version is measured by year.release.iteration.developmentday
	public String version = "dev18.1.2.3a";
	
	// A constructor that other classes can access
	public String setTitle() {
		// Adds an equals for the title in the console, mainly to make the title look nice as versions change.
		String spacers = "";
		for(int i = 0;i< version.length();i++) {
			spacers += "=";
		}
		// Title
		String title = "";
		title += "   ================" + spacers + "==   \n";
		title += spacers.replace("=", " ") + name + version + spacers.replace("=", " ") + "\n";
		title += "   ================"+ spacers + "==   \n\n\n\n";
		return title;
	}
}
