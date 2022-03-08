import java.util.ArrayList;

public class bridge extends State {
	//Default Constructor
	public bridge(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}
	
	//Description
	public ArrayList<String> getDescription(Model model) {
		ArrayList<String> Description = new ArrayList<String>();
		 Description.add("This is the Bridge. Where all of the ships key controls are located. You see that debris are floating outside the ship.");
		 Description.add("There are Pilot Controls and Status lights everywhere.");
		 return Description;
	}

	//Generates Menu options based on weather or not you have fixed everything
	public String[] generateMenu(Model model) {;
	if (model.isPowerRestored() != true || model.isLifeSupportOn() != true || model.isEnginesLinked() != true || model.isDamageRepaired() != true) {
		String [] menu2 = {"Save", "Look Out the Windows", "Check Ship Status" ,"Head to Central Hub"};
		super.choices = menu2.length;
		return menu2;
	} 
	else {
		String [] menu = {"Save", "Look Out the Windows", "Check Ship Status", "Set Course and activate HyperDrive" ,"Head to Central Hub"};
		super.choices = menu.length;
		return menu;
		}
	
	}

	//Figures out what choices are available from Menu and which choices to display
	public void processChoice(Model model, int selection) {
		if (super.choices == 4) {
			processChoiceNotRepaired(model, selection);
		}
		else{
			processChoiceShipRepaired(model, selection);
		}
	}
		
	//If ship is fixed display menu with hyperspace option
	private void processChoiceShipRepaired(Model model, int selection) {
		TextViewController view = new TextViewController();
		if (selection == 0) {
			super.saveGame(model);
		}
		else if(selection == 1) {
			view.displayDescription(lookOutside());
		}
		else if (selection == 2) {
			view.displayDescription(super.checkShipStatus(model));
		}
		else if (selection == 3) {
			model.setCurrentState(Scenes.hyperSpace);
		}
		else if (selection == 4) {
			model.setCurrentState(Scenes.centralHub);
		}
	}
	
	//If ships not fixed display menu without Hyperspace option
	public void processChoiceNotRepaired(Model model, int selection) {
		TextViewController view = new TextViewController();
		if (selection == 0) {
			super.saveGame(model);
		}
		else if(selection == 1) {
			view.displayDescription(lookOutside());
		}
		else if (selection == 2) {
			view.displayDescription(super.checkShipStatus(model));
		}
		else if (selection == 3) {
			model.setCurrentState(Scenes.centralHub);
		}
	}

	//If you look outside this is what you Print
	private ArrayList<String> lookOutside(){
		ArrayList<String> Description = new ArrayList<String>();
		Description.add("You take a moment to look out the window.  There appears to be Asteroid Debris scattered around your stalled ship.");
		Description.add("You figure that an Asteroid impact was probably the cause for all of the ships damage.");
		Description.add("It looks like most of the damage occured in the Storage Section of the ship.");
		return Description;
		
	}

}
