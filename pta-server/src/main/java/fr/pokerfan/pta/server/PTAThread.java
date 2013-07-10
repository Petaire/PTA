/*
 * Document confidentiel - Diffusion interdite 
 */
package fr.pokerfan.pta.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import org.apache.commons.logging.impl.Log4JLogger;

/**
 * 1 Thread = 1 connection
 * 
 * @author pierre.kerichard
 * 
 */
public class PTAThread implements Runnable {

	private static final Log4JLogger LOGGER = new Log4JLogger("PTAThread");

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
		LOGGER.debug("Démarrage du thread");
		System.out.println("Démarrage du thread");
		try {
			final BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));

			while (true) {
				System.out.println(reader.readLine());
			}
		} catch (IOException e) {
			LOGGER.warn("Déconnection du socket");
			System.out.println("Déconnection du socket");
			try {
				socket.close();
			} catch (IOException e1) {
				LOGGER.error("Erreur lors de la fermeture du socket ", e1);
				System.err.println("Erreur lors de la fermeture du socket");
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
