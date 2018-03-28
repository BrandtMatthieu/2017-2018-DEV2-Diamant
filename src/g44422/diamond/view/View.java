package g44422.diamond.view;

import java.util.Scanner;
import java.util.Arrays;

import g44422.diamond.model.*;

/**
 * Cas généraux d'une vue
 * @author 44422
 * @version 0.1
 */
public class View {
    
    Scanner in;

	/**
	 * Crée un nouvelle vue avec unbe partie.
	 * @param game nouvelle partie
	 */
	public View(Model game) {
        /* TODO */
        this.in = new Scanner(System.in);;
        this.game = new Game();
    }

	/**
	 * Crée un nouvel explorateur et lui demande son pseudo.
	 * @return l'explorateur nouvellement créé
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
	 * Demande si il doit encore y avoir de nouveaux explorateurs et analyse la réponse.
	 * @return si il y a de nouveaux explorateurs ou non
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
                        System.out.println("R�ponse non valide. Entrez une des proposition suivantes : [ OUI / NON ]");
                }
            }
        }
    }

	/**
	 * Demande à l'explorateur si il souhaite continuer à explorer la grotte.
	 * @param explorer l'explorateur à qui est posé la question
	 * @return la réponse de l'exp^lorateur (oui ou non)
	 */
	public boolean askExplorerChoiceToContinue(Explorer explorer) {
        String expectedResults[] = {"oui", "o", "non", "n"};
        
        System.out.println(explorer.getPseudonym+", voulez-vous quitter la grotte? [ OUI / NON ]");
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
	 * Affiche la ddernière tuile découverte par les explorateurs
	 */
	public void displayGame() {
		System.out.println();
        /* TODO */
    }

	/**
	 * Affiche un message de fin car le jeu est fini, ainsi que le score de chaque explorateur
	 */
	public void displayEnd() {
        System.out.println("Fin du jeu:\n===========\nClassement:");
        for(int i=0;i<explorers.size();i++) {
        	/* TODO */
            System.out.println(explorers.get(i).getPseudonym()+"\t\t"+explorers.get(i).getBag.nbRubies);
        }
    }
}