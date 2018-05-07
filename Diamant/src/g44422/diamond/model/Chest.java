package g44422.diamond.model;

public class Chest extends Bag {

    /**
     * Creates a new empty chest for the player.
     */
    public Chest() {
        new Bag();
    }

    /**
     * Transfers the gems for the bag to the chest.
     *
     * @param bag The bag to transfer from.
     */
    public void saveBag(Bag bag) {
        for (Gem gem : bag.gems) {
            this.gems.add(gem);
        }
        bag.gems.clear();
    }
}
