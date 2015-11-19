import java.io.BufferedReader;
import java.io.IOException;

public class Reception implements Runnable {

	private BufferedReader in = null;
	private String login = null;
	
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
				String message = in.readLine();
				System.out.println(login + " : " + message);
			} catch (IOException e) {e.printStackTrace();}
			
		}

	}

}
