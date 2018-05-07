package g44422.diamond.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a card deck with treasures and dangers.
 *
 * @author 44422
 * @version 0.1
 */
public class Deck {

    private List<Tile> tiles;

    private List<Tile> tileList;

    /**
     * Creates a new deck of cards with pre-selected values.
     */
    public Deck() {
        tiles = new ArrayList<>();
        for (int i = 1; i < 6; i++) { // Adds treasures from 1 to 5
            tiles.add(new Treasure(i));
        }
        for (int i = 5; i < 18; i = i + 2) { // Adds the odd treasures from 5 to 17
            tiles.add(new Treasure(i));
        }
        tiles.add(new Treasure(7));
        tiles.add(new Treasure(11));
        tiles.add(new Treasure(14));
        for (HazardType hazard : HazardType.values()) { // Adds all the Hazards 3 times.
            for (int i = 0; i < 3; i++) {
                tiles.add(new Hazard(hazard));
            }
        }
        for(int i=0;i<5;i++) {
            tiles.add(new Relic());
        }
    }

    /**
     * Returns one of the tiles in the deck and removes it.
     *
     * @return One randome tile of the deck.
     */
    public Tile getTile() {
        Tile toReturn = tiles.get((int) (Math.random() * tiles.size()));
        tiles.remove(toReturn); // remove() doesn't return anything
        return toReturn;
    }

    /**
     * Returns the list of tiles.
     *
     * @return The list of tiles.
     */
    List<Tile> getTileList() {
        return tileList;
    }

    /**
     * Puts the tile back into the deck and restores its initial value.
     *
     * @param tile The tile to put back in the deck.
     */
    public void putBack(Tile tile) {
        tile.restore();
        tiles.add(tile);
    }
}
