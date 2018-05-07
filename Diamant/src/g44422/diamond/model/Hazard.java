package g44422.diamond.model;

import java.util.ArrayList;
import java.util.List;

/**
 * General cases of a hazard tile.
 *
 * @author 44422
 * @version 0.1
 */
public class Hazard implements Tile {

    private HazardType type;

    private boolean explorersEscapeReason;

    /**
     * Returns the type of danger of the tile.
     *
     * @return the type of danger of the tile.
     */
    @Override
    public HazardType getType() {
        return type;
    }

    /**
     * Returns the reason why the explorers escaped.
     *
     * @return The reason why the explorers escaped.
     */
    public boolean isExplorersEscapeReason() {
        return explorersEscapeReason;
    }

    /**
     * Gives a true value to the Hazard tiles.
     */
    public void escape() {
        this.explorersEscapeReason = true;
    }

    /**
     * Doesn't do anything
     *
     * @param explorers The explorers who want to explore the tile.
     */
    @Override
    public void explore(List<Explorer> explorers) {
    }

    /**
     * Doesn't do anyhting on Hazard tiles.
     *
     * @return Doesn't return anything on Hazard tiles (0).
     */
    @Override
    public int getInitNbGems() {
        return 0;
    }

    /**
     * Doesn't do anyhting on Hazard tiles.
     *
     * @return Doesn't return anything on Hazard tiles (0).
     */
    public int getNbRubies() {
        return 0;
    }

    /**
     * Doesn't do anyhting on Hazard tiles.
     *
     * @return Doesn't return anything on Hazard tiles (0).
     */
    @Override
    public List<Gem> getGems() {
        return new ArrayList<Gem>();
    }

    /**
     * Creates a new custom Hazard tile based on the parameter.
     *
     * @param type The type of hazard for the new hazard tile.
     */
    public Hazard(HazardType type) {
        this.type = type;
    }

    /**
     * Doesn't do anyhting on Hazard tiles.
     */
    @Override
    public void restore() {

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

    /**
     * Transfert the rubies left from one tile to another.
     *
     * @param o The treasure to transfer from
     */
    @Override
    public void transferGemsFrom(Treasure o) {

    }

    /**
     * Return s the type of the tile.
     *
     * @return Returns the type of the Hazard tile.
     */
    @Override
    public String toString() {
        return "" + type;
    }
}
