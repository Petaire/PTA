/*
 * Document confidentiel - Diffusion interdite 
 */
package fr.pokerfan.pta.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.logging.impl.Log4JLogger;

/**
 * 
 * Point d'entr�e de l'application. D�marrage du server
 * 
 * @author pierre.kerichard
 * 
 */
public class PTAServer {

	private static final Log4JLogger LOGGER = new Log4JLogger("PTAServer");

	private static final int DEFAULT_PORT = 54504;

	/**
	 * D�mrrage du serveur et initialisation du contexte Spring
	 * 
	 * @param args
	 *            args[0] : port
	 * 
	 * @author pierre.kerichard
	 */
	public static void main(final String[] args) {

		final ServerSocket serverSocket = initSocket(args);
		if (serverSocket == null) {
			LOGGER.fatal("serverSocket non cr��. Exit");
			System.err.println("serverSocket non cr��. Exit");
			return;
		}

		while (true) {
			try {
				final Socket socketConnection = serverSocket.accept();
				final PTAThread ptaThread = new PTAThread(socketConnection);
				Thread thread = new Thread(ptaThread);
				thread.start();
			} catch (IOException e) {
				LOGGER.warn("d�connection du client");
				System.err.println("d�connection du client");
			}
		}

	}

	/**
	 * 
	 * @param args
	 * @return
	 * 
	 * @author pierre.kerichard
	 */
	private static ServerSocket initSocket(final String[] args) {
		int port = DEFAULT_PORT;
		try {

			if (args != null && args.length > 0) {
				port = Integer.valueOf(args[0]);
			}

			return new ServerSocket(port);
		} catch (IOException e) {
			LOGGER.error("Erreur lors de la cr�ation du socket sur le port "
					+ String.valueOf(port), e);
			System.err
					.println("Erreur lors de la cr�ation du socket sur le port "
							+ String.valueOf(port));
			return null;
		}
	}

}
