package g44422.diamond.view;

import java.util.Scanner;
import java.util.Arrays;

import g44422.diamond.*;

public class View {
    
    Scanner in = new Scanner(System.in);
    
    public View(Model game) {
        /* TODO */
        this.in;
        this.game = new Game();
    }
    
    public Explorer askExplorer() {
        String answer = "";
        System.out.println("Entrez un pseudonyme pour cet exploratreur:");
        while(in.nextLine().equalsIgnoreCase("")) {
            System.out.println("Le pseudonyme ne peut pas �tre vide");
            answer = in.nextLine();
        }
        return new Explorer(answer);
    }
    
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
                        System.out.println("R�ponse non valide. Entrez une des proposition suivantes : [ OUI / NON ]");
                }
            }
        }
    }
    
    public void displayGame() {
        /* TODO */
    }
    
    public void displayEnd() {
        System.out.println("Fin du jeu:\n===========\nClassement:");
        for(int i=0;i<explorers.size();i++) {
            System.out.println(explorers.get(i).getPseudonym()+"\t\t"+explorers.get(i).getBag.nbRubies);
        }
    }
}