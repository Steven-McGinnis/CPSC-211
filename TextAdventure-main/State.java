import java.util.ArrayList;
import java.util.EnumMap;

public class State {
	/**
	 * The Variable Generate Choices uses to create options
	 */
	protected int choices = 0;
	
	/**
	 * State Constructor
	 * @param model:Model
	 */
	public State(Model model) {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * The Default Descriptor for the beginning of the game
	 * @param model:Model
	 * @return Description:ArrayList<String>
	 */
	public ArrayList<String> getDescription(Model model) {
		ArrayList<String> Description = new ArrayList<String>();
		 Description.add("You find yourself starteling awake to the sounds of alarms in a steel bed tube.");
		 Description.add("You look around drowsy and remember that you were in a cryo pod traveling on the ship Andromeda.");
		 Description.add("You were traveling to Proxima Centauri.");
		 Description.add("Clearly something has gone wrong.  The power is out and Life Support is failing");
		 Description.add("You climb out of your pod.  You need to fix this so you can make it to Proxima Centauri.");
		 Description.add(" ");
		 return Description;
	}
	
	/**
	 * Default Generate Menu
	 * Does Nothing in SuperClass
	 * @param model:Model
	 * @return menu:String[]
	 */
	public String[] generateMenu(Model model) {
		String[] menu = {};
		return menu;	
	}
	
	/**
	 * Generates the choices that the player can use
	 * @param model: Model
	 * @return choices:int
	 */
	public int generateChoices(Model model) {
		return choices;
	}
	
	/**
	 * Gets the Choice and does what is necessary with it
	 * Default Superclass version Changes State and Sets 2 flags to false for cleaner text
	 * @param model:Model
	 * @param selection:int
	 */
	public void processChoice(Model model, int selection) {
		model.setCurrentState(Scenes.cryoChambers);
		model.setLifeSupportOn(false);
		model.setPowerRestored(false);
	}
	
	/**
	 * Querys the Model to generate the save string and passes it to the Save load Controller
	 * @param model:Model
	 */
	public void saveGame(Model model) {
		SaveLoad output = new SaveLoad();
		System.out.println(model.saveModel());
		output.outputModel(model, model.saveModel());
		System.exit(0);
	}
	
	/**
	 * Query model to see if emergency messages should be played to prompt player.  Psychological to induce a need for urgency.
	 * @param model:Model
	 * @return Description
	 */
	public ArrayList<String> emergencyCheck(Model model) {
		ArrayList<String> Description = new ArrayList<String>();
		Description.add("");
		if(! model.isPowerRestored()) {
			Description.add("Alarms are Flashing as it seems power is at minimal levels.");
		}
		if (! model.isLifeSupportOn()) {
			Description.add("It is hard to breathe clearly life support has failed.");
		}
		Description.add("");
		return Description;	
	}
	
	/**
	 * If the player uses the Computer on the bridge to check goals this querys whats still left to do.
	 * @param model: Model
	 * @return Description
	 */
	public ArrayList<String> checkShipStatus(Model model){
		ArrayList<String> Description = new ArrayList<String>();
		if (model.isPowerRestored() != true) {
			Description.add("There is no power running through the Key elements of the ship.  This needs repaired.");
		}
		if (model.isLifeSupportOn() != true) {
			Description.add("Life Support is struggling to keep up you need to restore the system to ensure... Life.");
		}
		if (model.isDamageRepaired() != true) {
			Description.add("There is Still damage to the Storage Section that you should seal off.");
		}
		return Description;
	}
}
