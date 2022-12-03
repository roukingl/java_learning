import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delete")
public class BlogDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setStatus(403);
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("当前用户未登录, 请登录后操作");
            return;
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.setStatus(403);
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("当前用户未登录, 请登录后操作");
            return;
        }
        String blogId = req.getParameter("blogId");
        if (blogId == null) {
            resp.setStatus(404);
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("博客不存在");
            return;
        }
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectOne(Integer.parseInt(blogId));
        if (blog == null) {
            resp.setStatus(404);
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("博客不存在");
            return;
        }
        if (blog.getUserId() != user.getUserId()) {
            resp.setStatus(403);
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("当前用户无删除权限");
            return;
        }
        blogDao.delete(Integer.parseInt(blogId));
        resp.setContentType("text/html; charset=utf8");
        resp.sendRedirect("blog_list.html");
    }
}
