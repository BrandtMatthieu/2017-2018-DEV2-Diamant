package g44422.diamond.view;

import g44422.diamond.model.Explorer;
import g44422.diamond.model.Hazard;
import g44422.diamond.model.Model;

import java.util.Scanner;

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
		System.out.println("\nVoulez-vous ajouter un nouvel utilisateur? [ OUI / NON ]");
		return choice();
	}

	/**
	 * Asks the explorer if he wishes to go deeper into the cave.
	 *
	 * @param explorer The explorer that is asked.
	 * @return The explorer's answer.
	 */
	public boolean askExplorerChoiceToContinue(Explorer explorer) {
		System.out.println("\n" + explorer.getPseudonym() + ", voulez-vous quitter la grotte? [ OUI / NON ]");
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
		System.out.println("\n");
		if (game.getCave().getCurrentEntrance().getPath().get(game.getCave().getCurrentEntrance().getPath().size() - 1) instanceof Hazard) {
			System.out.println("Pas de chance, vous tombez sur une carte \"Danger\". Le danger est de type " + game.getCave().getCurrentEntrance().getPath().get(game.getCave().getCurrentEntrance().getPath().size() - 1).getType().toString() + ".");
		} else {
			System.out.println("Vous découvrez une tuile avec " + game.getCave().getCurrentEntrance().getLastDiscoveredTile().getInitNbRubies() + " rubis.");
		}
	}

	/**
	 * Displays an end-message when the game is done, and also shows the winner of the game.
	 */
	public void displayWinner() {
		System.out.println("\n");
		System.out.println("Fin du jeu.");
		System.out.println("===========");
		if (game.getWinner().size() > 1) {
			System.out.println("Les gagnts ex æquo sont :");
			for (int i = 0; i < game.getWinner().size() - 1; i++) {
				System.out.print(game.getWinner().get(i).getPseudonym() + ", ");
			}
			System.out.print(game.getWinner().get(game.getWinner().size() - 1).getPseudonym());
			System.out.println(" avec " + game.getWinner().get(0).getFortune() + " rubis.");
		} else {
			System.out.println("Le gagnant est :");
			System.out.println(game.getWinner().get(0).getPseudonym() + " avec " + game.getWinner().get(0).getFortune() + " rubis.");
		}
	}

	/**
	 * Prints the current cave on the screen.
	 * Prints the state of the explorers.
	 * Prints the amount each explorer has.
	 */
	public void turnResumeDisplay() {
		// Top
		System.out.print("        ╔");
		for (int i = 0; i < game.getCave().getCurrentEntrance().getPath().size() + 1; i++) {
			System.out.print("╦═══════════╦");
		}
		System.out.print("\n════════╝");
		for (int i = 0; i < game.getCave().getCurrentEntrance().getPath().size() + 1; i++) {
			System.out.print("║           ║");
		}

		// Middle
		// This is not made to be human-readible
		// This just prints lines and infos about what there is in the cave drawing.
		System.out.print("\n Sortie ");
<<<<<<< Updated upstream:Diamant/src/g44422/diamond/view/View.java
		for (int i = 0; i < game.getCave().getCurrentEntrance().getPath().size() - 1; i++) {
			if (game.getCave().getCurrentEntrance().getPath().get(i) instanceof Hazard) {

=======
		for (int i = 0; i < game.getCave().getCurrentEntrance().getPath().size() - 1; i++) { // For each tile in the path
			if (game.getCave().getCurrentEntrance().getPath().get(i) instanceof Hazard) { // If it is a Hazard
>>>>>>> Stashed changes:src/g44422/diamond/view/View.java
				for (int j = 0; j < (13 - game.getCave().getCurrentEntrance().getPath().get(i).getType().toString().length()) / 2; j++) {
					System.out.print(" "); // Print spaces.
				}
				System.out.print(game.getCave().getCurrentEntrance().getPath().get(i).getType().toString()); // Print the Hazard
				for (int k = 0; k < ((13 - game.getCave().getCurrentEntrance().getPath().get(i).getType().toString().length() / 2) - game.getCave().getCurrentEntrance().getPath().get(i).getType().toString().length()); k++) {
					System.out.print(" "); // Print spaces.
				}
			} else { // If it is a treasure
				System.out.print("   "); // Print spaces.
				if (String.valueOf(game.getCave().getCurrentEntrance().getPath().get(i).getRubies()).length() == 1) {
					System.out.print(" "); // Print space of number shorter than 2 charactres.
				}
				System.out.print(game.getCave().getCurrentEntrance().getPath().get(i).getRubies()); // Prints the amount of rubies.
				System.out.print(" rubis  "); // Prints "rubis".
			}
		}
		if (game.getCave().getCurrentEntrance().getPath().get(game.getCave().getCurrentEntrance().getPath().size() - 1) instanceof Hazard) {

			for (int j = 0; j < (13 - game.getCave().getCurrentEntrance().getPath().get(game.getCave().getCurrentEntrance().getPath().size() - 1).getType().toString().length()) / 2; j++) {
				System.out.print(" ");
			}
			System.out.print(game.getCave().getCurrentEntrance().getPath().get(game.getCave().getCurrentEntrance().getPath().size() - 1).getType().toString());
			for (int k = 0; k < ((13 - game.getCave().getCurrentEntrance().getPath().get(game.getCave().getCurrentEntrance().getPath().size() - 1).getType().toString().length() / 2) - game.getCave().getCurrentEntrance().getPath().get(game.getCave().getCurrentEntrance().getPath().size() - 1).getType().toString().length()); k++) {
				System.out.print(" ");
			}
		} else {
			System.out.print("   ");
			if (String.valueOf(game.getCave().getCurrentEntrance().getPath().get(game.getCave().getCurrentEntrance().getPath().size() - 1).getInitNbRubies()).length() == 1) {
				System.out.print(" ");
			}
			System.out.print(game.getCave().getCurrentEntrance().getPath().get(game.getCave().getCurrentEntrance().getPath().size() - 1).getInitNbRubies());
			System.out.print(" rubis  ");
		}
<<<<<<< Updated upstream:Diamant/src/g44422/diamond/view/View.java
		if (game.getCave().getCurrentEntrance().getPath().get(game.getCave().getCurrentEntrance().getPath().size() - 1) instanceof Hazard) {

			for (int j = 0; j < (13 - game.getCave().getCurrentEntrance().getPath().get(game.getCave().getCurrentEntrance().getPath().size() - 1).getType().toString().length()) / 2; j++) {
				System.out.print(" ");
			}
			System.out.print(game.getCave().getCurrentEntrance().getPath().get(game.getCave().getCurrentEntrance().getPath().size() - 1).getType().toString());
			for (int k = 0; k < ((13 - game.getCave().getCurrentEntrance().getPath().get(game.getCave().getCurrentEntrance().getPath().size() - 1).getType().toString().length() / 2) - game.getCave().getCurrentEntrance().getPath().get(game.getCave().getCurrentEntrance().getPath().size() - 1).getType().toString().length()); k++) {
				System.out.print(" ");
			}
		} else {
			System.out.print("   ");
			if (String.valueOf(game.getCave().getCurrentEntrance().getPath().get(game.getCave().getCurrentEntrance().getPath().size() - 1).getInitNbRubies()).length() == 1) {
				System.out.print(" ");
			}
			System.out.print(game.getCave().getCurrentEntrance().getPath().get(game.getCave().getCurrentEntrance().getPath().size() - 1).getInitNbRubies());
			System.out.print(" rubis  ");
		}
=======
>>>>>>> Stashed changes:src/g44422/diamond/view/View.java

		System.out.print("       ?     ║\n");

		// Bottom
		System.out.print("════════╗");
		for (int i = 0; i < game.getCave().getCurrentEntrance().getPath().size() + 1; i++) {
			if (i == game.getCave().getCurrentEntrance().getPath().size() - 1) {
				System.out.print("║  actuelle ║");
			} else {
				System.out.print("║           ║");
			}
		}
		System.out.print("\n        ╚");
		for (int i = 0; i < game.getCave().getCurrentEntrance().getPath().size() + 1; i++) {
			System.out.print("╩═══════════╩");
		}
		System.out.println("\n");
		System.out.println("Etat  -  Explorateur  -  Nb. Rubis");
		System.out.println("==================================");

		game.getExplorers().forEach((explorer) -> {
			System.out.println(explorer.getState() + "  -  " + explorer.getPseudonym() + "  -  " + explorer.getFortune() + " rubis");
		});
	}

	/**
	 * Displays a friendly message when the explorers have run away.
	 */
	public void displayRunAway() {
		System.out.println("Vous êtes tombé sur une deuxième carte \"Danger\" d'un même type.\nVous fuyez en dehors de la grotte en abandonnant votre butin à l'intérieur.\n\nVous êtes tous de retour au camp.");
	}

<<<<<<< Updated upstream:Diamant/src/g44422/diamond/view/View.java
=======
	/**
	 * Display a friendly message telling the explorers are now exploring a new cave.
	 */
>>>>>>> Stashed changes:src/g44422/diamond/view/View.java
	public void startNewExplorationPhase() {
		System.out.println("\nVous prénétrez dans une nouvelle entrée de la grotte.");
	}
}