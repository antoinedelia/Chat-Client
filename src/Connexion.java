import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Connexion implements Runnable {

	private Socket socket = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String login = null;
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
			Scanner sc = new Scanner(System.in);

			System.out.println(in.readLine());
			login = gui.getMessage();
			//login = sc.nextLine();
			out.println(login);
			out.flush();

			Thread thread2 = new Thread(new ChatClient(socket, login));
			thread2.start();


		}catch(Exception e){ e.printStackTrace();}
	}

}
