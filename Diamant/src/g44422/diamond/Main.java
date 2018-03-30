package g44422.diamond;

import g44422.diamond.controller.*;
import g44422.diamond.model.*;
import g44422.diamond.view.*;

/**
 * Main method that launches the game
 * @author 44422
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
		Model game = new Game();
		View view = new View(game);
		Controller controller =  new Controller(game, view);
		controller.startGame();
    }
}