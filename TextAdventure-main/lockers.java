import java.util.ArrayList;

public class lockers extends State {	
	//Constructor
	public lockers(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	//Description
	public ArrayList<String> getDescription(Model model) {
		ArrayList<String> Description = new ArrayList<String>();
		 Description.add("You Approach your Locker");
		 Description.add("When you Open it you see your uniform and a photo of earth.");
		 Description.add("The uniform is a navy blue jumpsuit that all of your crew wears while on the ship.");	 
		 if (model.isDressed() != true) {
			 Description.add("You are currently not dressed and should put on this uniform.");
		 }
		 return Description;
	}
	
	//Generates the Menu Choices 
	public String[] generateMenu(Model model) {;
	if (model.isDressed() != true) {
		String [] menu2 = {"Save", "Put on Uniform", "Look at Photo", "Exit lockers"};
		super.choices = menu2.length;
		return menu2;
	}
	String [] menu = {"Save", "Look at Photo", "Exit lockers"};
	super.choices = menu.length;
	return menu;	
	}

	//Decudes what Menu to Display
	public void processChoice(Model model, int selection) {
		if (choices == 4) {
			notDressed(model, selection);
		}
		else {
			regularChoice(model, selection);
		}
	}
	
	//If your dressed prints this Menu
	private void regularChoice(Model model, int selection) {
		TextViewController view = new TextViewController();
		if(selection == 0) {
			super.saveGame(model);
		}
		else if (selection == 1) {
			view.displayDescription(examinePhoto());
		}
		else if (selection == 2) {
			model.setCurrentState(Scenes.cryoChambers);
		}
		
	}

	//If not Dressed Prints this Menu
	public void notDressed(Model model, int selection) {
		TextViewController view = new TextViewController();
		if(selection == 0) {
			super.saveGame(model);
		}
		else if (selection == 1) {
			view.displayDescription(uniformDressed(model));
		}
		else if (selection == 2) {
			view.displayDescription(examinePhoto());
		}
		else if (selection == 3) {
			model.setCurrentState(Scenes.cryoChambers);
		}
	}

	//If you look at the photo this is what it says
	private ArrayList<String> examinePhoto() {
		ArrayList<String> Description = new ArrayList<String>();
		Description.add("A photo of Earth as you left it.");
		Description.add("Unfortunately the Satilite Debris make it hard to see any blue however that is kind of the reason you chose to leave it behind.");
		Description.add("");
		return Description;
	}

	//Gives you information about your Outfit
	private ArrayList<String> uniformDressed(Model model) {
		ArrayList<String> Description = new ArrayList<String>();
		Description.add("You put on your Navy Jumpsuit it seems baggier than you remember.");
		Description.add("");
		model.setDressed(true);
		return Description;
		
	}
}
