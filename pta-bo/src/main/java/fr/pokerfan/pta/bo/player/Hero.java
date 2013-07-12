/**
 * 
 */
package fr.pokerfan.pta.bo.player;

import fr.pokerfan.pta.bo.Hand;

/**
 * Ourself !
 * 
 * @author pierre.kerichard
 *
 */
public class Hero extends Player {
	
	private Hand hand;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isHero() {
		return true;
	}

	/**
	 * @return the hand
	 */
	public Hand getHand() {
		return hand;
	}

	/**
	 * @param hand the hand to set
	 */
	public void setHand(final Hand hand) {
		this.hand = hand;
	}

}
