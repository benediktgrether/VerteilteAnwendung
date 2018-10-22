import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
// import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
// import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServiceMultithreaded extends Thread
{
    // ServerSocket serverSocket;
    Socket socket; 

    public TimeServiceMultithreaded(Socket socket)
    {
        // this.serverSocket = serverSocket;
        // super("TimeServiceMultithreaded");
        this.socket = socket;
    }

    public void run() {
        try {
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                
                writer.write("time service");
                writer.newLine();
                writer.flush();
                
                while(!socket.isClosed()) {
                        String input = reader.readLine();
        
                        if (input != null && (input.equals("date") || input.equals("time"))) {
                                writer.write(Clock.getDateOrTime(input));
                                writer.newLine();
                                writer.flush();
                        } else {
                                socket.close();
                        }
                }
        } catch (IOException e) {
                        e.printStackTrace();
                }
    }
}
