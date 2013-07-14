/**
 * Document confidentiel. Difusion interdite
 */
package fr.pokerfan.pta.server.manager;

import org.springframework.stereotype.Component;

@Component("dataManager")
public class PTADataManager extends AbstractManager {

	private static final int ID_MANAGER = 4;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer getIdManager() {
		return ID_MANAGER;
	}
}
