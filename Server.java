import java.io.*; // {Scanner}
import java.net.*; // {ServerSocket, Socket}
import java.util.*; // {PrintWriter}

// Server
public class Server {
    // Main
    public static void main(String[] args) throws Exception {

        ServerSocket server = null;

        try{

            //Server is listening on port 1234
            System.out.println("Server is Listening on Port 1234");
            server = new ServerSocket(1234);
            server.setReuseAddress(true);

            //For getting multiple client request 
            //running infinite loop
            while(true)
            {
                //receiving incoming client request through socket object
                Socket client = server.accept();

                //A Separate Message regarding a new client connection to server
                System.out.println("New Client Connection : "+client.getInetAddress().getHostAddress());
                // Creating a new Thread Object
                HandleClient cSock = new HandleClient(client);

                //This Client will be separately handled by the thread
                Thread obj  = new Thread(cSock);
                
                //starting the execution
                obj.start();
                
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally{
            if(server != null)
            {
                try{
                    server.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }
}

