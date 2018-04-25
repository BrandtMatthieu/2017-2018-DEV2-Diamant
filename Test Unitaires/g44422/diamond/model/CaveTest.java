package g44422.diamond.model;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CaveTest {

	@Test
	public void discoverNewTreasureSameSharing() {
		Explorer e1 = new Explorer("e1");
		Explorer e2 = new Explorer("e2");
		CaveEntrance caveEntrance = new CaveEntrance();
		caveEntrance.discoverNewTreasure(Arrays.asList(e1, e2));
		assertEquals(e1.getBag(), e2.getBag());
	}
}