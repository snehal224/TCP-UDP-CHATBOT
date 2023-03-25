import java.io.*; // {Scanner}
import java.net.*; // {Socket}
import java.util.*; // {PrintWriter}

// Client
public class Client {

    // Main
    public static void main(String[] args) throws Exception {
        System.out.println("Connecting to server ...\n");

        //establishing a connection
        //by passing parameters of ip addresss and a free port
        try(Socket socket = new Socket("localhost",1234))
        {
            //sending text to the server
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            //receiving text from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //initaialising an object of scanner class
            Scanner sc = new Scanner(System.in);
            String chat = "";

            while(!"exit".equalsIgnoreCase(chat))
            {
                // reading from user
                chat = sc.nextLine();

                //sending the text to the server
                out.println(chat);
                out.flush();

                //Receiving and displaying the server reply
                System.out.println("Message Sent: "+in.readLine());
            }

            //closing the scanner object
            sc.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}