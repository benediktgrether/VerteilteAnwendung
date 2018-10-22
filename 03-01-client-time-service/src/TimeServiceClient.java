import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;

public class TimeServiceClient
{
	
	public static void main(String[] args) 
	{
        String ip = "192.168.178.67";
        dateFromServer(ip);
        timeFromServer(ip);
	}
	
	public static String dateFromServer(String ip)
	{
		String inbox = null;
		try
		{
			Socket socket = new Socket(ip, 7500);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			inbox = reader.readLine();
			System.out.println(inbox);
			writer.write("date");
			writer.newLine();
			writer.flush();
			inbox = reader.readLine();
            System.out.println(inbox);
			reader.close(); 
			writer.close();
			//socket.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return inbox;
	}

	public static String timeFromServer(String ip)
	{
		String inbox = null;
		try
		{
			Socket socket = new Socket(ip, 7500);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			inbox = reader.readLine();
			System.out.println(inbox);
			writer.write("time");
			writer.newLine();
			writer.flush();
			inbox = reader.readLine();
			System.out.println(inbox);
			reader.close(); 
			writer.close();
            socket.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return inbox;
	}
}