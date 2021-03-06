/**
 * Document confidentiel. Difusion interdite
 */
package fr.pokerfan.pta.bo.player;

import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;

import fr.pokerfan.pta.bo.PTAConstantes;
import fr.pokerfan.pta.bo.enums.Room;
import fr.pokerfan.pta.bo.turnament.Turnament;
import fr.pokerfan.pta.utils.PTAUtils;


/**
 * Repr�sentation d'un joueur
 * 
 * @author pierre.kerichard
 * 
 */
public abstract class Player implements Observer{
	
	/**
	 * id technique
	 */
	private Long id;

	/**
	 * nom du joueur
	 */
	private String name;
	
	/**
	 * room
	 */
	private Room room;
	
	/**
	 * tapis
	 */
	private BigDecimal stack;
	
	/**
	 * nombre de big blinds
	 */
	private BigDecimal nbreBB;
	
	/**
	 * Harrington aim
	 */
	private Double aim;
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}


	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}


	/**
	 * @return the stack
	 */
	public BigDecimal getStack() {
		return stack;
	}


	/**
	 * @param stack the stack to set
	 */
	public void setStack(BigDecimal stack) {
		this.stack = stack;
	}

	/**
	 * @return the nbreBB
	 */
	public BigDecimal getNbreBB() {
		return nbreBB;
	}


	/**
	 * @return the aim
	 */
	public Double getAim() {
		return aim;
	}

	/**
	 * Indique si le joueur est un adversaire ou nous m�me
	 */
	public abstract boolean isHero();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(final Observable subject,final Object params) {
		if(subject instanceof Turnament ){
			final Turnament turnament = (Turnament)subject;
			if(PTAConstantes.NOTIFY_CHANGE_STRUCTURE.equals(params)){
				//mise � jour de la strcuture (blinds et antes), on update l'aim et le nbBB
				nbreBB = PTAUtils.calculateNbBlinds(stack, turnament.getStructure().getMontantBlinds());
				aim = PTAUtils.calculateAim(stack, turnament.getStructure().getMontantBlinds(), turnament.getStructure().getMontantAntes(), turnament.countObservers());
			}else if(PTAConstantes.NOTIFY_CHANGE_PLAYERS.equals(params)){
				//l'ajout/suppressioin agit sur le calcule de l'aim
				aim = PTAUtils.calculateAim(stack, turnament.getStructure().getMontantBlinds(), turnament.getStructure().getMontantAntes(), turnament.countObservers());
			}
			
		}
		
	}
	
}
