package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket = null;

    public TcpEchoClient (String serverIP, int serverPort) throws IOException {
        socket = new Socket(serverIP, serverPort);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            while (true) {
                // 得到请求
                System.out.print("-> ");
                String request = scanner.next();
                // 发送请求至服务器
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(request);
                printWriter.flush();
                // 从服务器得到响应
                Scanner serverScanner = new Scanner(inputStream);
                String response =serverScanner.next();
                System.out.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1", 9090);
        tcpEchoClient.start();
    }
}
