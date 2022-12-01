import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        if (userName == null || userName.equals("") || password == null || password.equals("")) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户名或密码为空, 登录失败");
            return;
        }
        // 2.查询数据库验证密码
        UserDao userDao = new UserDao();
        User user = userDao.selectUser(userName);
        if (user == null || !user.getPassword().equals(password)) {
            // 密码错误 或 用户名不正确
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户名或密码错误, 登录失败");
            return;
        }
        // 3.如果正确,创建一个会话,保存用户信息
        HttpSession session = req.getSession(true);
        session.setAttribute("user", user);
        // 重定向博客列表页
        resp.sendRedirect("blog_list.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setStatus(403);
            return;
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 有会话,但User对象为空,也是失败
            resp.setStatus(403);
            return;
        }
        resp.setStatus(200);
    }
}
