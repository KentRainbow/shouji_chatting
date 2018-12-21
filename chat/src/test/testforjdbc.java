package test;

import java.io.IOException;
import java.sql.Connection;
import  java.sql.DriverManager;
import  java.sql.Statement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * created by 孔锐 on 2018/12/17
 */

public class testforjdbc {
    public Connection conn = null;
    public Statement pst = null;

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/shouji_chatting?useSSL=false&serverTimezone=UTC";
    String name = "root";
    String psd = "123456";
    Properties pro = new Properties();


    public Connection testforjdbc() {
        //加载DBconfig.properties实例
        try {
            pro.load(this.getClass().getClassLoader().getResourceAsStream("DBconfig.properties"));
            driver = pro.getProperty(driver);
            url = pro.getProperty(url);
            name = pro.getProperty(name);
            psd = pro.getProperty(psd);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //加载jdbc驱动，指定连接类型
        try {
            Class.forName(driver);
            System.out.println("加载成功");
            conn = DriverManager.getConnection(url, name, psd);
            System.out.println("Success!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //返回一个数据库连接
        try{
            conn.setAutoCommit(false);
            return conn;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main (String[]args){

        System.out.println(new testforjdbc());
    }
}