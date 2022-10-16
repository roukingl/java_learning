package udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {

    private DatagramSocket socket = null;
    private String serverIP;
    private int serverPort;

    public UdpEchoClient(String serverIP, int serverPort) throws SocketException {
        socket = new DatagramSocket();
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        // 输入请求做铺垫
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 输入请求
            System.out.print("-> ");
            String request = scanner.next();
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length, InetAddress.getByName(this.serverIP), this.serverPort);
            socket.send(requestPacket);
            // 得到响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            // 打印响应
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1", 9090);
        udpEchoClient.start();
    }
}



