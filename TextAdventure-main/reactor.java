import java.util.ArrayList;

public class reactor extends State {
	//Default Constructor
	public reactor(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}
	
	//Description
	public ArrayList<String> getDescription(Model model) {
		ArrayList<String> Description = new ArrayList<String>();
		 Description.add("You approach the Reactor. It has a panel that has a series of buttons on it.  You look carefully");
		 Description.add("at the readouts.");
		 if(model.isPowerRestored() != true) {
			 Description.add("");
			 Description.add("The Readout on the controls is showing that the safety shutdowns are enabled to prevent overloading.");
			 Description.add("You can toggle the safetys and restart the reactor priming sequence to engage the reactor.");	 
		 }
		 else if (model.isPowerRestored() == true) {
			 Description.add("");
			 Description.add("The Readout on the controls says that everything is active and power is at full capacity.");
		 }
		return Description;
	}
	
	//Generates Menu
	public String[] generateMenu(Model model) {;
	String [] menu = {"Save", "Prime and Reactivate Reactor", "Exit to Power Plant"};
	super.choices = menu.length;
	return menu;	
	}
	
	//Processes Player Choices
	public void processChoice(Model model, int selection) {
		TextViewController view = new TextViewController();
		if (selection == 0) {
			super.saveGame(model);
		}
		else if(selection == 1) {
			if(model.isPowerRestored() != true) {
				view.displayDescription(fixReactor(model));
			}
			else {
				view.displayDescription(alreadyFixed(model));
			}
		}
		else if (selection == 2) {
			model.setCurrentState(Scenes.powerPlant);
		}
	}

	//Displays what is necessary for fixing the reactor
	private ArrayList<String> fixReactor(Model model) {
		ArrayList<String>Description = new ArrayList<String>();
		Description.add("You work through the safetys ensuring that the system is clearing each check. After you clear the final one the system says primed.");
		Description.add("You engage the Reactor and the power thrums to life. A bright white light fills the room and the power kicks on throghout the ship.");
		Description.add("You will have to Relink the Engines in order to get the ship ready for travel.  This needs to be done immediately so you will have");
		Description.add("to do it now before life support is restored.");
		model.setPowerRestored(true);
		return Description;
	}

	//Outputs text if you have already fixed the reactor
	public ArrayList<String> alreadyFixed(Model model) {
		ArrayList <String> Description = new ArrayList <String>();
		Description.add("You have already fixed the reactor.");
		return Description;
	}
	
}
