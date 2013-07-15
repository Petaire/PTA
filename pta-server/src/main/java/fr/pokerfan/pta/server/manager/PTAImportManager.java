/**
 * 
 */
package fr.pokerfan.pta.server.manager;

import org.springframework.stereotype.Component;

/**
 * @author pierre.kerichard
 * 
 */
@Component("importManager")
public class PTAImportManager extends AbstractManager {

	private static final int ID_MANAGER = 1;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer getIdManager() {
		return ID_MANAGER;
	}

}
