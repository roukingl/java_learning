package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {

    private DatagramSocket socket = null;

    // 服务器连接端口号
    public UdpEchoServer (int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            // 读取请求
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            // 将请求转化为字符串
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            // 根据请求计算响应
            String response = process(request);
            // 转化响应成能通过网络传输的形式
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length, requestPacket.getSocketAddress());
            socket.send(responsePacket);

            // 打印日志
            System.out.printf("[%s:%d], request: %s, response: %s\n", requestPacket.getAddress().toString(), requestPacket.getPort(), request, response);
        }
    }

    // 回显, 输入什么返回什么
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer udpEchoServer = new UdpEchoServer(9090);
        udpEchoServer.start();
    }
}

