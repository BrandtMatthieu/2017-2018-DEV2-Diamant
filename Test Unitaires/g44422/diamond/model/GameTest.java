package g44422.diamond.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void addAndGetExplorerGoodNumberOfExplorers() {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        Explorer e2 = new Explorer("mcd");

        game.addExplorer(e1);
        game.addExplorer(e2);

        assertEquals(2, game.getExplorers().size());
    }

    @Test
    public void addAndGetExplorerGoodExplorers() {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        Explorer e2 = new Explorer("mcd");

        game.addExplorer(e1);
        game.addExplorer(e2);

        /*
         * If this test is false, check if you implement the
         * Explorer's equals method...
         */
        assertTrue(game.getExplorers().contains(e1) &&
            game.getExplorers().contains(e2));
    }

    @Test
    public void treatChoiceToLeave() {
        Game game = new Game();
        Explorer e1 = new Explorer("pbt");
        game.addExplorer(e1);
        game.handleExplorerDecisionToLeave(e1);
        assertTrue(e1.getState() == State.LEAVING);
    }

    @Test(expected = RuntimeException.class)
    public void treatChoiceToLeaveException() {
        Game game = new Game();
        Explorer e1 = new Explorer("pbt");
        game.handleExplorerDecisionToLeave(e1);
    }

    @Test
    public void moveForwardExploringExplorerGetRubies() {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        Explorer e2 = new Explorer("pbt");
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.handleExplorerDecisionToLeave(e1);
        game.moveForward();
        assertTrue(e2.getBag().getNbRubies() > 0);
    }

    @Test
    public void moveForwardLeavingExplorerDoNotGetRubies() {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        Explorer e2 = new Explorer("pbt");
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.handleExplorerDecisionToLeave(e1);
        game.moveForward();
        assertTrue(e1.getBag().getNbRubies() == 0);
    }

    @Test
    public void isOverNoExplorers() {
        Game game = new Game();
        assertTrue(game.isOver());
    }

    @Test
    public void isOverExploringExplorer() {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        game.addExplorer(e1);
        assertFalse(game.isOver());
    }

    @Test
    public void isOverExplorerIsLeaving() {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        game.addExplorer(e1);
        game.handleExplorerDecisionToLeave(e1);
        assertTrue(game.isOver());
    }

    @Test
    public void getExploringExplorers() {
        Game game = new Game();
        Explorer e1 = new Explorer("pbt");
        Explorer e2 = new Explorer("sdr");
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.handleExplorerDecisionToLeave(e1);
        List<Explorer> exploringExplorers = game.getExploringExplorers();
        assertTrue(exploringExplorers.size() == 1
                && exploringExplorers.contains(e2));
    }
}