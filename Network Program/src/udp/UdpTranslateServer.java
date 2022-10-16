package udp;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

public class UdpTranslateServer extends UdpEchoServer{

    private HashMap<String, String> map = new HashMap<>();

    public UdpTranslateServer(int port) throws SocketException {
        super(port);

        // 添加词典, HashMap
        map.put("cat", "小猫");
        map.put("translate", "翻译");
        map.put("dog", "小狗");
    }

    @Override
    public String process(String request) {
        return map.getOrDefault(request, "词典中没找到该单词");
    }

    public static void main(String[] args) throws IOException {
        UdpTranslateServer udpTranslateServer = new UdpTranslateServer(9090);
        udpTranslateServer.start();
    }
}
