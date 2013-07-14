/*
 * Document confidentiel - Diffusion interdite 
 */
package fr.pokerfan.pta.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import org.apache.commons.io.IOUtils;
import org.springframework.util.ResourceUtils;

/**
 * @author pierre.kerichard
 * 
 */
public class PTAClientTest {
	public static void main(final String argv[]) throws Exception {

		final Socket clientSocket = new Socket("127.0.0.1", 54504);
		final DataOutputStream outToServer = new DataOutputStream(clientSocket
				.getOutputStream());
		while (true) {
			System.out.println("sending request");
			sendRequest(outToServer);
			final StringBuffer result = new StringBuffer();
			System.out.println("waiting for answer...");
			waitForAnswer(result, new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream())));
			System.out.println("answer : " + result);
		}

	}

	public static void waitForAnswer(final StringBuffer result,
			final BufferedReader buffered) throws IOException {
		final String i = buffered.readLine();
		result.append(i);
	}

	public static void sendRequest(final DataOutputStream outToServer)
			throws IOException {
		final FileInputStream file = new FileInputStream(
				ResourceUtils
						.getFile("C:\\Users\\sophie\\Documents\\GitHub\\PTA\\pta-server\\src\\test\\resources\\input.txt"));
		// final DataInputStream data = new DataInputStream(file);
		IOUtils.copy(file, outToServer);
	}
}
