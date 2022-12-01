import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        req.setCharacterEncoding("utf8");
        String blogId = req.getParameter("blogId");
        if (blogId == null) {
            // 跳转
        }
    }
}
