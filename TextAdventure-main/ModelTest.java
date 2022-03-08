import static org.junit.Assert.*;

import org.junit.Test;

public class ModelTest {

	@Test
	public void testIsEnginesLinked() {
		//Setup
		Model model = new Model();
		//Method Execution
		boolean test = model.isDamageRepaired();
		model.setDamageRepaired(true);
		boolean test2 = model.isDamageRepaired();
		//Verification
		if(test != false)
		fail("Is damaged Repaired should have been false but got " + test);
		if(test2 != true)
		fail("Is damaged Repaired should have been true but got " + test2);
	}

	@Test
	public void testSetEnginesLinked() {
		//Setup
		Model model = new Model();
		//Method Execution
		model.setEnginesLinked(true);
		boolean test = model.isEnginesLinked();
		model.setEnginesLinked(false);
		boolean test1 = model.isEnginesLinked();
		
		//Verification
		if(test != true)
		fail("Engine Links Should have been True but got " + test);
		if(test1 != false)
		fail("Engine Links Should have been False but got " + test1);
	}

	@Test
	public void testSetCurrentState() {
		//Setup
		Model model = new Model();
		//Method Execution
		Scenes test1 = model.getCurrentState();
		model.setCurrentState(Scenes.bridge);
		Scenes test2 = model.getCurrentState();
		model.setCurrentState(Scenes.lockers);
		Scenes test3 = model.getCurrentState();
		model.setCurrentState(Scenes.centralHub);
		Scenes test4 = model.getCurrentState();
		model.setCurrentState(Scenes.cryoChambers);
		Scenes test5 = model.getCurrentState();
		model.setCurrentState(Scenes.diningHall);
		Scenes test6 = model.getCurrentState();
		model.setCurrentState(Scenes.engines);
		Scenes test7 = model.getCurrentState();
		model.setCurrentState(Scenes.engineTerminal);
		Scenes test8 = model.getCurrentState();
		model.setCurrentState(Scenes.lifeSupport);
		Scenes test9 = model.getCurrentState();
		model.setCurrentState(Scenes.lifeSupportTerminal);
		Scenes test10 = model.getCurrentState();
		model.setCurrentState(Scenes.powerPlant);
		Scenes test11 = model.getCurrentState();
		model.setCurrentState(Scenes.reactor);
		Scenes test12 = model.getCurrentState();
		model.setCurrentState(Scenes.storage);
		Scenes test13 = model.getCurrentState();
		//Verification
		if(test1 != Scenes.state)
		fail("Scenes should have been State but got " + test1);
		if(test2 != Scenes.bridge)
		fail("Scenes should have been bridge but got " + test2);
		if(test3 != Scenes.lockers)
		fail("Scenes should have been lockers but got " + test3);
		if(test4 != Scenes.centralHub)
		fail("Scenes should have been centralhub but got " + test4);
		if(test5 != Scenes.cryoChambers)
		fail("Scenes should have been cryochambers but got " + test5);
		if(test6 != Scenes.diningHall)
		fail("Scenes should have been dininghall but got " + test6);
		if(test7 != Scenes.engines)
		fail("Scenes should have been engines but got " + test7);
		if(test8 != Scenes.engineTerminal)
		fail("Scenes should have been engineterminal but got " + test8);
		if(test9 != Scenes.lifeSupport)
		fail("Scenes should have been lifesupport but got " + test9);
		if(test10 != Scenes.lifeSupportTerminal)
		fail("Scenes should have been lifesupportterminal but got " + test10);
		if(test11 != Scenes.powerPlant)
		fail("Scenes should have been powerplant but got " + test11);
		if(test12 != Scenes.reactor)
		fail("Scenes should have been reactor but got " + test12);
		if(test13 != Scenes.storage)
		fail("Scenes should have been storage but got " + test13);
	}

	@Test
	public void testSetPowerRestored() {
		//Setup
		Model model = new Model();
		//Method Execution
		boolean test1 = model.isPowerRestored();
		model.setPowerRestored(false);
		boolean test2 = model.isPowerRestored();
		//Verification
		if(test1 != true)
		fail("Is Power Restored should be false but got " + test1);
		if(test2 != false)
		fail("Is Power restored should be true but got " + test2);
	}

	@Test
	public void testSetLifeSupportOn() {
		//Setup
		Model model = new Model();
		//Method Execution
		boolean test1 = model.isLifeSupportOn();
		model.setLifeSupportOn(false);
		boolean test2 = model.isLifeSupportOn();
		//Verification
		if(test1 != true)
		fail("Test1 should have been true but got " + test1);
		if(test2 != false)
		fail("Test2 should have been false but got " + test2);
	}

	@Test
	public void testSetDressed() {
		//Setup
		Model model = new Model();
		//Method Execution
		boolean test1 = model.isDressed();
		model.setDressed(true);
		boolean test2 = model.isDressed();
		//Verification
		if(test1 != false)
		fail("test1 should have been false but got " + test1);
		if(test2 != true)
		fail("Not yet implemented");
	}

	@Test
	public void testSetDamageRepaired() {
		//Setup
		Model model = new Model();
		//Method Execution
		boolean test1 = model.isDamageRepaired();
		model.setDamageRepaired(true);
		boolean test2 = model.isDamageRepaired();
		//Verification
		if(test1 != false)
		fail("test1 should have been false but got " + test1);
		if(test2 != true)
		fail("test2 should have been true but got " + test2);
	}

	@Test
	public void testGetCurrentState() {
		//Setup
		Model model = new Model();
		//Method Execution
		Scenes test1 = model.getCurrentState();
		//Verification
		if(test1 != Scenes.state)
		fail("test1 should have been state but got " + test1);
	}

	@Test
	public void testIsPowerRestored() {
		//Setup
		Model model = new Model();
		//Method Execution
		boolean test1 = model.isPowerRestored();
		//Verification
		if(test1 != true)
		fail("test1 should have been true but got " + test1);
	}

	@Test
	public void testIsLifeSupportOn() {
		//Setup
		Model model = new Model();
		//Method Execution
		boolean test1 = model.isLifeSupportOn();
		//Verification
		if(test1 != true)
		fail("test1 should have been true but got " + test1);
	}

	@Test
	public void testIsDressed() {
		//Setup
		Model model = new Model();
		//Method Execution
		boolean test1 = model.isDressed();
		//Verification
		if(test1 != false)
		fail("test1 should have been false but got " + test1);
	}

	@Test
	public void testIsDamageRepaired() {
		//Setup
		Model model = new Model();
		//Method Execution
		boolean test1 = model.isDamageRepaired();
		//Verification
		if(test1 != false)
		fail("test1 should have been false but got " + test1);
	}

	@Test
	public void testSaveModel() {
		//Setup
		Model model = new Model();
		//Method Execution
		String test1 = model.saveModel();
		//Verification
		if(! test1.equals("state T T F F F"))
		fail("test1 should be state T T F F F but got " + test1);
	}

}
