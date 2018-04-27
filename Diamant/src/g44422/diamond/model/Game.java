package g44422.diamond.model;

import java.util.ArrayList;
import java.util.List;

import static g44422.diamond.model.State.EXPLORING;
import static g44422.diamond.model.State.LEAVING;

/**
 * Creates a game.
 *
 * @author 44422
 * @version 0.1
 */
public class Game implements Model {

	private List<Explorer> explorers;
	private Cave cave;

	/**
	 * Creates a new game.
	 */
	public Game() {
		explorers = new ArrayList<>();
		cave = new Cave();
	}

	/**
	 * Adds a new explorer to the current game.
	 *
	 * @param explorer The explorer to add to the game.
	 * @throws GameException Thrown if it isn't possible to add any new explorer
	 *                       to the game.
	 */
	@Override
	public void addExplorer(Explorer explorer) {
		if (isItPossibleToAddExplorer()) {
			explorers.add(explorer);
		} else {
			throw new GameException("Not possible to add any new explorer to the game.");
		}
	}

	/**
	 * Makes the explorer go forward in the cave.
	 */
	@Override
	public void moveForward() {
		this.getCave().getCurrentEntrance().discoverNewTile(getExploringExplorers());
	}

	/**
	 * Says if the game is finished or not.
	 *
	 * @return The game's state.
	 */
	@Override
	public boolean isExplorationPhaseOver() {
		return getExploringExplorers().isEmpty();
	}

	/**
	 * Returns the cave's number the explorers are in.
	 *
	 * @return The actual cave's number.
	 */
	@Override
	public Cave getCave() {
		return cave;
	}

	/**
	 * Makes a list of all the explorers.
	 *
	 * @return A list with all the explorers.
	 */
	@Override
	public List<Explorer> getExplorers() {
		return explorers;
	}

	/**
	 * Makes a list of all explorers curerntly exploring.
	 *
	 * @return All the exploring explorers.
	 */
	@Override
	public List<Explorer> getExploringExplorers() {
		List<Explorer> exploringExplorers;
		exploringExplorers = new ArrayList<>();
		getExplorers().stream().filter((explorer) -> (explorer.getState().equals(EXPLORING))).forEachOrdered((explorer) -> {
			exploringExplorers.add(explorer);
		});
		return exploringExplorers;
	}

	/**
	 * Makes the wishing explorers leave the cave.
	 *
	 * @param explorer The explorer who want to leave the cave.
	 * @throws GameException Exception thrown if the explorer isn't in the list
	 *                       with the exploring explorers.
	 */
	@Override
	public void handleExplorerDecisionToLeave(Explorer explorer) {
		if (getExploringExplorers().contains(explorer)) {
			explorer.takeDecisionToLeave();
		} else {
			throw new GameException("The explorer " + explorer.toString() + " does not makes part of all the exploring explorers in this game instance.");
		}
	}

	/**
	 * Checks if there are enough explorers.
	 *
	 * @throws GameException Exception thrown if the amount of players is
	 *                       incorrect.
	 */
	@Override
	public void start() {
		if (!(isThereEnoughExplorer() && isItPossibleToAddExplorer())) {
			throw new GameException("Incorrect amount of players.");
		}

	}

	/**
	 * Checks if there is at least 3 explorers.
	 *
	 * @return True if there is at least 3 explorers.
	 */
	@Override
	public boolean isThereEnoughExplorer() {
		return explorers.size() >= 3;
	}

	/**
	 * Checks if it is still possible to add new explorers to the game.
	 *
	 * @return True if it is possible to add new explorers to the game
	 */
	@Override
	public boolean isItPossibleToAddExplorer() {
		return explorers.size() < 8;
	}

	/**
	 * Returns a list with the winner(s) of the game, the players with the most
	 * rubies.
	 *
	 * @return The winner or winner of the game.
	 */
	@Override
	public List<Explorer> getWinner() {
		if (!isExplorationPhaseOver()) {
			throw new GameException("getWinner() Method has been called before the game is over.");
		}
		List<Explorer> winner;
		winner = new ArrayList<>();
		winner.add(explorers.get(0));
		for (int i = 1; i < explorers.size(); i++) {
			if (explorers.get(i).getFortune() > winner.get(0).getFortune()) { // Better score
				winner.clear();
				winner.add(explorers.get(i));
			} else if (explorers.get(i).getFortune() == winner.get(0).getFortune()) { // Ex-equo
				winner.add(explorers.get(i));
			}
		}
		return winner;
	}

	/**
	 * Makes the willing explorers reach the camp and exploring the path in the
	 * cave.
	 */
	@Override
	public void makeExplorersLeave() {
		List<Explorer> leavingExplorers;
		leavingExplorers = new ArrayList<>();
		explorers.stream().filter((explorer) -> (explorer.getState() == LEAVING)).forEachOrdered((explorer) -> {
			leavingExplorers.add(explorer);
		});
		this.cave.getCurrentEntrance().returnToCamp(leavingExplorers);
	}

	/**
	 * Creates a new cave entry an set the explorers to an exploring state.
	 */
	@Override
	public void startNewExplorationPhase() {
		cave.openNewEntrance();
		explorers.forEach((explorer) -> {
			explorer.startExploration();
		});
	}

	/**
	 * Closes the entrance of the current cave entrance and put the tiles from
	 * the path back in the deck.
	 */
	@Override
	public void endExplorationPhase() {
		this.cave.getCurrentEntrance().getPath().stream().filter((tile) -> (tile instanceof Treasure)).forEachOrdered((tile) -> {
			this.cave.getCurrentEntrance().getDeck().putBack(tile);
		});
		this.cave.lockOutCurrentEntrance();
	}

	/**
	 * Tells if the game is finished by checking the current cave entrance and
	 * if there canb be new entrances.
	 *
	 * @return True if the game is over.
	 */
	@Override
	public boolean isOver() {
		return cave.getCurrentEntrance().isLockedOut() && (!cave.hasNewEntranceToExplore());
	}

	/**
	 * Checks if the exporers have left the cave entrance because it's unsafe.
	 *
	 * @return
	 */
	@Override
	public boolean isExplorationPhaseAborted() {
		return cave.isLastEntranceUnsafe();
	}
}
