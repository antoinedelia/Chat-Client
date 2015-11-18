import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient implements Runnable {

	private Socket socket;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String login;
	private String input = "";

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
			
			while(!input.equals("stop"))
			{	
				System.out.print("Votre message : ");
				Scanner sc = new Scanner(System.in);
				System.out.println(in.readLine());
				System.out.println("Test1");				
				input = sc.nextLine();
				System.out.println("Test3");
				out.println(input);
				System.out.print("Test4");
				out.flush();
				System.out.print("Test5");
				sc.close();
			}
			
			//			Thread thread4 = new Thread(new );
			//			thread4.start();
			//			Thread thread5 = new Thread(new );
			//			thread5.start();

		} catch(Exception e){e.printStackTrace();}



	}

}
