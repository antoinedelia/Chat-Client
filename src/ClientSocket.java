import java.io.IOException;
import java.net.Socket;

public class ClientSocket implements Cypher{

	public static void main(String[] args) {

		Socket socket = null;
		//GUI gui = new GUI();
		
		try {
			socket = new Socket("localhost", 68);
			Thread thread1 = new Thread(new Connexion(socket));
			thread1.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		


	}

	@Override
	public String encode(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decode(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
