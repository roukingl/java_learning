import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getParameter1")
public class getParameter1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取 query string 中的键值对.
        // 也就是浏览器中输入的, 会在浏览器地址栏中显示出来
        String studentId = req.getParameter("studentId");
        String studentName = req.getParameter("studentName");
        System.out.println(studentId);
        System.out.println(studentName);
        resp.setContentType("text/html; charset=utf8");
        resp.getWriter().write(studentId + ", " + studentName);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过 body 获取键值对
        // 也就是通过构造form表单，ajax来发送键值对，地址栏中不会显示键值对
        req.setCharacterEncoding("utf8");
        String studentId = req.getParameter("studentId");
        String studentName = req.getParameter("studentName");
        System.out.println(studentId);
        System.out.println(studentName);
        resp.setContentType("text/html; charset=utf8");
        resp.getWriter().write(studentId + ", " + studentName);
    }
}
