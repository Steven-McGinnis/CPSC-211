import java.util.ArrayList;

public class powerPlant extends State {
	//Default Constructor
	public powerPlant(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}
	
	//Description
	public ArrayList<String> getDescription(Model model) {
		ArrayList<String> Description = new ArrayList<String>();
		 Description.add("This is the Power Plant. The primary method of powering your ship. It is a large circular room with walkways around the edges.");
		 Description.add("In the center of the room is the primary ark reactor that powers the ship.  It is a large structure that is able to power your hyperdrive.");
		 Description.add("You see a terminal that controls the system attached to the side of the reactor. On one side of the room there is a door leading to the Dining hall.");
		 Description.add("On the other side of the room is a door leading to the Engine Room");
		 if (model.isPowerRestored() != true) {
			 Description.add("");
			 Description.add("The reactor is cold and there is little to no power running through the system.");
			 Description.add("You will have to prime it and get it back online.");
			 Description.add("");
		 }
		 else if (model.isPowerRestored() == true) {
			 Description.add("");
			 Description.add("The reactor is humming with life and power is thrumming as your stand here in the chamber.");
		 }
		return Description;
	}
	
	//Generate the Menu of Options
	public String[] generateMenu(Model model) {;
	String [] menu = {"Save", "Approach Reactor", "Exit to Dining Hall", "Exit to Engine Room"};
	super.choices = menu.length;
	return menu;	
	}
	
	//Process Player Choices
	public void processChoice(Model model, int selection) {
		TextViewController view = new TextViewController();
		if (selection == 0) {
			super.saveGame(model);
		}
		else if(selection == 1) {
			model.setCurrentState(Scenes.reactor);
		}
		else if (selection == 2) {
			if (model.isPowerRestored() == true && model.isEnginesLinked() == true) {
				model.setCurrentState(Scenes.diningHall);
			}
			else if (model.isPowerRestored() == true && model.isEnginesLinked() == false) {
				view.displayDescription(enginefix(model));
			}
			else if (model.isPowerRestored() != true) {
				model.setCurrentState(Scenes.diningHall);
			}
		}
		else if (selection == 3) {
			model.setCurrentState(Scenes.engines);
		}
	}
	
	//Catches if Player has already done power
	public ArrayList<String> enginefix(Model model) {
		ArrayList <String> Description = new ArrayList <String>();
		Description.add("You should link the Engines now that the power is Restored.");
		return Description;
	}
}
