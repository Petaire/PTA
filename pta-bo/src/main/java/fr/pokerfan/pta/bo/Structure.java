/**
 * 
 */
package fr.pokerfan.pta.bo;

import java.math.BigDecimal;

/**
 * Classe représentant la structure des blinds
 * 
 * @author pierre.kerichard
 *
 */
public class Structure {

	private BigDecimal montantBlinds;
	private BigDecimal montantAntes;
	
	/**
	 * @return the montantBlinds
	 */
	public BigDecimal getMontantBlinds() {
		return montantBlinds;
	}
	/**
	 * @param montantBlinds the montantBlinds to set
	 */
	public void setMontantBlinds(final BigDecimal montantBlinds) {
		this.montantBlinds = montantBlinds;
	}
	/**
	 * @return the montantAntes
	 */
	public BigDecimal getMontantAntes() {
		return montantAntes;
	}
	/**
	 * @param montantAntes the montantAntes to set
	 */
	public void setMontantAntes(final BigDecimal montantAntes) {
		this.montantAntes = montantAntes;
	}
	
	
}
