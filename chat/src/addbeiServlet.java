import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import test.Contacts;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import jdbc.Jdbc;
import test.Contacts;

@WebServlet(name = "addbeiServlet",urlPatterns = {"/addbeiServlet"})
public class addbeiServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        request.setCharacterEncoding("utf-8");
        String beizhu = request.getParameter("Beizhu");
        String mobile= request.getParameter("mobile");
        Jdbc instance = Jdbc.getInstance();
        instance.insertUpdateDelete("UPDATE `contacts`SET adding='" + beizhu + "'WHERE mobile='"+mobile+"'");
        request.setAttribute("error","插入成功");
        request.getRequestDispatcher("user_contacts.jsp").forward(request,response);
        response.sendRedirect("user_contacts.jsp");
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        this.doPost(request,response);
    }
}
