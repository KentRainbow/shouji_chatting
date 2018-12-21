/**
 * Created by 孔锐 on 2018/12/18
 */

import jdbc.Jdbc;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name="loginServlet",urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        request.setCharacterEncoding("utf-8");
        String Name=request.getParameter("Name");
        String Password=request.getParameter("Password");
        Jdbc instance=Jdbc.getInstance();
        ResultSet select=instance.select("SELECT psd FROM info WHERE phone_number='"+Name+"'");

        try{
            if(select.next()){
                String psd1=select.getString("psd");
                if(!Password.equals(psd1)){
                    request.setAttribute("error","密码错误");
                    request.getRequestDispatcher("error.jsp").forward(request,response);
                }else {
                    Cookie loginCookie=new Cookie("loginname",Name);
                    response.addCookie(loginCookie);
                    response.sendRedirect("user.jsp");
                }
                return;
            }
        }catch(SQLException e){
        request.setAttribute("error","用户不存在");
        request.getRequestDispatcher("error.jsp").forward(request,response);
    }


    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        this.doPost(request,response);
    }
}
