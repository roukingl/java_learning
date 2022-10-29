package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoServer {

    private ServerSocket serverSocket = null;
    HashMap<String, String> map;

    public TcpEchoServer(int port) throws IOException {
        // 创建服务端连接
        serverSocket = new ServerSocket(port);
        map = new HashMap<>();
        map.put("dog", "小狗");
        map.put("cat", "小猫");
        map.put("translate", "翻译");
    }

    public void start() throws IOException {
        System.out.println("服务端启动");
        // 连接客户端
        Socket clientSocket = serverSocket.accept();
        ExecutorService pool = Executors.newCachedThreadPool();
        // 处理这个连接, 用线程池处理
        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    processClient(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void processClient(Socket clientSocket) throws IOException {
        System.out.printf("[%s, %d], 客户端上线\n", clientSocket.getInetAddress().toString(), clientSocket.getPort());
        try (clientSocket; InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {
            while (true) {
                Scanner scanner = new Scanner(inputStream);
                if (!scanner.hasNext()) {
                    // 没有数据了, 客户端下线
                    System.out.printf("[%s, %d], 客户端下线", clientSocket.getInetAddress().toString(), clientSocket.getPort());
                    break;
                }
                // 得到请求
                String request = scanner.next();
                // 处理请求
                String respond = process(request);
                // 发送请求
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(respond);
                printWriter.flush();
                System.out.printf("[%s, %d] request: %s, response: %s \n", clientSocket.getInetAddress().toString(), clientSocket.getPort(), request, respond);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String process(String request) {
        return map.getOrDefault(request, "字典中没有该单词");
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer tcpEchoServer = new TcpEchoServer(9090);
        tcpEchoServer.start();
    }
}
