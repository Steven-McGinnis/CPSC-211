import java.util.ArrayList;

public class engineTerminal extends State {
	//Default Constructor
	public engineTerminal(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	//Description
	public ArrayList<String> getDescription(Model model) {
		ArrayList<String> Description = new ArrayList<String>();
		 Description.add("The Engine Terminal is a complex terminal designed to link the engines with the reactor power.");
		 Description.add("It is a delicate process that can only be done immediately after the reactor has been primed and started.");
		 Description.add("");
		 if(model.isEnginesLinked() != true) {
			 Description.add("The Terminal is awaiting confimation to begin engine linkage.");
		 }
		return Description;
	}
	
	//Generates the Menu
	public String[] generateMenu(Model model) {;
	String [] menu = {"Save", "Trigger Engine Linkage", "Exit to Engine Room"};
	super.choices = menu.length;
	return menu;	
	}
	
	//Processes Player Choice
	public void processChoice(Model model, int selection) {
		TextViewController view = new TextViewController();
		if (selection == 0) {
			super.saveGame(model);
		}
		else if(selection == 1) {
			if(model.isEnginesLinked() == true) {
				view.displayDescription(alreadyLinked());
			}
			else if(model.isPowerRestored() == false) {
				view.displayDescription(noPower());
			}
			else {
				view.displayDescription(engineLink(model));
			}
		}
		else if (selection == 2) {
			model.setCurrentState(Scenes.engines);
		}
	}
	
	//If the Engines are Already Linked do this
	private ArrayList<String> alreadyLinked() {
		ArrayList<String> Description = new ArrayList<String>();
		Description.add("You have already Linked the Engines.");
		return Description;
	}
	
	//If the Engines are being linked do this
	private ArrayList<String> engineLink(Model model) {
		ArrayList<String> Description = new ArrayList<String>();
		Description.add("You link the Engines with the Reactor. The engines roar to life in order to start self correcting the ships drift.");
		model.setEnginesLinked(true);
		return Description;
	}
	
	//If theres no power do this.
	private ArrayList<String> noPower() {
		ArrayList<String> Description = new ArrayList<String>();
		Description.add("The Power has not been restored so you cannot link the engines.");
		return Description;
	}
	
}
