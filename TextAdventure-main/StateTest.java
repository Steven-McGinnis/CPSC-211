import static org.junit.Assert.*;

import org.junit.Test;

public class StateTest {

	@Test
	public void testGenerateChoices() {
		State state = new State(null);
		int test1 = state.generateChoices(null);
		if(test1 != 0)
		fail("test1 should have been 0 but got" + test1);
	}

	@Test
	public void testProcessChoice() {
		Model model = new Model();
		State state = new State(model);
		state.processChoice(model, 0);
		boolean test1 = model.isPowerRestored();
		boolean test2 = model.isLifeSupportOn();
		if(test1 != false && test2 != false)
		fail("Test 1 and Test 2 should both be false but got " + test1 + " " + test2);
	}
}
