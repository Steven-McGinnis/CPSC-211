import java.util.ArrayList;

public class storage extends State {
	//Constructor
	public storage(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}
	
	//Description
	public ArrayList<String> getDescription(Model model) {
		ArrayList<String> Description = new ArrayList<String>();
		 Description.add("You made it to the storage module of the ship but the door to the area is sealed shut.");
		 Description.add("Looking through the window you can see a massive hole in the bulkhead. There is a panel next to the door.");
		 Description.add("You can exit to the Dining Hall from the way you came.");
		 return Description;
	}
	
	//Generates Menu
	public String[] generateMenu(Model model) {;
	String [] menu = {"Save", "Jettison Storage Module", "Exit to Dining Hall"};
	super.choices = menu.length;
	return menu;	
	}
	
	//Processes Choice
	public void processChoice(Model model, int selection) {
		TextViewController view = new TextViewController();
		if (selection == 0) {
			super.saveGame(model);
		}
		else if(selection == 1) {
			view.displayDescription(fixStorage(model));
		}
		else if (selection == 2) {
			model.setCurrentState(Scenes.engines);
		}
	}
	
	//Fix Storage By Jettisoning
	private ArrayList<String> fixStorage(Model model) {
		ArrayList<String> Description = new ArrayList<String>();
		Description.add("You reach out to the control panel and enter your code giving you access to the jettison command.");
		Description.add("You realize that while the section of the ship is damaged you wont have the structural integrity to jump to hyperspace.");
		Description.add("Also without the supplies in that room it will be much harder to survive when you arrive at your destination.");
		Description.add("However, you do not have the means to fix it and you will all certainly die if you choose to try and save it.");
		Description.add("Your hand hovers for a minute but then you hit the release.");
		Description.add("The Storage section begins to drift slowly away from the ship out to a safe distance. And you feel it is safe to jump without it.");
		Description.add("You Step Away from the door to storage back into the Dining hall.");
		model.setDamageRepaired(true);
		model.setCurrentState(Scenes.diningHall);
		return Description;		
	}
}
