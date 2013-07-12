/**
 * 
 */
package fr.pokerfan.pta.bo.player;

import java.util.List;

import fr.pokerfan.pta.bo.Hand;

/**
 * Adversaire
 * 
 * @author pierre.kerichard
 *
 */
public class Villain extends Player {
	
	private List<Hand> range;

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isHero() {
		return false;
	}
	
	/**
	 * @return the range
	 */
	public List<Hand> getRange() {
		return range;
	}

	/**
	 * @param range the range to set
	 */
	public void setRange(List<Hand> range) {
		this.range = range;
	}


}
