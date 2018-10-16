// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.OutputStream;
// import java.io.OutputStreamWriter;
// import java.io.InputStreamReader;
// import java.io.IOException;
// import java.net.ServerSocket;
// import java.net.Socket;


// public class TimeServiceClient
// {
//     public static String dateFromServer(String ip)
//     {
//         Socket socket = new Socket(ip, 7500); 
//         System.out.println("Test");
//         // BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//         // writer.write("time service");
//         // writer.newLine();
//         // writer.flush();
//         return Clock.date();
//     }
//     public static String timeFromServer(String ip)
//     {
//         return Clock.time();
//     }

//     public static void main(String[] args) throws IOException
//     {
//         // IP wird mit IP - Adresse ersetzt
//         System.out.println("Test");
//         // dateFromServer("141.28.140.249");
//         System.out.print(dateFromServer("141.28.140.249"));
//     }
// }


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
        // String ip = "141.28.104.156";
        dateFromServer("141.28.140.156");
        // timeFromServer(ip);
	}
	
	public static String dateFromServer(String ip)
	{
		String inbox = null;
		try
		{
			Socket socket = new Socket(ip, 75);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			inbox = reader.readLine();
			System.out.print(inbox);
			writer.write("date");
			writer.newLine();
			writer.flush();
			inbox = reader.readLine();
            System.out.print(inbox);
            // socket.close();
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
			Socket socket = new Socket(ip, 75);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			inbox = reader.readLine();
			System.out.print(inbox);
			writer.write("time");
			writer.newLine();
			writer.flush();
			inbox = reader.readLine();
            System.out.print(inbox);
            // socket.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return inbox;
	}
}