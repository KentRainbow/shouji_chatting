import java.io.IOException;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import jdbc.Jdbc;
@WebServlet(name = "deleterecordServlet",urlPatterns = {"/deleterecordServlet"})
public class deleterecordServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("utf-8");

        String date=request.getParameter("date");
        String sql="DELETE FROM `calling` WHERE call_time='"+date+"'";

        Jdbc instance=Jdbc.getInstance();
        instance.insertUpdateDelete(sql);
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        this.doPost(request,response);
    }
}
