import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeService
{
    public static void main(String[] args) throws IOException
    {
        // System.out.println("Test");
        while(true)
        {
            ServerSocket serverSocket = new ServerSocket(7500);
            Socket socket = serverSocket.accept();
            while(true)
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // System.out.println(bufferedReader.readLine());
                String input  = reader.readLine();
                
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                // System.out.println(Clock.date());
            }

            // System.out.println(Clock.date());
            // System.out.println(Clock.time());
        }
    }
}