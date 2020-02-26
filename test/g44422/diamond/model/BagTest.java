package g44422.diamond.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BagTest {
	@Test
	public void getNbRubiesCaseNoRuby() {
		Bag bag = new Bag();
		assertEquals(0, bag.getValue());
	}

	@Test
	public void addGemsOneTime() {
		Bag bag = new Bag();
		for(int i=0;i<42;i++) {
			bag.addGem(Gem.RUBY);
		}
		assertEquals(42, bag.getValue());
	}

	@Test
	public void addGemsTwoTime() {
		Bag bag = new Bag();
		for(int i=0;i<40;i++) {
			bag.addGem(Gem.RUBY);
		}
		for(int i=0;i<2;i++) {
			bag.addGem(Gem.RUBY);
		}
		assertEquals(42, bag.getValue());
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
		for(int i=0;i<42;i++) {
			bag1.addGem(Gem.RUBY);
		}
		for(int i=0;i<42;i++) {
			bag2.addGem(Gem.RUBY);
		}
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

	//CUSTOM TESTS
	/* Doesn't work anymore due to new Gem methods. Cannot add -1 times 1 ruby.
	@Test
	public void equalsTestTrueAfterAddingNegative() {
		Bag bag1 = new Bag();
		Bag bag2 = new Bag();
		bag1.addGem(-1);
		bag2.addGem(-1);
		assertTrue(bag1.equals(bag2));
	}
	*/
	@Test
	public void isEmptyAfterLoseContent() {
		Bag bag1 = new Bag();
		for(int i=0;i<42;i++) {
			bag1.addGem(Gem.RUBY);
		}
		bag1.loseContent();
		assertEquals(0, bag1.getValue());
	}

	/* Doesn't work anymore due to new Gem methods, cannot add - times ruby to bag.
	@Test
	public void isEmptyAfterLoseNegativeContent() {
		Bag bag1 = new Bag();
		bag1.addGem(-1);
		bag1.loseContent();
		assertEquals(0, bag1.getValue());
	}
	*/
}