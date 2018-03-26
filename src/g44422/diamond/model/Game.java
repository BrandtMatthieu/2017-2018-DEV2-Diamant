package g44422.diamond.model;

import java.util.List;

public class Game implements Model {

    public List<Explorer> explorers;
    public Cave cave;

    public Game() {
        this.explorers = null;
        this.cave = null;
    }

    public void addExplorer(Explorer explorer) {
        explorers.add(explorer);
    }

    public void moveForward() {
        /* TODO */
        for (int i = 0; i < explorers.size(); i++) {
            if (explorers.get(i).getState() == EXPLORING) {
                explorers.get(i).
            }
        }
    }
	
    public boolean isOver() {
        /* TODO */
        return false;
    }

    public Cave getCave() {
        /* TODO */
        return
    }

    public List<Explorer> getExplorers() {
        /* TODO */
        return explorers;
    }

    public List<Explorer> getExploringExplorers() {
        List <Explorer> exploringExplorers;
        for(int i=0;i<explorers.size();i++) {
            if(explorer.get(i).state==EXPLORING) {
            exploringExplorers.add(explorers.get(i))}
        }
        return exploringExplorers;
    }

    public void handleExplorerDecisionToLeave(Explorer explorer) {
        if(/* TODO */) {
            explorer.takeDecisionToLeave();
        } else {
            throw new RuntimeException();
        }
        
    }

}
