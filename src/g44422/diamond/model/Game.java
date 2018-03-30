package g44422.diamond.model;

import java.util.ArrayList;
import java.util.List;

import static g44422.diamond.model.State.*;

/**
 * Creates a game.
 * @author 44422
 * @version 0.1
 */
public class Game implements Model {

    public List<Explorer> explorers;
    public Cave cave;

	/**
	 * Creates a new game.
	 */
	public Game() {
        this.explorers = new ArrayList<>();
        this.cave = new Cave();
    }

	/**
	 * Adds a new explorer to the current game.
	 * @param explorer The explorer to add to the game.
	 */
	public void addExplorer(Explorer explorer) {
		this.explorers.add(explorer);
    }

	/**
	 * Makes the explorer go forward in the cave.
	 */
	public void moveForward() {
		getCave().discoverNewTreasure(getExploringExplorers());
    }

	/**
	 * Says if the game is finished or not.
	 * @return The game's state.
	 */
	public boolean isOver() {
        return !(getExploringExplorers().size()>0);
    }

	/**
	 * Returns the cave's number the explorers are in.
	 * @return The actual cave's number.
	 */
	public Cave getCave() {
        return cave;
    }

	/**
	 * Makes a list of all the explorers.
	 * @return A list with all the explorers.
	 */
	public List<Explorer> getExplorers() {
        return this.explorers;
    }

	/**
	 * Makes a list of all explorers curerntly exploring.
	 * @return All the exploring explorers.
	 */
	public List<Explorer> getExploringExplorers() {
        List <Explorer> exploringExplorers = new ArrayList<Explorer>();
        for(int i=0;i<getExplorers().size();i++) {
            if(getExplorers().get(i).getState().equals(EXPLORING)) {
                exploringExplorers.add(getExplorers().get(i));
            }
        }
        return exploringExplorers;
    }

	/**
	 * Makes the wishing explorers leave the cave.
	 * @param explorer The explorer who want to leave the cave.
	 * @throws RuntimeException Exception throwed if the explorer isn't in the list with the exploring explorers.
	 */
	public void handleExplorerDecisionToLeave(Explorer explorer) {
		/* ToDo */
        if(getExploringExplorers().contains(explorer)) {
        	/*if(askExplorerChoiceToContinue()) {
				explorer.takeDecisionToLeave();
			}*/
        	explorer.takeDecisionToLeave();
        } else {
            throw new RuntimeException();
        }
    }
}
