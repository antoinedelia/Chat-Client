import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient implements Runnable {

	private Socket socket;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String login;
	private GUI gui;

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
			
			//Creating the thread for sending and receiving data
			Thread thread3 = new Thread(new Emission(out, gui));
			thread3.start();
			Thread thread4 = new Thread(new Reception(in, login, gui));
			thread4.start();

		} catch(Exception e){e.printStackTrace(); stop();}



	}

	private void stop() {
		Thread.interrupted();
		out.flush();
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
