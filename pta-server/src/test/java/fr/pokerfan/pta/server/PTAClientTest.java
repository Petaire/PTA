/*
 * Document confidentiel - Diffusion interdite 
 */
package fr.pokerfan.pta.server;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 * @author pierre.kerichard
 * 
 */
public class PTAClientTest {
	public static void main(final String argv[]) throws Exception {

		Socket clientSocket = new Socket("127.0.0.1", 54505);
		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());

		// while (true) {
		// final String saisie = sc.nextLine();
		// if ("-1".equals(saisie)) {
		// return;
		// }
		// outToServer
		// .writeBytes("<tournoi><tournoiId>132456</tournoiId><room>WINAMAX</room><hands><blind>20</blind><antes></antes><nbJoueurs>4</nbJoueurs><round>PRE_FLOP</round><actions><player><name>ThePetaire</name><stack>2000</stack><position>1</position><action>FOLD</action></player></actions><actions><player><name>TommyDDr</name><stack>1580</stack><position>2</position><action>FOLD</action></player></actions><actions><player><name>Fiflex</name><stack>3500</stack><position>3</position><action>CALL</action></player></actions><actions><player><name>Mendos</name><stack>30</stack><position>4</position><action>CHECK</action></player></actions></hands></tournoi> ");
		// }
		outToServer.writeBytes("<tournoi>blabla</tournoi>\n");
		while (true) {

		}

	}
}
