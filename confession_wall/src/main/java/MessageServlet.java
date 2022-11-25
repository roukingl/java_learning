import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/messageWall")
public class MessageServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final List<Message> messageList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/Json; charset=utf8");
        resp.getWriter().write(objectMapper.writeValueAsString(messageList));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 得到数据，保存
        Message message = objectMapper.readValue(req.getInputStream(), Message.class);
        messageList.add(message);
        resp.setStatus(200);
        System.out.println("数据保存成功: " + message.getFrom() +
                " 对 " + message.getTo() + " 说 " + message.getMessage());
    }
}
