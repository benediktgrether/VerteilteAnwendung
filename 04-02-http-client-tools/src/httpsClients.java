import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

// import com.sun.tools.internal.ws.processor.model.Port;

public class httpsClients
{
    public boolean bool = false;
    public static void main(String[] args)
    {
        get("https://www.bundestag.de/presse");
        // get("https://www.benediktgrether.de");
        // get("https://www.youtube.com");
    }
    public static void get(String url)
    {
        try
        {
            URL u = new URL(url);
            u.getHost();
            int port = u.getPort();
            u.getFile();
            
            if (u.getPort() == -1 )
            {
                port = 443;
            }
            // Socket socket = new Socket(u.getHost(), Port);
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) factory.createSocket(u.getHost(), port);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            if(socket.isConnected() == true)
            {
                writer.write("GET " + u.getFile() + " HTTP/1.1");
                writer.newLine();
                writer.write("Host: " + u.getHost());
                writer.newLine();
                writer.write("");
                writer.newLine();
                writer.flush();
                String answer = reader.readLine();
                if(answer.equals("HTTP/1.1 200 OK"))
                {
                    // bool = true; 
                    urlExist(url);
                    System.out.println("URL Exits");

                }
                else
                {
                    socket.close();
                }
                while(answer != null)
                {
                    System.out.println(body(answer = reader.readLine()));
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error");
        }
    }

    public static boolean urlExist(String s)
    {
        System.out.println("URL Exits");
        return true;
    }

    public static String body(String answer)
    {
        return answer;
    }

}