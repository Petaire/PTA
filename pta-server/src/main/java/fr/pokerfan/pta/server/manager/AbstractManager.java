package fr.pokerfan.pta.server.manager;

public abstract class AbstractManager implements Manager {

	/**
	 * Constructeur
	 * 
	 * @param input
	 *            donn�es
	 */
	public AbstractManager() {
	}

	public String process(final String[] input) {
		return getIdManager().toString();
	}

}
