package g44422.diamond.view;

import java.util.Scanner;
import java.util.Arrays;

import g44422.diamond.controller.Controller;
import g44422.diamond.model.*;

/**
 * General cases of a view.
 *
 * @author 44422
 * @version 0.1
 */
public class View {
	private Model game;
	private Scanner in;

	/**
	 * Creates a new view with a new game.
	 *
	 * @param game The newly generated game.
	 */
	public View(Model game) {
		this.in = new Scanner(System.in);
		this.game = game;
	}

	/**
	 * Creates an new explorer and ask him his nick.
	 *
	 * @return A newly created explorer.
	 */
	public Explorer askExplorer() {
		String answer;
		System.out.println("Entrez un pseudonyme pour cet explorateur:");
		do {
			answer = in.nextLine();
			if (answer.equalsIgnoreCase("")) {
				System.out.println("Le pseudonyme ne peut pas être vide. S'il-vous-plait entrez un pseudonyme.");
			} else if (game.getExplorers().contains(new Explorer(answer))) {
				System.out.println("Un explorateur possède déjà ce pseudonyme. Veuillez en entrer un autre.");
			}
		} while (answer.equalsIgnoreCase("") || game.getExplorers().contains(new Explorer(answer)));
		return new Explorer(answer);
	}

	/**
	 * Asks if there are other explorers to add to the game.
	 *
	 * @return If there are new explorers to add or not.
	 */
	public boolean isThereNewExplorerToAdd() {
		System.out.println("Voulez-vous ajouter un nouvel utilisateur? [ OUI / NON ]");
		return choice();
	}

	/**
	 * Asks the explorer if he wishes to go deeper into the cave.
	 *
	 * @param explorer The explorer that is asked.
	 * @return The explorer's answer.
	 */
	public boolean askExplorerChoiceToContinue(Explorer explorer) {
		System.out.println(explorer.getPseudonym() + ", voulez-vous quitter la grotte? [ OUI / NON ]");
		return choice();
	}

	/**
	 * Loop asking the explorer.
	 *
	 * @return The user's answer in a list of possibilities.
	 */
	private boolean choice() {
		while (true) {
			String answer = in.nextLine();
			switch (answer.toLowerCase()) {
				case "oui":
				case "o":
				case "yes":
				case "y":
					return true;
				case "non":
				case "n":
				case "no":
					return false;
				default:
					System.out.println("Réponse non valide. Entrez une des proposition suivantes : [ OUI / NON ]");
			}
		}
	}

	/**
	 * Displays the last tile discovered by the explorers.
	 */
	public void displayGame() {
		System.out.println("Vous découvrez une tuile avec " + game.getCave().getLastDiscoveredTreasure().getInitNbRubies() + " rubis.");
	}

	/**
	 * Displays an end-message when the game is done, and also shows the winner of the game.
	 */
	public void displayWinner() {
		System.out.println("===========");
		System.out.println("Fin du jeu.");
		System.out.println("Explorateur | Rubis collectés");
		if (game.getWinner().size()>1){
			System.out.println("Les gagnts exequo sont :");
			for (int i=0;i <game.getWinner().size();i++) {
				System.out.println(game.getWinner().get(i).getPseudonym());
			}
			System.out.println("avec "+game.getWinner().get(0).getFortune()+" rubis.");
		} else {
			System.out.println("Le gagnant est :");
			System.out.println(game.getWinner().get(0).getPseudonym()+" avec "+game.getWinner().get(0).getFortune()+" rubis.");
		}
	}
}