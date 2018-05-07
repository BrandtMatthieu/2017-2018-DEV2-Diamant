/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g44422.diamond.model;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author g44422
 */
public class RelicTest {

    /**
     * Test of getValueInDiamonds method, of class Relic.
     */
    @Test
    public void relicInstanceOfRelic() {
        Relic instance = new Relic();
        assertTrue(instance instanceof Relic);
    }

    /**
     * Test of transferGemsFrom method, of class Relic.
     */
    @Test
    public void testTransferGemsFrom() {
        Treasure o = null;
        Relic instance = new Relic();
        instance.transferGemsFrom(o);
    }

    /**
     * Test of explore method, of class Relic.
     */
    @Test
    public void testExplore() {
        List<Explorer> explorers = null;
        Relic instance = new Relic();
        instance.explore(explorers);
    }

    /**
     * Test of getInitNbGems method, of class Relic.
     */
    @Test
    public void testGetInitNbGems() {
        Relic instance = new Relic();
        int expResult = 0;
        int result = instance.getInitNbGems();
        assertEquals(expResult, result);
    }

    /**
     * Test of restore method, of class Relic.
     */
    @Test
    public void testRestore() {
        Relic instance = new Relic();
        instance.restore();
    }

    /**
     * Test of convertGemValue method, of class Relic.
     */
    @Test
    public void testConvertGemValue() {
        int nbTakenRelics = 0;
        Relic instance = new Relic();
        instance.convertGemValue(nbTakenRelics);
    }
    
}
