package g44422.diamond.model;

public class Bag {
	private int nbRubies;

	public Bag() {
		this.nbRubies = 0;
	}

	public void addRubies(int nbRubies) {
		this.nbRubies = this.nbRubies + nbRubies;
	}

	public int getNbRubbies() {
		return this.nbRubies;
	}
}
