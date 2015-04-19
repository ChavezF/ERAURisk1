import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestDiceRoll {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void RandomDiceRollWithinRange() {
		Die d = new Die();
		assertEquals(1 ,d.roll(), 5);
	}
	
	@Test
	public void RandomDiceRollBelowRange() {
		Die d = new Die();
		assertEquals(0 ,d.roll());
	}
	
	@Test
	public void RandomDiceAboveRange() {
		Die d = new Die();
		assertEquals(7 ,d.roll());
	}
	
	@Test
	public void CheckDieGetValueMethod() {
		Die d = new Die();
		d.roll();
		assertEquals(1 ,d.getValue(), 5);
	}
}
