import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/blog")
public class BlogServlet extends HttpServlet {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf8");
        String blogId = req.getParameter("blogId");
        BlogDao blogDao = new BlogDao();
        if (blogId == null) {
            // 博客列表页的显示
            List<Blog> blogs = blogDao.selectAll();
            resp.getWriter().write(objectMapper.writeValueAsString(blogs));
        } else {
            //带有blogId说明是博客详情页
            Blog blog = blogDao.selectOne(Integer.parseInt(blogId));
            resp.getWriter().write(objectMapper.writeValueAsString(blog));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断登录
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setStatus(403);
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("当前未登录, 请登录");
            return;
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.setStatus(403);
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("当前未登录, 请登录");
            return;
        }
        // 得到当前登录的用户, 创建一个博客
        req.setCharacterEncoding("utf8");
        Blog blog = new Blog();
        blog.setTitle(req.getParameter("title"));
        blog.setContent(req.getParameter("content"));
        blog.setUserId(user.getUserId());
        BlogDao blogDao = new BlogDao();
        blogDao.insert(blog);
        // 重定向到博客列表页,发送请求重新获取博客信息
        resp.sendRedirect("blog_list.html");

    }
}
