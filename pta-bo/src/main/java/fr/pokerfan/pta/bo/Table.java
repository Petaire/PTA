/**
 * Document confidentiel. Difusion interdite
 */
package fr.pokerfan.pta.bo;

import java.math.BigDecimal;
import java.util.List;

import fr.pokerfan.pta.bo.enums.Round;

/**
 * Représentation d'une table de poker
 * 
 */
public class Table {

	private List<Player> players;
	private Round round;
	private List<Card> board;
	private BigDecimal potSize;
	private BigDecimal bigBlind;
	private BigDecimal antes;

	/**
	 * @return the players
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * @param players
	 *            the players to set
	 */
	public void setPlayers(final List<Player> players) {
		this.players = players;
	}

	/**
	 * Ajout d'un joueur à la table
	 * 
	 * @param player
	 */
	public void addPlayer(final Player player) {
		players.add(player);
	}

	/**
	 * Suppression d'un joueur de la table
	 * 
	 * @param player
	 */
	public void removePlayer(final Player player) {
		players.remove(player);
	}

	/**
	 * Vide la liste des joueurs
	 */
	public void clearPlayers() {
		players.clear();
	}

	/**
	 * @return the round
	 */
	public Round getRound() {
		return round;
	}

	/**
	 * @param round
	 *            the round to set
	 */
	public void setRound(final Round round) {
		this.round = round;
	}

	/**
	 * @return the board
	 */
	public List<Card> getBoard() {
		return board;
	}

	/**
	 * @param board
	 *            the board to set
	 */
	public void setBoard(final List<Card> board) {
		this.board = board;
	}

	/**
	 * @return the potSize
	 */
	public BigDecimal getPotSize() {
		return potSize;
	}

	/**
	 * @param potSize
	 *            the potSize to set
	 */
	public void setPotSize(final BigDecimal potSize) {
		this.potSize = potSize;
	}

	/**
	 * @return the bigBlind
	 */
	public BigDecimal getBigBlind() {
		return bigBlind;
	}

	/**
	 * @param bigBlind
	 *            the bigBlind to set
	 */
	public void setBigBlind(final BigDecimal bigBlind) {
		this.bigBlind = bigBlind;
	}

	/**
	 * @return the antes
	 */
	public BigDecimal getAntes() {
		return antes;
	}

	/**
	 * @param antes
	 *            the antes to set
	 */
	public void setAntes(final BigDecimal antes) {
		this.antes = antes;
	}

	/**
	 * Retourne le nombre de joueurs
	 * 
	 * @return le nb de joueurs
	 */
	public int getNbJoueurs() {
		return players.size();
	}

	public void majStructure(final BigDecimal bigBlind, final BigDecimal ante) {
		this.bigBlind = bigBlind;
		antes = ante;
		for (final Player player : players) {

		}
	}
}
