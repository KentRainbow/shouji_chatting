package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class mark {
    public static void main(String[] args){ // 加载数据库驱动  com.mysql.jdbc.Driver
        String driver = "com.mysql.cj.jdbc.Driver";
// 获取mysql连接地址
        String url = "jdbc:mysql://localhost:3306/weixinqianbao?&useSSL=false&serverTimezone=UTC";
// 数据名称
        String username = "root";
// 数据库密码
        String password = "123456";
// 获取一个数据的连接
        Connection conn = null;
// 获取连接的一个状态
        try{
            Class.forName(driver);
//getConnection()方法，连接MySQL数据库！
            conn=DriverManager.getConnection(url,username,password);
            if(!conn.isClosed())
                System.out.println("数据库连接成功！");
//创建statement类对象，用来执行SQL语句！
            Statement Statement=conn.createStatement();
//要执行的SQL语句
            String sql="select * from yonghu_info";
//ResultSet类，用来存放获取的结果集！
            ResultSet rs=Statement.executeQuery(sql);
            System.out.println("-------------------------------");
            System.out.println("执行结果如下所示:");
            System.out.println("-------------------------------");
            System.out.println("用户身份号" + "\t" + "姓名"+"\t"+"用户微信号"+"\t"+"性别");
            System.out.println("-------------------------------");
            String yonghu_id=null;
            String yonghu_name=null;
            String yonghuweixin_id=null;
            String yonghu_sex=null;
            while(rs.next()){ //获取‘学号’这列数据
                yonghu_id=rs.getString("yonghu_id");
//获取‘姓名’这列数据
                yonghu_name=rs.getString("yonghu_name");
//获取‘数学成绩’这列数据
                yonghuweixin_id=rs.getString("yonghuweixin_id");
//获取‘语文成绩’这列数据
                yonghu_sex=rs.getString("yonghu_sex");
//输出结果
                System.out.println(yonghu_id+"\t"+yonghu_name+"\t"+yonghuweixin_id+"\t"+yonghu_sex);
            } rs.close();
            conn.close();
        } catch(ClassNotFoundException e){ //数据库驱动类异常处理
            System.out.println("数据库驱动加载失败！");
            e.printStackTrace();
        } catch(SQLException e1){ //数据库连接失败异常处理
            e1.printStackTrace();
        } catch(Exception e2){ e2.printStackTrace();
        } finally{ System.out.println("-------------------------------");
            System.out.println("数据库数据获取成功！");
        }
    }
}
