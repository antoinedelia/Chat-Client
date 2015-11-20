import java.io.PrintWriter;

public class Emission implements Runnable {

	private PrintWriter out;
	private String message, lastMessage;
	//private Scanner sc = null;
	private GUI gui;


	public Emission(PrintWriter out, GUI gui) {
		this.out  = out;
		this.gui = gui;
	}

	@Override
	public void run() {

		message = "";
		lastMessage = "";

		while(true)
		{
			while(lastMessage.equals(message))
			{
				message = gui.getMessage();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {e.printStackTrace();}
			}
			//Send message to server
			if(!message.equals(lastMessage))
			{
				lastMessage = message;
				out.println(message);
				out.flush();
			}
		}
	}
}
