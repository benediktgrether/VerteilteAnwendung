import java.io.BufferedReader;
import java.io.BufferedWriter;
// import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
// import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeService
{
    public static void main(String[] args)
    {
        try{
            while(true)
            {
                ServerSocket serverSocket = new ServerSocket(7500);
                Socket socket = serverSocket.accept();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                writer.write("time service");
                writer.newLine();
                writer.flush();
                try{
                    while(true)
                    {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String inputTerminal  = reader.readLine();


                        if(inputTerminal == null)
                        {
                            reader.close(); 
                            writer.close();
                            socket.close();
                        }
                        else
                        {
                            switch(inputTerminal)
                            {
                                case "date":
                                writer.write(Clock.date());
                                writer.newLine();
                                writer.flush();
                                break;

                                case "time":
                                writer.write(Clock.time());
                                writer.newLine();
                                writer.flush();
                                break;

                                default:
                                writer.write("end");
                                writer.newLine();
                                writer.flush();                           
                                socket.close();
                                serverSocket.close();
                            }
                        }    
                    reader.close(); 
                    writer.close();
                    serverSocket.close();
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Error Inner Loop");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error Outer Loop");
        }
    }
}