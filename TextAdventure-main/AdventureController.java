import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Scanner;

public class AdventureController {
	private EnumMap<Scenes, State> location = new EnumMap<>(Scenes.class);
	private int choice;
	
	/**
	 * The Main Method for the Program
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdventureController controller = new AdventureController();
		State state = new State(null);
		controller.go(state);	
	}
	
	/**
	 * Gets the amount of choices from the State Class
	 * Then Asks user for a choice and compares it to amount of choices
	 * Then returns valid choice to the State Model
	 * @param top Amount of Choices
	 */
	public void getChoice(int top) {
		if (0 == top) {
			return;
		}
		Scanner scnr = new Scanner(System.in);
		int result = 0 - 1;
		
		while (result < 0 || result > top)
		{
			while (! scnr.hasNextInt())
				scnr.nextLine();
			
			result = scnr.nextInt ();
			scnr.nextLine ();
		}	
		choice = result;
	}

	/**
	 * The High Order Method that runs the game logic
	 * @param state 
	 */
	private void go(State state) {
		Model model = new Model ();
		TextViewController view = new TextViewController();
		chooseSaveLoad(state);
		populateEnumMap(model);
		getChoice(1);
		startLoad(choice, model);
		gameLoop(model);
		view.displayDescription(gameEnd());
	}
	

	/**
	 * The Game Loop Going through States
	 * Gets Description
	 * Gets Menu
	 * Gets Player Choice
	 * Implements Choice
	 * @param model
	 */
	private void gameLoop(Model model) {
		TextViewController view = new TextViewController();	
		while(model.getCurrentState() != Scenes.hyperSpace) {
			view.displayDescription(location.get(model.getCurrentState()).emergencyCheck(model));
			view.displayDescription(location.get(model.getCurrentState()).getDescription(model));
			view.printMyMenu(view.printMenu(location.get(model.getCurrentState()).generateMenu(model)));
			getChoice(location.get(model.getCurrentState()).generateChoices(model));
			location.get(model.getCurrentState()).processChoice(model, choice);
		}
	}

	/**
	 * Provides the Game over Text When you complete the game
	 * @return Description: ArrayList<String>
	 */
	private ArrayList<String> gameEnd() {
		ArrayList<String> Description = new ArrayList<String>();
		Description.add("The Ship begins to hum as the Ark Reactor begins to build power to the engines that you linked up.");
		Description.add("A timer begins for 10:00 minutes as you finish adjusting the coarse. You begin to make your way back");
		Description.add("to the cryo chambers to reenter your pod.  Without it you would be turned to paste.  Not an ideal way to go.");
		Description.add("You hope that everything you did will help get you to Proxima Centauri.  But there is only one way to find out.");
		Description.add("You climb in your pod and drift off to sleep.  After the timer counts down you enter Hyperspace and head towards your destination.");
		Description.add("");
		Description.add("GAME OVER");
		return Description;
		
	}

	/**
	 * Asks to Save or Load
	 * Sends Menu to the Display
	 * @param state The superClass
	 */
	private void chooseSaveLoad(State state) {
		TextViewController view = new TextViewController();
		System.out.println("Would you like to Start a New Game or Load an Existing Game.");
		String [] menu = {"Load game", "New game"};
		view.printMyMenu(view.printMenu(menu));	
	}
	
	/**
	 * If player is loading Load From File Else do Nothing
	 * @param choice Input from User
	 * @param model The Storage System
	 */
	private void startLoad(int choice, Model model) {
		if (choice == 0) {
			SaveLoad load = new SaveLoad();
			load.loadModel(model);
		}	
	}
	
	/**
	 * Populates the EnumMap with the Scenes for my State Machine
	 * I couldn't figure out how to loop create with a rotating variable
	 * thus I had to do it manually.
	 * @param model The Model Holding Flags
	 */
	private void populateEnumMap(Model model) {
		location.put(Scenes.state, new State(model));
		location.put(Scenes.cryoChambers, new cryoChambers(model));
		location.put(Scenes.lockers, new lockers(model));
		location.put(Scenes.centralHub, new centralHub(model));
		location.put(Scenes.bridge, new bridge(model));
		location.put(Scenes.diningHall, new diningHall(model));
		location.put(Scenes.powerPlant, new powerPlant(model));
		location.put(Scenes.reactor, new reactor(model));
		location.put(Scenes.engines, new engines(model));
		location.put(Scenes.engineTerminal, new engineTerminal(model));
		location.put(Scenes.lifeSupport, new lifeSupport(model));
		location.put(Scenes.lifeSupportTerminal, new lifeSupportTerminal(model));
		location.put(Scenes.storage, new storage(model));
	}
}
