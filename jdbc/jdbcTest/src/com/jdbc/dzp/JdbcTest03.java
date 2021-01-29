package com.jdbc.dzp;

import java.sql.*;
import java.util.Scanner;

public class JdbcTest03 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入所在所要查询大于xx的部门编号");
        int i = sc.nextInt();
        Connection cnn=null;
        PreparedStatement ps=null;
        ResultSet rt=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/bjpowernode";
            String user="root";
            String password="1234";
            cnn= DriverManager.getConnection(url,user,password);
            String sql="select * from dept where deptno >?";
            ps=cnn.prepareStatement(sql);
            ps.setInt(1,i);
            rt=ps.executeQuery();
            while(rt.next()){
                String deptno = rt.getString(1);
                String dname = rt.getString(2);
                String loc = rt.getString(3);
                System.out.println(deptno+"   "+dname+"  "+loc);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (cnn!= null) {
                try {
                    cnn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (rt != null) {
                try {
                    rt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
}
