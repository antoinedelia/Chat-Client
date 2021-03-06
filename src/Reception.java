import java.io.BufferedReader;
import java.io.IOException;

public class Reception implements Runnable {

	private BufferedReader in;
	private String message;
	private GUI gui;

	public Reception (BufferedReader in, String login, GUI gui)
	{
		this.in  = in;
		this.gui = gui;
	}

	@Override
	public void run() {

		while(true)
		{

			try {
				message = in.readLine();
				if(message != null && !message.isEmpty())
					//System.out.println(message);
				if(!gui.getLastMessage().equals(message))
					//Receive message from server and send it to all clients
					gui.setMessages(message+"\n");
			} catch (IOException e) {
				stop();
				e.printStackTrace();
			}

		}

	}

	private void stop() {
		gui.setMessages("Le serveur est hors ligne...");
		Thread.interrupted();
		while(!Thread.interrupted()){}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
