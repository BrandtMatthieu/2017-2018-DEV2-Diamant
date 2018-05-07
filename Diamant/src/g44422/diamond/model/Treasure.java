package g44422.diamond.model;

import java.util.ArrayList;
import java.util.List;

/**
 * General cases of a treasure tile.
 *
 * @author 44422
 * @version 0.1
 */
public class Treasure implements Tile {

    private List<Gem> gems;

    private final int initNbGems;

    /**
     * Creates a new treasure tile with a defined number.
     *
     * @param rubies The number of rubies on the newly-genereated tile.
     */
    public Treasure(int rubies) {
        gems = new ArrayList<Gem>();
        for (int i = 0; i < rubies; i++) {
            this.gems.add(Gem.RUBY);
        }
        this.initNbGems = rubies;
    }

    /**
     * Creates a treasure tile with a random amount of rubies, between 1 and 15.
     */
    public Treasure() {
        gems = new ArrayList<Gem>();
        int random = (int) (Math.random() * 14) + 1;
        for (int i = 0; i < random; i++) {
            this.gems.add(Gem.RUBY);
        }
        this.initNbGems = random;
    }

    /**
     * Returns the amount of rubies standing on the treasure tile.
     *
     * @return The amount of rubies on the tile.
     */
    public List<Gem> getGems() {
        return this.gems;
    }

    /**
     * Renvoit The amount of rubies on the tile when it has been created.
     *
     * @return The amount of rubies that stood on the tile when it was created.
     */
    @Override
    public int getInitNbGems() {
        return this.initNbGems;
    }


    /**
     * Makes the explorers explore the tile and share the rubies.
     *
     * @param explorers All the explorers who wanna explore the tile.
     */
    @Override
    public void explore(List<Explorer> explorers) {
        if (!explorers.isEmpty()) {
            int rubiesToShare = Math.floorDiv(this.gems.size(), explorers.size());
            explorers.forEach((explorer) -> {
                for(int i=0;i<rubiesToShare;i++) {
                    explorer.addToBag(Gem.RUBY);
                }
            });
            for (int i = 0; i < rubiesToShare * explorers.size(); i++) {
                this.gems.remove(0);
            }
        }
    }

    /**
     * Doesn't do anything for the Treasure class. Only valid for the Hazard class.
     *
     * @return Retruns null.
     */
    public HazardType getType() {
        return null;
    }

    /**
     * Restore the original amount of rubies on the tile.
     */
    @Override
    public void restore() {
        this.gems.clear();
        for (int i = 0; i < this.initNbGems; i++) {
            this.gems.add(Gem.RUBY);
        }
    }

    /**
     * Returns true if the relic can be taken by the explorer.
     *
     * @param explorers The explorers exploring the relic.
     * @return True if the explorer is alone and leaving.
     */
    @Override
    public boolean canBeTaken(List<Explorer> explorers) {
        return false;
    }

    @Override
    public void transferGemsFrom(Treasure o) {
        for(Gem gem : o.getGems()) {
            this.gems.add(gem);
        }
        o.gems.clear();
    }
}
