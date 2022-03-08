import java.util.ArrayList;

public class engines extends State {
	//Default Constructor
	public engines(Model model) {
		super(model);
	}
	
	//Description
	public ArrayList<String> getDescription(Model model) {
		ArrayList<String> Description = new ArrayList<String>();
		 Description.add("This is the Engine Room, it is a complex room focused around the high power engines that run through the ship.");
		 Description.add("There is a door to the power plant where you came from. There is a terminal that allows you to fix the engines.");
		return Description;
	}
	
	//Generate the Menu
	public String[] generateMenu(Model model) {;
	String [] menu = {"Save", "Approach Engine Terminal", "Exit to Power Plant"};
	super.choices = menu.length;
	return menu;	
	}
	
	//Process Player Choices
	public void processChoice(Model model, int selection) {
		if (selection == 0) {
			super.saveGame(model);
		}
		else if(selection == 1) {
			model.setCurrentState(Scenes.engineTerminal);
		}
		else if (selection == 2) {
			model.setCurrentState(Scenes.powerPlant);
		}
	}
}
