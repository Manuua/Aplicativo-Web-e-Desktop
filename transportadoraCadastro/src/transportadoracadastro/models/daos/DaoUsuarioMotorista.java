/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadoracadastro.models.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import transportadoracadastro.models.beans.UsuarioMotorista;
import transportadoracadastro.utils.ConexaoBanco;

/**
 *
 * @author manoela.araujo
 */
public class DaoUsuarioMotorista {
    private final Connection c;

    public DaoUsuarioMotorista() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoBanco().getConnection();
    }
     
    public UsuarioMotorista inserir(UsuarioMotorista usupesEnt) throws SQLException{
        String sql = "insert into usuarios_motoristas" + " (idMotorista, idUsuario, dtini, dtfim, observacao)" + " values (?,?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,usupesEnt.getIdMotorista());
        stmt.setInt(2,usupesEnt.getIdUsuario());
        stmt.setString(3,usupesEnt.getDtini());
        stmt.setString(4,usupesEnt.getDtfim());
        stmt.setString(5,usupesEnt.getObservacao());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            usupesEnt.setId(id);
        }
        stmt.close();
        return usupesEnt;
    }
    
    public UsuarioMotorista alterar(UsuarioMotorista usupesEnt) throws SQLException{
        String sql = "UPDATE usuarios_motoristas SET idMotoristas = ?, idUsuario = ?, dtini = ?, dtfim = ?, observacao = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        // seta os valores
        stmt.setInt(1,usupesEnt.getIdMotorista());
        stmt.setInt(2,usupesEnt.getIdUsuario());
        stmt.setString(3,usupesEnt.getDtini());
        stmt.setString(4,usupesEnt.getDtfim());
        stmt.setString(5,usupesEnt.getObservacao());
        stmt.setInt(6,usupesEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return usupesEnt;
    }

    public UsuarioMotorista excluir(UsuarioMotorista usupesEnt) throws SQLException{
        String sql = "delete from usuarios_motoristas WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,usupesEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return usupesEnt;
    }
    
    public UsuarioMotorista buscar(UsuarioMotorista usupesEnt) throws SQLException{
        String sql = "select * from usuarios_motoristas WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,usupesEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            UsuarioMotorista usudriverSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                usudriverSaida = new UsuarioMotorista(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return usudriverSaida;
   }

   public List<UsuarioMotorista> listar(UsuarioMotorista usudriverEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<UsuarioMotorista> udrivers = new ArrayList<>();
        
        String sql = "select * from usuarios_motoristas where observacao like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + usudriverEnt.getObservacao()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            UsuarioMotorista usupes = new UsuarioMotorista(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6)
            );
            // adiciona o usu à lista de usus
            udrivers.add(usupes);
        }
        
        rs.close();
        stmt.close();
        return udrivers;
   
   }
    
}
