package g44422.diamond.model;

/**
 * The different traps of gems in the game.
 *
 * @author 44422
 * @version 0.1
 */
public enum Gem {
    DIAMOND(5),
    RUBY(1);

    final int value;

    /**
     * Creates a new gem with a value given in parameter.
     *
     * @param value The value of the newly created gem.
     */
    Gem(int value) {
        this.value = value;
    }

    /**
     * Returns the value of the gem.
     *
     * @return The value of the gem.
     */
    public int getValue() {
        return value;
    }
}
