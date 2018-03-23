package g44422.diamond.model;
import java.util.List;

public class Treasure {
	private int rubies;
	public int getRubies() {
		return this.rubies;
	}

	private final int initNbRubies;
	public int getInitNbRubies() {
		return this.initNbRubies;
	}

	public Treasure(int rubies) {
		this.rubies = rubies;
		this.initNbRubies = rubies;
	}

	public Treasure() {
		int random = (int) Math.round((Math.random()*14)+1);
		this.rubies = random;
		this.initNbRubies = random;
	}

	public void explore(List <Explorer> explorers) {
		for(Explorer explorer : explorers) {
			explorer.addToBag(this.rubies/explorers.size());
		}
		this.rubies = this.rubies%explorers.size();
	}
}
