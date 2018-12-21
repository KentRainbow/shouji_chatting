import jdbc.Jdbc;
import test.calls;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "callServlet",urlPatterns = {"/callServlet"})
public class callServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("html/text,charset=utf-8");

        String mobile = request.getParameter("Name");
        List<calls> list = new ArrayList<calls>();
        Jdbc instance = Jdbc.getInstance();
        ResultSet resultSet1 = instance.select("SELECT * FROM `calling`WHERE cnumber='" + mobile + "' OR mnumber='" + mobile + "'");
        //机主信息装填
        try {
            while (resultSet1.next()) {
                System.out.println("找到被呼叫人");
                calls cl = new calls();
                cl.setMnumber(resultSet1.getString("mnumber"));
                cl.setMname(resultSet1.getString("mname"));
                cl.setCnumber(resultSet1.getString("cnumber"));
                cl.setCname(resultSet1.getString("cname"));
                cl.setCtype(resultSet1.getInt("ctype"));
                cl.setCall_time(resultSet1.getString("call_time"));
                list.add(cl);
            }
            request.setAttribute("list", list);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "没有联系人");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        request.getRequestDispatcher("call_recording.jsp").forward(request, response);

    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        this.doPost(request,response);
    }

}
