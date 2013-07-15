/**
 * Document confidentiel. Difusion interdite
 */
package fr.pokerfan.pta.server.manager;

import org.springframework.stereotype.Component;

@Component("trackerManager")
public class PTATrackerManager extends AbstractManager {

	private static final int ID_MANAGER = 2;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer getIdManager() {
		return ID_MANAGER;
	}

}
