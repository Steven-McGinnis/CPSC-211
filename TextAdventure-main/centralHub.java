import java.util.ArrayList;

public class centralHub extends State{
	//Default Constructor
	public centralHub(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	//Description
	public ArrayList<String> getDescription(Model model) {
		ArrayList<String> Description = new ArrayList<String>();
		 Description.add("This is the central hub of the ship. It is a location that has three different directions going from it.");
		 Description.add("The signs above the three doors read, Cryo Chambers, Bridge, and Dining Hall.");
		 return Description;
	}
	
	//Generates Menu Choices
	public String[] generateMenu(Model model) {;
	String [] menu = {"Save", "Head to Cryo Chambers", "Head to Bridge", "Head to Dining Hall"};
	super.choices = menu.length;
	return menu;	
	}

	//Processes Player Choice
	public void processChoice(Model model, int selection) {
		if (selection == 0) {
			super.saveGame(model);
		}
		else if(selection == 1) {
			model.setCurrentState(Scenes.cryoChambers);
		}
		else if (selection == 2) {
			model.setCurrentState(Scenes.bridge);
		}
		else if (selection == 3) {
			model.setCurrentState(Scenes.diningHall);
		}
	}
}
