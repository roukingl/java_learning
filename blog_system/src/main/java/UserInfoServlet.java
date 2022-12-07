import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取blogId
        String blogId = req.getParameter("blogId");
        if (blogId == null) {
            // 博客列表页的,就是登录用户的信息
            // 从Session中获得
            getUserInfoFromSession(req, resp);
        } else {
            // 博客详情页,就是作者的用户信息
            getUserInfoFromDB(req, resp, Integer.parseInt(blogId));
        }
    }

    private void getUserInfoFromDB(HttpServletRequest req, HttpServletResponse resp, int blogId) throws IOException {
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectOne(blogId);
        if (blog == null) {
            resp.setStatus(404);
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("blogId不存在, 请重新输入");
            return;
        }
        // 找到博客根据博客找到作者
        UserDao userDao = new UserDao();
        User user = userDao.selectUser(blog.getUserId());
        if (user == null) {
            // 作者没找到
            resp.setStatus(404);
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("blogId不存在, 请重新输入");
            return;
        }
        user.setPassword("");
        resp.setContentType("application/json; charset=utf8");
        resp.getWriter().write(objectMapper.writeValueAsString(user));
    }

    private void getUserInfoFromSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            // 没有登录
            resp.setStatus(403);
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户未登录, 请登录后访问");
            return;
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.setStatus(403);
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户未登录, 请登录后访问");
            return;
        }
        user.setPassword("");
        resp.setContentType("application/json; charset=utf8");
        resp.getWriter().write(objectMapper.writeValueAsString(user));
    }
}
