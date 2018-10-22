import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
// import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
// import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeService
{
    // ServerSocket serverSocket;

    public static void main(String[] args)
    {
        TimeServiceStart();
    }

    public static void TimeServiceStart()
    {
        try {
            ServerSocket serverSocket = new ServerSocket(7500);
            while(true)
            try{

                Socket socket = serverSocket.accept();
                if (socket != null)
                {
                    TimeServiceMultithreaded timeServiceMulti = new TimeServiceMultithreaded(socket);
                    timeServiceMulti.start();
                }
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
		}
    }
}