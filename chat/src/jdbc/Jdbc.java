package jdbc;

import java.sql.*;
import java.sql.Driver;
/**
 * Created by 孔锐 on 2017/11/21.
 */
public class Jdbc {

    private final String url ="jdbc:mysql://localhost:3306/shouji_chatting?useSSL=true&serverTimezone=UTC";
    private final String driver ="com.mysql.cj.jdbc.Driver";
    private final String user = "root";
    private final String password = "123456";
    private Connection conn = null;
    Statement statement = null;

    private static final Jdbc instance = new Jdbc();

    private Jdbc()
    {
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            statement = conn.createStatement();
        }catch (ClassNotFoundException e) {
            System.out.println("创建类错误");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("登录错误");
            e.printStackTrace();
        }
    }

    public static Jdbc getInstance()
    {
        return instance;
    }

    public ResultSet select(String sql)
    {
        try {
            ResultSet rs = statement.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            System.out.println("查询错误");
            e.printStackTrace();
        }
        return null;
    }

    public void insertUpdateDelete(String sql)
    {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("增删改错误");
            e.printStackTrace();
        }
    }
}
