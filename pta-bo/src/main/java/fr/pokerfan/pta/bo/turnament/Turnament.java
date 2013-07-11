/*
 * Document confidentiel - Diffusion interdite 
 */
package fr.pokerfan.pta.bo.turnament;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import fr.pokerfan.pta.bo.PTAConstantes;
import fr.pokerfan.pta.bo.Structure;
import fr.pokerfan.pta.bo.player.Player;


/**
 * 
 * Tournoi/SitNGo
 * 
 */
public class Turnament extends Observable{

	/**
	 * id technique
	 */
	private Long id;
	private Long turnamentId;

	private Structure structure;

	private final List<Player> players=new ArrayList<Player>();

	public Turnament() {

	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}



	/**
	 * @return the turnamentId
	 */
	public Long getTurnamentId() {
		return turnamentId;
	}



	/**
	 * @param turnamentId the turnamentId to set
	 */
	public void setTurnamentId(Long turnamentId) {
		this.turnamentId = turnamentId;
	}



	/**
	 * @return the structure
	 */
	public Structure getStructure() {
		return structure;
	}



	/**
	 * @param structure the structure to set
	 */
	public void setStructure(final Structure structure) {
		if(this.structure != null && !this.structure.equals(structure)){
			this.structure = structure;
			//la structure a chang�, on notifie les joueurs
			notifyObservers(PTAConstantes.NOTIFY_CHANGE_STRUCTURE);
		}
	}



	/**
	 * Ajout d'une liste de joueurs
	 * 
	 * @param players
	 * joueurs � ajouter
	 * 
	 */
	public void addPlayers(final List<Player> players){
		this.players.addAll(players);
		for (Player player : players) {
			addObserver(player);
		}
		notifyChangePlayers();
	}



	/**
	 * Ajout d'un joueur
	 * @param player
	 * joueur � ajouter
	 */
	public void addPlayer(final Player player){
		players.add(player);
		addObserver(player);
		notifyChangePlayers();
	}

	/**
	 * Suppression d'un joueur
	 * @param player
	 * joueur � supprimer
	 */
	public void removePlayer(final Player player){
		players.remove(player);	
		deleteObserver(player);
		notifyChangePlayers();
	}

	/**
	 * Suppression de plusieurs joueurs
	 */
	public void removePlayers(final List<Player> players){
		this.players.removeAll(players);
		for (final Player player : players) {
			deleteObserver(player);
		}
		notifyChangePlayers();
	}

	/**
	 * Suppression de tous les joueurs
	 */
	public void clearPlayers(){
		players.clear();
		deleteObservers();
		notifyChangePlayers();
	}

	/**
	 * Le nombre de joueurs � changer, update du aim pour chacun
	 */
	private void notifyChangePlayers() {
		notifyObservers(PTAConstantes.NOTIFY_CHANGE_PLAYERS);
	}


}
