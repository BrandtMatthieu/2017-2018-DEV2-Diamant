package g44422.diamond.model;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TileTest {
	@Test
	public void typeIsType() {
		Tile tile = new Hazard(HazardType.SNAKES);
		assertEquals(HazardType.SNAKES, tile.getType());
	}

	@Test
	public void tileHasRubies() {
		Tile tile = new Treasure();
		assertTrue(tile.getGems().size() > 0);
	}

	@Test
	public void tileHasRubiesIsNumber() {
		Tile tile = new Treasure();
		assertEquals(tile.getInitNbGems(), tile.getGems().size());
	}

	@Test
	public void tileIsRestoredPropoerly() {
		Treasure treasure = new Treasure();
		Explorer explorer = new Explorer("44422");
		treasure.explore(Arrays.asList(explorer));
		treasure.restore();
		assertEquals(treasure.getInitNbGems(), treasure.getGems().size());
	}
}
