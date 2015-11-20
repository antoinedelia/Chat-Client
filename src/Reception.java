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
					gui.setMessages(message+"\n");
			} catch (IOException e) {e.printStackTrace();}

		}

	}

}
