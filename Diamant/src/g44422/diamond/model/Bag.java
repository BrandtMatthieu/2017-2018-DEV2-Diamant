package g44422.diamond.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a bag for each explorer.
 *
 * @author 44422
 * @version 0.1
 */
public class Bag {

    protected List<Gem> gems;

    /**
     * Creates a new empty bag for the player.
     */
    public Bag() {
        this.gems = new ArrayList<Gem>();
    }

    /**
     * Returns the amount of rubies in the explorer's bag.
     *
     * @return The amount of rubies the explorer have.
     */
    public int getValue() {
        int sum = 0;
        for (Gem gem : gems) {
            sum = sum + gem.getValue();
        }
        return sum;
    }

    /**
     * Adds the specified gem to the player's bag.
     *
     * @param gem The gem to add.
     */
    public void addGem(Gem gem) {
        this.gems.add(gem);
    }

    /**
     * Checks if two bags are equals.
     *
     * @param o An object.
     * @return True if the bag isn't empty, is an object and if is equals to
     * itself.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bag bag = (Bag) o;
        return this.getValue() == bag.getValue();
    }

    /**
     * Returns the hashCode of the amount of gems.
     *
     * @return the hashCode of the amount of gems.
     */
    @Override
    public int hashCode() {
        return Objects.hash(gems);
    }

    /**
     * Resets the player's bag when he falls into a trap.
     */
    public void loseContent() {
        this.gems.clear();
    }

}
