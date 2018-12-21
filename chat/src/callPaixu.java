import jdbc.Jdbc;
import test.calls;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet(name = "callPaixu",urlPatterns = {"/callPaixu"})
public class callPaixu extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("utf-8");

        List<calls> list=new ArrayList<calls>();
        String Name= request.getParameter("Name");
        Jdbc instance=Jdbc.getInstance();
        ResultSet resultSet=instance.select("SELECT * FROM `calling` WHERE mnumber='"+ Name +"'OR cnumber='"+Name+"'ORDER BY call_time");
        try {
            while (resultSet.next()) {
                System.out.println("找到被呼叫人");
                calls cl = new calls();
                cl.setMnumber(resultSet.getString("mnumber"));
                cl.setMname(resultSet.getString("mname"));
                cl.setCnumber(resultSet.getString("cnumber"));
                cl.setCname(resultSet.getString("cname"));
                cl.setCtype(resultSet.getInt("ctype"));
                cl.setCall_time(resultSet.getString("call_time"));
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
