package g44422.diamond.model;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CaveTest {

    @Test
    public void discoverNewTreasureSameSharing() {
        Explorer e1 = new Explorer("e1");
        Explorer e2 = new Explorer("e2");
        Cave cave = new Cave();
        cave.discoverNewTreasure(Arrays.asList(e1, e2));
        assertTrue(e1.getBag().equals(e2.getBag()));
    }
}