import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPSERVER {
    public static void main(String[] args){
        try {
            DatagramSocket ds = new DatagramSocket(1234);
            byte[] receive = new byte[65535];

            DatagramPacket receiveData = null;
            while (true){
                receiveData = new DatagramPacket(receive,receive.length);
                ds.receive(receiveData);

                System.out.println("Client:-"+data(receive));
                if (data(receive).toString().equals("bye"))
                {
                    System.out.println("Client sent bye.....EXITING");
                    break;
                }
                receive = new byte[65535];
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Object data(byte[] a) {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}
