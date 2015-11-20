import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connexion implements Runnable {

	private Socket socket = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String login = "undefined";
	private GUI gui;

	public Connexion(Socket s, GUI gui)
	{
		this.socket = s;
		this.gui = gui;
	}

	@Override
	public void run() {
		try{
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			System.out.println(in.readLine());
			while(login.equals("undefined"))
			{
				//Getting the login from the gui
				login = gui.getLogin();
				Thread.sleep(100);
			}
			out.println(login);
			out.flush();

			//Create the client chat
			Thread thread2 = new Thread(new ChatClient(socket, login, gui));
			thread2.start();

		}catch(Exception e){ e.printStackTrace();}
	}

}
