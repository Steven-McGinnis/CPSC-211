import java.util.ArrayList;

public class diningHall extends State {
	//Constructor
	public diningHall(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}
	
	//Description
	public ArrayList<String> getDescription(Model model) {
		ArrayList<String> Description = new ArrayList<String>();
		 Description.add("This is the Dining Hall.  When you walk in you notice that much of the stored sections have been thrown all over the floor.");
		 Description.add("Whatever has caused all of this damage clearly was violent.  You look around the room and find nothing key that you need to");
		 Description.add("worry about at the moment. There are four doors here the signs above the doors read, Central Hub, Life Support, Storage, PowerPlant." );
		return Description;
	}
	
	//Generates Menu
	public String[] generateMenu(Model model) {;
	String [] menu = {"Save", "Head to Central Hub", "Head to Life Support", "Head to Storage", "Head to Power Plant"};
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
			model.setCurrentState(Scenes.centralHub);
		}
		else if (selection == 2) {
			model.setCurrentState(Scenes.lifeSupport);
		}
		else if (selection == 3) {
			if (model.isDamageRepaired() == false) {
				model.setCurrentState(Scenes.storage);
			}
			else {
				view.displayDescription(damageRepaired());
			}
		}
		else if (selection == 4) {
			model.setCurrentState(Scenes.powerPlant);
		}
	}
	
	//If you have already fixed the problem prints warning
	private ArrayList<String> damageRepaired() {
		ArrayList<String> Description = new ArrayList<String>();
		Description.add("You have already Jettisoned the Storage Section. Survival will be harder without it but it had to be done.");
		return Description;
	}
}
