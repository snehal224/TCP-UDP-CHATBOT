import java.io.IOException;
import java.net.*;
import java.util.*;

public class UDPCLIENT {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            DatagramSocket ds = new DatagramSocket();
            InetAddress ip = InetAddress.getLocalHost();
            byte data[] = null;
            while (true){
                System.out.println("Enter Message to send to server");
                String input = sc.nextLine();
                data = input.getBytes();

                DatagramPacket packet = new DatagramPacket(data, data.length,ip,1234);
                ds.send(packet);

                System.out.println("Message Sent!!");

                if(input.equals("bye")) break;
            }

            sc.close();
            ds.close();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}