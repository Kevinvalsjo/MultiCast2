import java.net.*;
import java.io.*;
public class MulticastChatClient {
    public static void main(String args[]) throws Exception {

int portnumber = 5000;
        if (args.length >= 1) {
            portnumber = Integer.parseInt(args[0]);
        }



        MulticastSocket chatMulticastSocket = new MulticastSocket (portnumber);

InetAddress group = InetAddress.getByName("225.4.5.6");
// Joins a multicast group
        String msg="";
        chatMulticastSocket.joinGroup (group);
// Prompt a user to enter a message String msg = "";
        System.out.println("Type a message for the server:");
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        msg = br.readLine();

        DatagramPacket data= new DatagramPacket(msg.getBytes(), 0, msg.length(), group, portnumber);
        chatMulticastSocket.send(data);

        chatMulticastSocket.close();
    }}