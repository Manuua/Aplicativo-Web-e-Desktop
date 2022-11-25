package backenddmm20222.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lab04aluno
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SimpleTesting{
    public static void main(String[] args) {

        Connection con;
        Statement stmt;
        ResultSet rs;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fateczsdmm20222","root","");
            stmt = con.createStatement();  
            rs = stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            while (rs.next()) {
                System.out.println(rs.getString(1));  
            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    }  
}