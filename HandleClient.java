//HandleClient class
import java.io.*;
import java.net.*;

public class HandleClient implements Runnable{
    private final Socket cSocket;

    //setting up a parameterized constructor
    public HandleClient(Socket socket)
    {
        this.cSocket = socket;
    }

    public void run()
    {
        PrintWriter out = null;
        BufferedReader in = null;
        try{

            // Receiving the outputStream of client
            out = new PrintWriter(cSocket.getOutputStream(),true);

            //Receiving the inputStream of client
            in = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));

            String chat;
            // int cnt = 1;
            while((chat = in.readLine())!=null)
            {
                //Displaying the Received the message from the client
                System.out.println("Client : "+chat);
                out.println(chat);
                
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally{
            try{
                if(out != null)
                {
                    out.close();
                }
                if(in!=null)
                {
                    in.close();
                    cSocket.close();
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}