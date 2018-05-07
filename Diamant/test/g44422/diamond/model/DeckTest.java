package g44422.diamond.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

	///CUSTOM TESTS
	@Test
	public void newDeckIsNotNull() {
		Deck deck = new Deck();
		assertNotNull(deck);
	}

	@Test
	public void newDeckGivesTiles() {
		Deck deck = new Deck();
		assertTrue(deck.getTile() instanceof Tile);
	}

	@Test
	public void getTileAndPutBack() {
		Deck deck = new Deck();
		Deck deck2 = deck;
		Tile getTile = deck.getTile();
		deck.putBack(getTile);
		assertEquals(deck2, deck);
	}
}
