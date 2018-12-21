import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import jdbc.Jdbc;
@WebServlet(name = "addcontactServlet",urlPatterns = {"/addcontactServlet"})
public class addcontactServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");

        Cookie[] cookies=request.getCookies();
        Cookie a=null;
        for (Cookie c:cookies){
            if(c.getName().equals("loginname")){
                a=c;
                break;
            }
        }
        String myname=null;
        if(a.getValue()!=null){
            myname=a.getValue();
        }else{
            System.out.println("获取cookies失败");
        }
        //从jsp页面中获取提交的信息
        String Name=request.getParameter("Name");
        String Gender=request.getParameter("Gender");
        String Phone=request.getParameter("Phone");
        String Email=request.getParameter("Email");
        String Addr=request.getParameter("Addr");

        String sql="SELECT user_id FROM users WHERE mobile='"+myname+"'";
        Jdbc instance=Jdbc.getInstance();
        ResultSet s1=instance.select(sql);
        int user_id=0;
        try {
            while (s1.next()) {
                user_id=s1.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("寻找用户id失败");
        }

            String sql2 = "INSERT INTO `shouji_chatting`.`contacts`(`user_id`,`display_name`,`gender`,`mobile`,`email`,`addr`)" +
                    "VALUES(" + user_id + ",'" + Name + "','" + Gender + "','" + Phone + "','" + Email + "','" + Addr + "')";
            instance.insertUpdateDelete(sql2);
        request.setAttribute("error","插入成功");
        request.getRequestDispatcher("user_contacts.jsp").forward(request,response);
        response.sendRedirect("user_contacts.jsp");
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        this.doPost(request,response);
    }
}
