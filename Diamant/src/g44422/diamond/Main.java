package g44422.diamond;

import g44422.diamond.controller.Controller;
import g44422.diamond.model.Game;
import g44422.diamond.model.Model;
import g44422.diamond.view.View;

/**
 * Main method that launches the game
 *
 * @author 44422
 */
public class Main {
	public static void main(String args[]) {
		Model game = new Game();
		View view = new View(game);
		Controller controller = new Controller(game, view);
		controller.startGame();
	}
}