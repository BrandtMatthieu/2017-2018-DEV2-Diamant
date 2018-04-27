package g44422.diamond.model;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CaveTest {

	// WILL FAIL 50% TIME CAUSE OF RANDOM
	// RERUN THE TEST PLEASE
	@Test
	public void discoverNewTreasureSameSharing() {
		Explorer e1 = new Explorer("e1");
		Explorer e2 = new Explorer("e2");
		CaveEntrance caveEntrance = new CaveEntrance(new Cave());
		caveEntrance.discoverNewTile(Arrays.asList(e1, e2));
		assertEquals(e1.getBag(), e2.getBag());
	}

	//CUSTOM TEST
	@Test
	public void nbDiscoveredEntranceWhenGameNotStarted() {
		Game game = new Game();
		assertEquals(0, game.getCave().getNbExploredEntrance());
	}

	@Test
	public void nbDiscoveredEntrance() {
		Game game = new Game();
		game.startNewExplorationPhase();
		assertEquals(1, game.getCave().getNbExploredEntrance());
	}

	@Test
	public void currentEntranceWhenGameNotStartedIsNull() {
		Cave cave = new Cave();
		assertNull(cave.getCurrentEntrance());
	}

	@Test
	public void currentEntranceAfterGameIsStartedIsNotNull() {
		Game game = new Game();
		game.startNewExplorationPhase();
		assertNotNull(game.getCave().getCurrentEntrance());
	}

	@Test
	public void hasNewEntranceToExplore() {
		Cave cave = new Cave();
		assertTrue(cave.hasNewEntranceToExplore());
	}

	@Test
	public void nbExploredEntranceIsCorrect1() {
		Game game = new Game();
		game.startNewExplorationPhase();
		game.endExplorationPhase();
		assertEquals(game.getCave().getNbExploredEntrance(), 1);
	}

	@Test
	public void nbExploredEntranceIsCoorect5() {
		Game game = new Game();
		for (int i = 0; i < 5; i++) {
			game.startNewExplorationPhase();
			game.endExplorationPhase();
		}
		assertEquals(game.getCave().getNbExploredEntrance(), 5);
	}

	@Test
	public void possibleToOpenNewEntrance() {
		Game game = new Game();
		for (int i = 0; i < 3; i++) {
			game.startNewExplorationPhase();
			game.endExplorationPhase();
		}
		assertTrue(game.getCave().hasNewEntranceToExplore());
	}

	@Test
	public void notPossibleToOpenNewEntrance() {
		Game game = new Game();
		for (int i = 0; i < 5; i++) {
			game.startNewExplorationPhase();
			game.endExplorationPhase();
		}
		assertFalse(game.getCave().hasNewEntranceToExplore());
	}
}