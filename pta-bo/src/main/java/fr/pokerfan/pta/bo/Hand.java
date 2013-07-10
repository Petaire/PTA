/**
 * Document confidentiel. Difusion interdite
 */
package fr.pokerfan.pta.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant une main de poker holdem
 * 
 * @author pierre.kerichard
 * 
 */
public class Hand {

	private List<Card> main;

	/**
	 * @return the main
	 */
	public List<Card> getMain() {
		if (main == null) {
			main = new ArrayList<Card>(2);
		}
		return main;
	}

	/**
	 * @param main
	 *            the main to set
	 */
	public void setMain(final List<Card> main) {
		this.main = main;
	}

}
