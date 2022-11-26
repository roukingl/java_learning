import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getStatus")
public class GetStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ret = req.getParameter("status");
        if (ret.equals("1")) {
            resp.setStatus(404);
            resp.sendError(404);
        } else if (ret.equals("2")) {
            resp.setStatus(200);
        } else if (ret.equals("3")) {
            resp.setStatus(500);
        } else {
            resp.setStatus(504);
        }
    }
}
