package com.jdbc.dzp;





import java.sql.*;

public class JdbcTest02 {
    public static void main(String[] args) {
//        注com.mysql.jdbc.Driver册驱动
        ResultSet set=null;
        Connection cnn=null;
        Statement stm=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//利用反射机制，注册驱动
            //连接数据库
            String url="jdbc:mysql://localhost:3306/bjpowernode";
            String user="root";
            String password="1234";
            cnn= DriverManager.getConnection(url,user,password);
            //获取数据库操作对象statement
            stm=cnn.createStatement();
            //执行sql语句
            String sql="select * from dept";
            set = stm.executeQuery(sql);
            //处理查询结果集
            while(set.next()){
             String deptno=set.getString(1);
             String dname=set.getString(2);
             String loc=set.getString(3);
                System.out.println(deptno+"   "+dname+"  "+loc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {//释放资源
            if (set!=null){
                try {
                    set.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
            if (stm!=null){
                try {
                    stm.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (cnn!=null){
                try {
                    cnn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
