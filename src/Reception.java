import java.io.BufferedReader;
import java.io.IOException;

public class Reception implements Runnable {

	private BufferedReader in;
	private String message, login = null;

	public Reception (BufferedReader in, String login)
	{
		this.in  = in;
		this.login = login;
	}

	@Override
	public void run() {

		while(true)
		{

			try {
				message = in.readLine();
				if(message != null && !message.isEmpty())
					System.out.println(message);
			} catch (IOException e) {e.printStackTrace();}

		}

	}

}
