import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SaveLoad {
	/**
	 * Creates the PrintWriter and Scanner
	 */
	PrintWriter file;
	Scanner scnr;
	
	/**
	 * Outputs the string it recieves to a fail for saving.
	 * @param model:Model
	 * @param state:String it Recieves
	 */
	public void outputModel(Model model, String state) {
		String saveState = state;
		try
        {
            file = new PrintWriter ("save.dat");
			file.println(saveState);
            file.close ();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
	}
	
	/**
	 * Loads the model from the file
	 * Sets Scenes and Models
	 * @param model:Model
	 * @return Boolean
	 */
	public boolean loadModel(Model model) {
		{
			 try
		        {
		            Scanner file = new Scanner (new File("save.dat"));
		            Scenes value = Scenes.valueOf(file.next());
		            model.setCurrentState(value);
		            model.setPowerRestored(convertBoolean(file.next()));
		            model.setLifeSupportOn(convertBoolean(file.next()));
		            model.setDressed(convertBoolean(file.next()));
		            model.setDamageRepaired(convertBoolean(file.next()));
		            model.setEnginesLinked(convertBoolean(file.next()));
		            file.close ();
		            return true;
		        }
		        catch (FileNotFoundException e)
		        {
		            return false;
		        }
		}
	}
	
	/**
	 * Checks a String Value and Converts to Boolean
	 * @param value:String
	 * @return Boolean
	 */
	private boolean convertBoolean(String value) {
		if (value.equals("T")){
			return true;
		}else if (value.equals("F")) {
			return false;
		}
		return false;
	}
	
	/**
	 * Takes a Boolean Value and Converts it to a String
	 * @param value:Boolean
	 * @return String
	 */
   public String saveBoolean (boolean value)
    {
        if (value)
            return "T";
        
        return "F";
    }
}
