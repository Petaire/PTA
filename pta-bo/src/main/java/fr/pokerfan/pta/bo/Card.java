/**
 * Document confidentiel. Difusion interdite
 */
package fr.pokerfan.pta.bo;

import fr.pokerfan.pta.bo.enums.Rank;
import fr.pokerfan.pta.bo.enums.Suit;

/**
 * Bo représentant une carte
 * 
 * @author pierre.kerichard
 * 
 */
public class Card {

	/**
	 * couleur de la carte
	 */
	private Suit suit;

	/**
	 * valeur de la carte
	 */
	private Rank rank;

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(final Suit suit) {
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(final Rank rank) {
		this.rank = rank;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (rank == null ? 0 : rank.hashCode());
		result = prime * result + (suit == null ? 0 : suit.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Card other = (Card) obj;
		if (rank == null) {
			if (other.rank != null) {
				return false;
			}
		} else if (!rank.equals(other.rank)) {
			return false;
		}
		if (suit == null) {
			if (other.suit != null) {
				return false;
			}
		} else if (!suit.equals(other.suit)) {
			return false;
		}
		return true;
	}

}
