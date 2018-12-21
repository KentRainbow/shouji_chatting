
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.DataFormatException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import jdbc.Jdbc;
@WebServlet(name = "getcallServlet",urlPatterns = {"/getcallServlet"})
public class getcallServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");

        String mnumber = request.getParameter("mobile");
        String mname=request.getParameter("mname");
        String cnumber = request.getParameter("mobile2");
        String cname=request.getParameter("cname");
        String date = request.getParameter("date");
        Jdbc instance = Jdbc.getInstance();
        //是否接通，接通为1，未接通为0
        String sql = "INSERT INTO `shouji_chatting`.`calling`(`mnumber`,`mname`,`cnumber`,`cname`,`ctype`,`call_time`)VALUES" +
                "('" + mnumber + "','"+mname+"','" + cnumber + "','"+cname+"',0,'" + date+ "')";

        instance.insertUpdateDelete(sql);

        request.setAttribute("error","插入成功");
        request.getRequestDispatcher("user_contacts.jsp").forward(request,response);
        response.sendRedirect("user_contacts.jsp");
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        this.doPost(request,response);
    }
}
