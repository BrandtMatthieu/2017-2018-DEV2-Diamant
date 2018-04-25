package g44422.diamond.model;

import java.util.List;

/**
 * Represents a card deck with treasures and dangers.
 *
 * @author 44422
 * @version 0.1
 */
public class Deck {

	private List<Treasure> tiles;

	/**
	 * Creates a new deck of cards with pre-selected values.
	 */
	public Deck() {
		for (int i = 1; i < 6; i++) {
			tiles.add(new Treasure(i));
		}
		for (int i = 5; i < 18; i = i + 2) {
			tiles.add(new Treasure(i));
			if (i == 7 || i == 11) {
				tiles.add(new Treasure(i));
			} else if (i == 13) {
				tiles.add(new Treasure(14));
			}
		}
	}

	/**
	 * Returns one of the tiles in the deck and removes it.
	 *
	 * @return One randome tile of the deck.
	 */
	public Treasure getTreasure() {
		Treasure toReturn = tiles.get(Math.round((int) Math.random() * (tiles.size() - 1)));
		tiles.remove(toReturn);
		return toReturn;
	}

	/**
	 * Puts the tile back into the deck and restores its initial value.
	 *
	 * @param treasure The treasure to put back in the deck.
	 */
	public void putBack(Treasure treasure) {
		treasure.restore();
		tiles.add(treasure);
	}
}
