import jdbc.Jdbc;
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

import test.Contacts;
@WebServlet(name = "contactServlet",urlPatterns = {"/contactServlet"})
public class contactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("utf-8");
        Jdbc instance=Jdbc.getInstance();
        String mobile=request.getParameter("Name");
        List<Contacts> list=new ArrayList<Contacts>();
        ResultSet sl=instance.select("SELECT display_name,gender,mobile,email,addr FROM contacts WHERE user_id in(SELECT user_id FROM users WHERE mobile='"+mobile+"')");


        try {
            while (sl.next()){
                System.out.println("成功找到");
                Contacts contacts=new Contacts();
                contacts.setDisplay_name(sl.getString("display_name"));
                contacts.setGender(sl.getString("gender"));
                contacts.setMobile(sl.getString("mobile"));
                contacts.setEmail(sl.getString("email"));
                contacts.setAddr(sl.getString("addr"));
                list.add(contacts);
            }
            request.setAttribute("list",list);
        }catch (SQLException e){
            e.printStackTrace();
            request.setAttribute("error","没有联系人");
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
        request.getRequestDispatcher("user_contacts.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        this.doPost(request,response);
    }
}
