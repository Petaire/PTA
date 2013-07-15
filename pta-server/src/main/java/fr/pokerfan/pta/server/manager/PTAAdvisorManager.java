/**
 * Document confidentiel. Difusion interdite
 */
package fr.pokerfan.pta.server.manager;

import org.springframework.stereotype.Component;

@Component("advisorManager")
public class PTAAdvisorManager extends AbstractManager {

	private static final int ID_MANAGER = 3;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer getIdManager() {
		return ID_MANAGER;
	}

}
