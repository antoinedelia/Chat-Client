import java.io.IOException;
import java.net.Socket;

public class ClientSocket implements Cypher{

	public static void main(String[] args) {

		Socket socket = null;
		//Creating our GUI
		GUI gui = new GUI();
		
		try {
			socket = new Socket("localhost", 63);
			Thread thread1 = new Thread(new Connexion(socket, gui));
			thread1.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String encode(String string) {
		//Not implemented yet
		return null;
	}

	@Override
	public String decode(String string) {
		//Not implemented yet
		return null;
	}
}
