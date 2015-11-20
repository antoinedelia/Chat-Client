import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient implements Runnable {

	private Socket socket;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String login;

	public ChatClient(Socket s, String login)
	{
		this.socket = s;
		this.login = login;
	}

	@Override
	public void run() {
		try{
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			Thread thread3 = new Thread(new Emission(out));
			thread3.start();
			Thread thread4 = new Thread(new Reception(in, login));
			thread4.start();

		} catch(Exception e){e.printStackTrace();}



	}

}
