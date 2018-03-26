package g44422.diamond.model;

import java.util.List;

public interface Model {

    void addExplorer(Explorer explorer);

    void moveForward();

    boolean isOver();

    Cave getCave();

    List<Explorer> getExplorers();

    List<Explorer> getExploringExplorers();

    void handleExplorerDecisionToLeave(Explorer explorer);
}
