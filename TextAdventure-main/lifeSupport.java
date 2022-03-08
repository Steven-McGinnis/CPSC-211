import java.util.ArrayList;

public class lifeSupport extends State {
	//Default Constructor
	public lifeSupport(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}
	
	//Description
	public ArrayList<String> getDescription(Model model) {
		ArrayList<String> Description = new ArrayList<String>();
		 Description.add("This is Life Support.  There is a series of plants in intricate mechanical systems in order to provide you with endless oxygen.");
		 Description.add("Complex Machines that are usually maintained by the scientist on the ship help keep life support running.");
		 Description.add("There is a door leading to the Dining Hall here.");
		return Description;
	}
	
	//Generates Menu
	public String[] generateMenu(Model model) {;
	String [] menu = {"Save", "Approach Life Support System", "Exit to Dining Hall"};
	super.choices = menu.length;
	return menu;	
	}
	
	//Process Player choice
	public void processChoice(Model model, int selection) {
		if (selection == 0) {
			super.saveGame(model);
		}
		else if(selection == 1) {
			model.setCurrentState(Scenes.lifeSupportTerminal);
		}
		else if (selection == 2) {
			model.setCurrentState(Scenes.diningHall);
		}
	}
}
