package g44422.diamond.view;

import java.util.Scanner;
import java.util.Arrays;

import g44422.diamond.controller.Controller;
import g44422.diamond.model.*;

/**
 * General cases of a view.
 * @author 44422
 * @version 0.1
 */
public class View {
    Game game;
    Scanner in;

	/**
	 * Creates a new view with a new game.
	 * @param game The newly generated game.
	 */
	public View(Model game) {
        this.in = new Scanner(System.in);;
        this.game = new Game();
    }

	/**
	 * Creates an new explorer and ask him his nick.
 * @return A newly created explorer.
	 */
	public Explorer askExplorer() {
        String answer = "";
        System.out.println("Entrez un pseudonyme pour cet exploratreur:");
        while(in.nextLine().equalsIgnoreCase("")) {
            System.out.println("Le pseudonyme ne peut pas être vide");
            answer = in.nextLine();
        }
        return new Explorer(answer);
    }

	/**
	 * Asks if there are other explorers to add to the game.
	 * @return If there are new explorers to add or not.
	 */
	public boolean isThereNewExplorerToAdd() {
        System.out.println("Voulez-vous ajouter un nouvel utilisateur? [ OUI / NON ]");
        String expectedResults[] = {"oui", "o", "non", "n"};
		ask:
		while(true) {
			String answer = in.nextLine();
			if(Arrays.asList(expectedResults).contains(answer.toLowerCase())) {
				switch(answer) {
					case "oui":
					case "o":
						return true;
					case "non":
					case "n":
						return false;
					default:
						System.out.println("Réponse non valide. Entrez une des proposition suivantes : [ OUI / NON ]");
				}
			}
		}
    }

	/**
	 * Asks the explorer if he wishes to go deeper into the cave.
	 * @param explorer The explorer that is asked.
	 * @return The explorer's answer.
	 */
	public boolean askExplorerChoiceToContinue(Explorer explorer) {
        String expectedResults[] = {"oui", "o", "non", "n"};
        
        System.out.println(explorer.getPseudonym()+", voulez-vous quitter la grotte? [ OUI / NON ]");
        ask:
        while(true) {
            String answer = in.nextLine();
            if(Arrays.asList(expectedResults).contains(answer.toLowerCase())) {
                switch(answer) {
                    case "oui":
                    case "o":
                        explorer.takeDecisionToLeave();
                        return true;
                    case "non":
                    case "n":
                        return false;
                    default:
                        System.out.println("Réponse non valide. Entrez une des proposition suivantes : [ OUI / NON ]");
                }
            }
        }
    }

	/**
	 * Displays the last tile discovered by the explorers.
	 */
	public void displayGame() {
		/*
		TODO
		System.out.println(getLastDiscoveredTreasure());
		*/
    }

	/**
	 * Displays an end-message when the game is done, and also shows for each explorer it's score.
	 */
	public void displayEnd() {
        System.out.println("Fin du jeu:\n===========\nClassement:");
        for(int i=0;i<game.getExplorers().size();i++) {
            System.out.println(game.getExplorers().get(i).getPseudonym()+"\t\t"+game.getExplorers().get(i).getBag().getNbRubies());
        }
    }
}