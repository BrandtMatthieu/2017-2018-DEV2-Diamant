package g44422.diamond.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CaveEntranceTest {

	//CUSTOM TESTS
	@Test
	public void pathEquals0WithoutAddingTile() {
		CaveEntrance caveEntrance = new CaveEntrance(new Cave());
		assertEquals(0, caveEntrance.getPath().size());
	}

	@Test
	public void pathLongerThan0AfterAddingTile() {
		CaveEntrance caveEntrance = new CaveEntrance(new Cave());
		caveEntrance.addTileToPath(new Treasure());
		assertTrue(caveEntrance.getPath().size() > 0);
	}

	/*
	@Test
	public void deckIsNullInCaveWhenNotInitializedProperly() {
		CaveEntrance caveEntrance = new CaveEntrance();
		assertNull(caveEntrance.getCave().getDeck());
	}
	*/

	@Test
	public void isLockedAfterLocking() {
		Game game = new Game();
		game.startNewExplorationPhase();
		game.getCave().getCurrentEntrance().lockOut();
		assertTrue(game.getCave().getCurrentEntrance().isLockedOut());
	}

	@Test
	public void isNotLocked() {
		Game game = new Game();
		game.startNewExplorationPhase();
		assertFalse(game.getCave().getCurrentEntrance().isLockedOut());
	}

	@Test
	public void isNotUnsafeAfterCreatingCave() {
		Game game = new Game();
		game.startNewExplorationPhase();
		assertFalse(game.getCave().getCurrentEntrance().isUnsafe());
	}

	/*
	// IMPOSSIBLE TO CHECK SINCE CAVEENTRANCE IS UNSAFE WHEN EXPLORERS MOVE FORWARD
	// BUT THEN THE ADDED TILE IS RANDOM
	@Test
	public void isUnsafeAfterAddingTrap() {
		Game game = new Game();
		game.startNewExplorationPhase();
		game.getCave().getCurrentEntrance().addTileToPath((Tile) new Hazard(HazardType.SNAKES));
		game.getCave().getCurrentEntrance().addTileToPath(new Hazard(HazardType.SNAKES));
		assertTrue(game.getCave().getCurrentEntrance().isUnsafe());
	}
	*/

	@Test
	public void caveInParameterIsCaveEntranceCave() {
		Cave cave = new Cave();
		CaveEntrance caveEntrance = new CaveEntrance(cave);
		assertEquals(cave, caveEntrance.getCave());
	}
}
