import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient implements Runnable {

	private Socket socket;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String login;
	private GUI gui;
	//private String messageEnvoyé, messageReçu = null;

	public ChatClient(Socket s, String login, GUI gui)
	{
		this.socket = s;
		this.login = login;
		this.gui = gui;
	}

	@Override
	public void run() {
		try{
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//Scanner sc = new Scanner(System.in);
			
			Thread thread3 = new Thread(new Emission(out, gui));
			thread3.start();
			Thread thread4 = new Thread(new Reception(in, login, gui));
			thread4.start();

		} catch(Exception e){e.printStackTrace();}



	}

}
