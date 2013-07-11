/*
 * Document confidentiel - Diffusion interdite 
 */
package fr.pokerfan.pta.server;

import java.io.IOException;
import java.net.Socket;

import javax.xml.stream.XMLStreamConstants;
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

	private static final Log4JLogger LOGGER = new Log4JLogger(PTAThread.class
			.getCanonicalName());

	private Socket socket;

	/**
	 * Constructeur
	 * 
	 * @param socket
	 *            socket
	 */
	public PTAThread(final Socket socket) {
		this.socket = socket;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		PTAThread.LOGGER.debug("D�marrage du thread");
		try {
			final PropertyManager props = new PropertyManager(
					PropertyManager.CONTEXT_READER);
			XMLStreamReader xmlReader;
			// Attente de l'envoi des donn�es par le client
			while (true) {
				if (socket.getInputStream().available() > 1) {
					// Cr�ation du reader
					xmlReader = new XMLStreamReaderImpl(
							socket.getInputStream(), props);
					break;
				}

			}

			// NPE safe
			if (xmlReader != null) {
				// Parcours des �lements
				while (xmlReader.hasNext()) {
					switch (xmlReader.getEventType()) {
					case XMLStreamConstants.START_DOCUMENT:
						PTAThread.LOGGER.info("Start of document");
						break;
					case XMLStreamConstants.START_ELEMENT:
						PTAThread.LOGGER.info("Start element : "
								+ xmlReader.getName());
						break;
					case XMLStreamConstants.END_ELEMENT:
						PTAThread.LOGGER.info("End element : "
								+ xmlReader.getName());
						break;
					case XMLStreamConstants.CHARACTERS:
						PTAThread.LOGGER.info("Characters : "
								+ xmlReader.getText());
						break;
					default:
						PTAThread.LOGGER.info("Default : "
								+ xmlReader.getEventType());
						break;
					}
					xmlReader.next();
				}

				PTAThread.LOGGER.info("End of document");
				xmlReader.close();
				PTAThread.LOGGER.info("Fermeture de l'input stream");
				socket.getInputStream().close();

			}

		} catch (final IOException e) {
			PTAThread.LOGGER.warn("D�connection du client");

		} catch (final XMLStreamException e) {
			PTAThread.LOGGER.error("Erreur lors de la cr�ation du Xml reader ",
					e);
		} finally {
			try {
				PTAThread.LOGGER.debug("D�connection du socket");
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
	 *            socket � modifier
	 */
	public void setSocket(final Socket socket) {
		this.socket = socket;
	}

}
