package com.jdbc.dzp;
//jdbc六步
import java.sql.*;
public class JdbcTest01 {
    public static void main(String[] args)  {
//        1.注册驱动
            Connection cnn =null;
            Statement stm=null;
            try {
            Driver driver=new com.mysql.cj.jdbc.Driver();//多态，将实现类赋值给接口
            DriverManager.registerDriver(driver);//需要一个Driver对象，而Driver是一个接口无法直接写入，需要借助
            // mysql数据库厂商写的实现类
            //        2.获取连接
            //url 是统一资源定位符（是网络中某个资源的绝对路径）
            String url="jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=GMT%2B8";
            //该错误为是系统时间错误写上serverTimezone=GMT%2B8就行
            String user="root";
            String password="1234";
             cnn=DriverManager.getConnection(url, user, password);
            System.out.println("数据库连接="+cnn);
//            3.获取数据库操作对象
             stm=cnn.createStatement();
            //        4.执行sql语句
            String sql="insert into dept(DEPTNO,DNAME,LOC) values(50,'duanzhiping','jiangxi')";
//            String sql="delete from dept where DEPTNO=50";
            int i = stm.executeUpdate(sql);
            System.out.println(i);
            //        5.处理查询结果集
            //      6.释放资源

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (stm!=null) {
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




//



//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
