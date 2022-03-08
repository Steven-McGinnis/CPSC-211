 
public class Model {

	/**
	 * Flags that contain the state of the game
	 */
	private Scenes currentState = Scenes.state;
	private boolean powerRestored = true;
	private boolean lifeSupportOn = true;
	private boolean isDressed = false;
	private boolean damageRepaired = false;
	private boolean enginesLinked = false;
	
	/**
	 * Sets CurrentState to The State Received
	 * @param currentState
	 */
	public void setCurrentState(Scenes currentState) {
		this.currentState = currentState;
	}

	/**
	 * Sets Power Restored to the State Received
	 * @param powerRestored
	 */
	public void setPowerRestored(boolean powerRestored) {
		this.powerRestored = powerRestored;
	}

	/**
	 * Sets Life Support to the State Received
	 * @param lifeSupportOn
	 */
	public void setLifeSupportOn(boolean lifeSupportOn) {
		this.lifeSupportOn = lifeSupportOn;
	}

	/**
	 * Sets Are you Dressed to the State Received
	 * @param isDressed
	 */
	public void setDressed(boolean isDressed) {
		this.isDressed = isDressed;
	}

	/**
	 * Sets Damage in Storage Repaired to State Received
	 * @param damageRepaired
	 */
	public void setDamageRepaired(boolean damageRepaired) {
		this.damageRepaired = damageRepaired;
	}

	/**
	 * Sets Engines Linked Flag
	 * @param enginesLinked
	 */
	public void setEnginesLinked(boolean enginesLinked) {
		this.enginesLinked = enginesLinked;
	}

	
	/**
	 * Query The Current State and Returns a Value
	 * @return Scenes Value
	 */
	public Scenes getCurrentState ()
	{
		return currentState;
	}

	/**
	 * Query weather power is Restored
	 * @return boolean
	 */
	public boolean isPowerRestored() {
		return powerRestored;
	}

	/**
	 * Query weather life support has been fixed
	 * @return boolean
	 */
	public boolean isLifeSupportOn() {
		return lifeSupportOn;
	}

	/**
	 * Query weather the player is dressed
	 * @return boolean
	 */
	public boolean isDressed() {
		return isDressed;
	}

	/**
	 * Query weather the player has repaired the ship damage
	 * @return boolean
	 */
	public boolean isDamageRepaired() {
		return damageRepaired;
	}
	
	/**
	 * Asks if Engines Are Linked to Reactor
	 * @return True or False
	 */
	public boolean isEnginesLinked() {
		return enginesLinked;
	}

	
	/**
	 * Gets each flag and combines them into a single string
	 * @return status String
	 */
	public String saveModel() {
		SaveLoad save = new SaveLoad();
	    String status = "";
	    status += getCurrentState();
	    status += " " + save.saveBoolean(powerRestored);
	    status += " " + save.saveBoolean(lifeSupportOn);
	    status += " " + save.saveBoolean(isDressed);
	    status += " " + save.saveBoolean(damageRepaired);
	    status += " " + save.saveBoolean(enginesLinked);
	    return status;
	}
}
