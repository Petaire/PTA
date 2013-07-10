/**
 * Document confidentiel. Difusion interdite
 */
package fr.pokerfan.pta.bo;

import java.math.BigDecimal;

/**
 * Bo représentnat la taille du tapis
 * 
 * @author pierre.kerichard
 * 
 */
public class Stack {

	/**
	 * Nombre de jetons
	 */
	private BigDecimal stackSize;

	/**
	 * Nombre de big blinds
	 */
	private Double nbBB;

	/**
	 * Harrigton aim
	 */
	private Double aim;

	/**
	 * @return the stackSize
	 */
	public BigDecimal getStackSize() {
		return stackSize;
	}

	/**
	 * @param stackSize
	 *            the stackSize to set
	 */
	public void setStackSize(final BigDecimal stackSize) {
		this.stackSize = stackSize;
	}

	/**
	 * @return the nbBB
	 */
	public Double getNbBB() {
		return nbBB;
	}

	/**
	 * @param nbBB
	 *            the nbBB to set
	 */
	public void setNbBB(final Double nbBB) {
		this.nbBB = nbBB;
	}

	/**
	 * @return the aim
	 */
	public Double getAim() {
		return aim;
	}

	/**
	 * @param aim
	 *            the aim to set
	 */
	public void setAim(final Double aim) {
		this.aim = aim;
	}

	public void update(final int nbJoueurs, final BigDecimal bigBlind,
			final BigDecimal ante, final BigDecimal stackSize) {
		this.stackSize = stackSize;
		nbBB = stackSize.divide(bigBlind).doubleValue();
		final BigDecimal smallBlind = bigBlind.divide(BigDecimal.valueOf(2L));
		final BigDecimal roundCost = bigBlind.add(smallBlind).add(
				ante.multiply(BigDecimal.valueOf(nbJoueurs)));
		aim = stackSize.divide(roundCost).doubleValue();
	}

}
