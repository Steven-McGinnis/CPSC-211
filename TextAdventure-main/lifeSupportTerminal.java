import java.util.ArrayList;

public class lifeSupportTerminal extends State {
	//Default Constructor
	public lifeSupportTerminal(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}
	
	//Description
	public ArrayList<String> getDescription(Model model) {
		ArrayList<String> Description = new ArrayList<String>();
		 Description.add("You Approach the Life Support Terminal. It is a very complicated system. Luckily you are friends with the scientist.");
		 Description.add("You know how to make the system run if not at its peak performance.");
		return Description;
	}
	
	//Generates the Menu Option
	public String[] generateMenu(Model model) {;
	String [] menu = {"Save", "Reactivate Life Support", "Exit to Life Support"};
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
			if(model.isLifeSupportOn() == false && model.isPowerRestored() == true) {
				view.displayDescription(lifeSupportSystem(model));
			}
			else if(model.isLifeSupportOn() == false && model.isPowerRestored() == false) {
				view.displayDescription(nopower());
			}
			else if (model.isLifeSupportOn() == true) {
				view.displayDescription(lifealreadyon());
			}
		}
		else if (selection == 2) {
			model.setCurrentState(Scenes.lifeSupport);
		}
	}
	
	//Life Support System Activation
	private ArrayList<String> lifeSupportSystem(Model model) {
		ArrayList<String>Description = new ArrayList<String>();
		Description.add("You take time to restore the life support system.  It takes longer than you would like and you feel like");
		Description.add("your going to pass out but right as your mind is starting to slip due to hypoxia the system engages.");
		Description.add("You greedily catch your breath.");
		model.setLifeSupportOn(true);
		return Description;	
	}
	
	//If Life Support is already on say this
	private ArrayList<String> lifealreadyon(){
		ArrayList<String> Description = new ArrayList<String>();
		Description.add("The Life Support System is Already Running as good as you can get it.");
		return Description;
		}
	
	//If there is no power say this
	private ArrayList<String> nopower(){
		ArrayList<String> Description = new ArrayList<String>();
		Description.add("The Life Support System needs ample power to get working.  You must restore power first.");
		return Description;
		}
}

