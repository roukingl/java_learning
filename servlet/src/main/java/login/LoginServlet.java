package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("zhangsan".equals(username) && "123".equals(password)) {
            // 1.创建HttpSession对象和sessionId 2.将sessionId和HttpSession放入哈希表
            // 3.将sessionId放入响应Set-Cookie中
            // session 中放的是用户的个人信息，随意放置的键值对
            HttpSession session = req.getSession(true);
            session.setAttribute("username", "zhangsan");
            session.setAttribute("password", "123");
            resp.sendRedirect("index");
        } else {
            // 登录失败返回403
            resp.setStatus(403);
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("登录失败，用户名或密码错误");
        }
    }
}
