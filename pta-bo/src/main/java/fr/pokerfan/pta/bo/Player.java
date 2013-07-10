/**
 * Document confidentiel. Difusion interdite
 */
package fr.pokerfan.pta.bo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import fr.pokerfan.pta.bo.enums.Position;
import fr.pokerfan.pta.bo.enums.Room;

/**
 * Représentation d'un joueur
 * 
 * @author pierre.kerichard
 * 
 */
public class Player {

	/**
	 * id technique
	 */
	private Long id;

	/**
	 * Nom du joueur (pseudo)
	 */
	private String name;

	/**
	 * room de poker
	 */
	private Room room;

	/**
	 * main
	 */
	private Hand hand;

	/**
	 * Statistiques
	 */
	private Stats stats;

	/**
	 * range de mains
	 */
	private List<Hand> range;

	/**
	 * nous!
	 */
	private boolean hero;

	/**
	 * Position sur la table
	 */
	private Position position;

	/**
	 * Nombre de jetons
	 */
	private Stack stack;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * @param room
	 *            the room to set
	 */
	public void setRoom(final Room room) {
		this.room = room;
	}

	/**
	 * @return the hand
	 */
	public Hand getHand() {
		return hand;
	}

	/**
	 * @param hand
	 *            the hand to set
	 */
	public void setHand(final Hand hand) {
		this.hand = hand;
	}

	/**
	 * @return the stats
	 */
	public Stats getStats() {
		return stats;
	}

	/**
	 * @param stats
	 *            the stats to set
	 */
	public void setStats(final Stats stats) {
		this.stats = stats;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * @return the range
	 */
	public List<Hand> getRange() {
		if (range == null) {
			range = new ArrayList<Hand>();
		}
		return range;
	}

	/**
	 * @param range
	 *            the range to set
	 */
	public void setRange(final List<Hand> range) {
		this.range = range;
	}

	/**
	 * @return the hero
	 */
	public boolean isHero() {
		return hero;
	}

	/**
	 * @param hero
	 *            the hero to set
	 */
	public void setHero(final boolean hero) {
		this.hero = hero;
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(final Position position) {
		this.position = position;
	}

	/**
	 * @return the stack
	 */
	public Stack getStack() {
		return stack;
	}

	/**
	 * @param stack
	 *            the stack to set
	 */
	public void setStack(final Stack stack) {
		this.stack = stack;
	}

	/**
	 * Mise à jour de la stack de jetons du joueur.
	 * 
	 * @param nbJoueurs
	 *            nombre de joueur
	 * @param bigBlind
	 *            montant de la bigBlind
	 * @param ante
	 *            montant des antes
	 */
	public void majStack(final int nbJoueurs, final BigDecimal bigBlind,
			final BigDecimal ante) {
		stack.update(nbJoueurs, bigBlind, ante, stack.getStackSize());
	}

	/**
	 * Mise à jour de la stack du joueur
	 * 
	 * @param nbJetons
	 *            nombre de jetons
	 */
	public void majStack(final BigDecimal nbJetons) {
//stack.update(nbJoueurs, bigBlind, ante, stackSize)
	}
}
