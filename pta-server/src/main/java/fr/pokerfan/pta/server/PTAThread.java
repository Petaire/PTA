/*
 * Document confidentiel - Diffusion interdite 
 */
package fr.pokerfan.pta.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.commons.logging.impl.Log4JLogger;

import com.sun.org.apache.xerces.internal.impl.PropertyManager;
import com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl;

/**
 * 1 Thread = 1 connection
 * 
 * @author pierre.kerichard
 * 
 */
public class PTAThread implements Runnable {

	private static final Log4JLogger LOGGER = new Log4JLogger(
			PTAThread.class.getCanonicalName());

	private Socket socket;

	public PTAThread(final Socket socket) {
		this.socket = socket;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		PTAThread.LOGGER.debug("Démarrage du thread");
		try {
			final BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			StringBuffer buffer = new StringBuffer();
			PropertyManager props = new PropertyManager(
					PropertyManager.CONTEXT_READER);
			XMLStreamReader xmlReader;
			while (true) {
				if (socket.getInputStream().available() > 1) {
					xmlReader = new XMLStreamReaderImpl(
							socket.getInputStream(), props);
					break;
				}

			}
			if (xmlReader != null) {
				while (xmlReader.hasNext()) {
					switch (xmlReader.getEventType()) {
					case XMLStreamReader.START_DOCUMENT:
						LOGGER.info("Start of document : "
								+ xmlReader.getVersion());
						break;
					case XMLStreamReader.START_ELEMENT:
						LOGGER.info("Start element : " + xmlReader.getName());
						break;
					case XMLStreamReader.END_ELEMENT:
						LOGGER.info("End element : " + xmlReader.getName());
						break;
					case XMLStreamReader.CHARACTERS:
						LOGGER.info("Characters : " + xmlReader.getText());
						break;
					default:
						LOGGER.info("Default : " + xmlReader.getEventType());
						break;
					}
					xmlReader.next();
				}

				LOGGER.info("End of document");
				xmlReader.close();
				LOGGER.info("Fermeture de l'input stream");
				socket.getInputStream().close();

			}

			// while (true) {
			// final String line = reader.readLine();
			// if (PTAConstantes.END_OF_FILE.equals(line)) {
			// // le fichier est parsé
			// LOGGER.info("Fin de la récupération. Réinitialisation du buffer.");
			// System.out.println(buffer.toString());
			//
			// buffer = new StringBuffer();
			// } else {
			// buffer.append(line);
			// }
			// }

		} catch (final IOException e) {
			PTAThread.LOGGER.warn("Déconnection du client");

		} catch (XMLStreamException e) {
			PTAThread.LOGGER.error("Erreur lors de la création du Xml reader ",
					e);
		} finally {
			try {
				LOGGER.debug("Déconnection du socket");
				socket.close();
			} catch (final IOException e1) {
				PTAThread.LOGGER.error(
						"Erreur lors de la fermeture du socket ", e1);
			}
		}

	}

	/**
	 * Retourne socket
	 * 
	 * @return socket
	 */
	public Socket getSocket() {
		return socket;
	}

	/**
	 * Modifie socket
	 * 
	 * @param socket
	 *            socket à modifier
	 */
	public void setSocket(final Socket socket) {
		this.socket = socket;
	}

}
