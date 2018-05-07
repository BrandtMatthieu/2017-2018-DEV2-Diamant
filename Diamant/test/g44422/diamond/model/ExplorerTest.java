package g44422.diamond.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExplorerTest {

	@Test
	public void getPseudonyme() {
		Explorer explorer = new Explorer("Sdr");
		assertEquals("Sdr", explorer.getPseudonym());
	}

	@Test
	public void getStateBeforeTakeDecisionToLeave() {
		Explorer explorer = new Explorer("Sdr");
		assertEquals(State.EXPLORING, explorer.getState());
	}

	@Test
	public void getStateAftertakeDecisionToLeave() {
		Explorer explorer = new Explorer("Sdr");
		explorer.takeDecisionToLeave();
		assertEquals(State.LEAVING, explorer.getState());
	}

	@Test
	public void getBagBeforAddingToBag() {
		Explorer explorer = new Explorer("Sdr");
		assertEquals(0, explorer.getBag().getValue());
	}

	@Test
	public void addToBag1Times() {
		Explorer explorer = new Explorer("Sdr");
		for(int i=0;i<42;i++) {
			explorer.addToBag(Gem.RUBY);
		}
		assertEquals(42, explorer.getBag().getValue());
	}

	@Test
	public void addToBag2Times() {
		Explorer explorer = new Explorer("Sdr");
		for(int i=0;i<40;i++) {
			explorer.addToBag(Gem.RUBY);
		}
		for(int i=0;i<2;i++) {
			explorer.addToBag(Gem.RUBY);
		}
		assertEquals(42, explorer.getBag().getValue());
	}

	@Test
	public void equalsTrue() {
		Explorer e1 = new Explorer("mcd");
		Explorer e2 = new Explorer("mcd");
		assertTrue(e1.equals(e2));
	}

	@Test
	public void equalsFalseDifferent() {
		Explorer e1 = new Explorer("mcd");
		Explorer e2 = new Explorer("pbt");
		assertFalse(e1.equals(e2));
	}

	@Test
	public void equalsFalseOtherObject() {
		Explorer e1 = new Explorer("mcd");
		String e2 = "mcd";
		assertFalse(e1.equals(e2));
	}

	@Test
	public void equalsFalseNull() {
		Explorer e1 = new Explorer("mcd");
		assertFalse(e1.equals(null));
	}

	//CUSTOM TESTS
	@Test
	public void getFortuneEqualsGetBagGetNbRubiesWithEmptyBag() {
		Explorer explorer = new Explorer("44422");
		assertEquals(explorer.getBag().getValue(), explorer.getFortune());
	}

        /*
        Test can't work anymore since bag and fortune are two different things.
	@Test
	public void getFortuneEqualsGetBagGetNbRubiesWithFullBag() {
		Explorer explorer = new Explorer("44422");
		for(int i=0;i<42;i++) {
			explorer.addToBag(Gem.RUBY);
		}
		assertEquals(explorer.getBag().getValue(), explorer.getFortune());
	}
        */
        
        public void fortuneEqualsToBagBeforesaving() {
		Explorer explorer = new Explorer("44422");
		for(int i=0;i<42;i++) {
			explorer.addToBag(Gem.RUBY);
		}
                explorer.chest.saveBag(explorer.getBag());
		assertEquals(explorer.getFortune(), 42);
	}
        
        public void bagEmptyAfterSave() {
		Explorer explorer = new Explorer("44422");
		for(int i=0;i<42;i++) {
			explorer.addToBag(Gem.RUBY);
		}
                explorer.chest.saveBag(explorer.getBag());
		assertEquals(explorer.getBag().getValue(), 0);
	}
}