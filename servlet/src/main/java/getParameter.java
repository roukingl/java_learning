import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("getParameter")
public class getParameter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        StringBuilder stringBuilder = new StringBuilder();
        Enumeration<String> enumeration = req.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            String value = req.getParameter(key);
            stringBuilder.append(key).append("=").append(value);
            stringBuilder.append("\n");
        }
        resp.setContentType("test/html; charset=utf8");
        resp.getWriter().write(stringBuilder.toString());
    }
}
