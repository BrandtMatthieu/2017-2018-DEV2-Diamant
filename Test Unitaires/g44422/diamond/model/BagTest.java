package g44422.diamond.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BagTest {
	@Test
	public void getNbRubiesCaseNoRuby() {
		Bag bag = new Bag();
		assertEquals(0, bag.getNbRubies());
	}

	@Test
	public void addGemsOneTime() {
		Bag bag = new Bag();
		bag.addRubies(42);
		assertEquals(42, bag.getNbRubies());
	}

	@Test
	public void addGemsTwoTime() {
		Bag bag = new Bag();
		bag.addRubies(40);
		bag.addRubies(2);
		assertEquals(42, bag.getNbRubies());
	}

	@Test
	public void equalsTestTrueAfterInit() {
		Bag bag1 = new Bag();
		Bag bag2 = new Bag();
		assertTrue(bag1.equals(bag2));
	}

	@Test
	public void equalsTestTrueAfterAdding() {
		Bag bag1 = new Bag();
		Bag bag2 = new Bag();
		bag1.addRubies(42);
		bag2.addRubies(42);
		assertTrue(bag1.equals(bag2));
	}

	@Test
	public void equalsFalseOtherObject() {
		Bag bag1 = new Bag();
		String bag2 = "bag2";
		assertFalse(bag1.equals(bag2));
	}

	@Test
	public void equalsFalseNull() {
		Bag bag1 = new Bag();
		assertFalse(bag1.equals(null));
	}
}