package g44422.diamond.controller;
import g44422.diamond.*;

public class Controller {
    public Controller(Model game, View view) {
        this.game = game;
        this.view = view;
    }
    
    void startGame() {
        /* TODO */
        new Controller();
        int i=0;
        for(;i<3;i++) { // minimum 3 joueurs
            askExplorer();
        }
        while(isThereNewExplorerToAdd && i<8) {
            askExplorer();
        }
        
        while(!isOver()) {
            /* TODO */
        }
        
        displayEnd();
    }
}