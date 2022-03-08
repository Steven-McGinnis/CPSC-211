import java.util.ArrayList;

public class cryoChambers extends State{
	//Constructor
	public cryoChambers(Model model) {
		super(model);
	}

	//Description
	public ArrayList<String> getDescription(Model model) {
		ArrayList<String> Description = new ArrayList<String>();
		 Description.add("You are standing in the middle of the cryochamber that your ship uses to house its");
		 Description.add("crew. All of your crews lifepods are still inactive and they are still in cryosleep.");
		 Description.add("You are the only one able to fix this problem and get it back on course so awakening");
		 Description.add("the others would only cause more problems.");
		 Description.add("There are a row of lockers against the wall with names on them.");
		 
		 if (model.isDressed() != true) {
			 Description.add(" ");
			 Description.add("You are currently not dressed and should find your clothes.");
		 }
		 return Description;
	}
	
	//Menu
	public String[] generateMenu(Model model) {;
		if (model.isDressed() != true) {
			String [] menu2 = {"Save", "Look at Pods", "Open your Locker", "Exit to Central Hub"};
			super.choices = menu2.length;
			return menu2;
		}
		String [] menu = {"Save", "Look at Pods", "Exit to Central Hub"};
		super.choices = menu.length;
		return menu;	
	}
	
	//Which Choice Menu to give
	public void processChoice(Model model, int selection) {
		if (choices == 4) {
			dressChoice(model, selection);
		}
		else {
			regularChoice(model, selection);
		}
	}
	
	//Lets you Leave unless your not dressed
	private void regularChoice(Model model, int selection) {
		TextViewController view = new TextViewController();
		if (selection == 0) {
			super.saveGame(model);
		}
		else if(selection == 1) {
			view.displayDescription(examinePods());
		}
		else if (selection == 2) {
			if (model.isDressed() != true) {
				view.displayDescription(displayDressWarning());
			}
			else {
				model.setCurrentState(Scenes.centralHub);
			}
		}
	}
		
	//Lets you go to lockers to get dressed
	public void dressChoice(Model model, int selection) {
		TextViewController view = new TextViewController();
		if (selection == 0) {
			super.saveGame(model);
		}
		else if(selection == 1) {
			view.displayDescription(examinePods());
		}
		else if (selection == 2) {
			model.setCurrentState(Scenes.lockers);
		}
		else if (selection == 3) {
			if (model.isDressed() != true) {
				view.displayDescription(displayDressWarning());
			}
			else {
				model.setCurrentState(Scenes.centralHub);
			}
		}
	}
	
	//If you Look at the Pods then tell you what you see
	private ArrayList<String>examinePods(){
		ArrayList<String> Description = new ArrayList<String>();
		Description.add("You look at the pods of your crewmates and can see all of them sleeping in stasis.");
		Description.add("The ship woke you because you are the most capable of fixing this problem.");
		Description.add("You should leave them as it would take to long to get them up to speed");
		Description.add(" ");
		return Description;
	}
	
	//Warns you that you should get dressed
	private ArrayList<String> displayDressWarning(){
		ArrayList<String> Description = new ArrayList<String>();
		Description.add("You are not dressed you should do that first.");
		return Description;
	}
}
