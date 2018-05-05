package g44422.diamond.model;

import java.util.List;

public interface Tile {
    void explore(List<Explorer> explorers);

    /**
     * Renvoit The amount of rubies on the tile when it has been created.
     *
     * @return The amount of rubies that stood on the tile when it was created.
     */
    int getInitNbRubies();

    /**
     * Returns the amount of rubies standing on the treasure tile.
     *
     * @return The amount of rubies on the tile.
     */
    int getRubies();

    /**
     * Returns the type of Hazard it is.
     *
     * @return The type of the Hazard.
     */
    HazardType getType();

    /**
     * Restore the original amount of rubies on the tile.
     */
    void restore();
}
