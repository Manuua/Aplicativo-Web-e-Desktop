/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadoracadastro.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author manoela.araujo
 */
public class ConexaoBanco{
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/transportadora";
            String usuario = "root";
            String senha = "#Manu331914";
            return DriverManager.getConnection(url,usuario,senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
