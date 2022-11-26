package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 不需要创建session对象, 不存在直接返回空，存在是根据get请求带的cookie的键值对判断身份
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("你还没有创建用户，请创建用户");
            return;
        }
        String username = (String) session.getAttribute("username");
        resp.setContentType("text/html; charset=utf8");
        resp.getWriter().write("登录成功，欢迎来到主页 " + username);
    }
}
