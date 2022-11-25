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
import transportadoracadastro.models.beans.Status;
import transportadoracadastro.utils.ConexaoBanco;



/**
 *
 * @author manoela.araujo
 */
public class DaoStatus {
    
    private final Connection c;

    public DaoStatus() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoBanco().getConnection();
    }
     
    public Status inserir(Status staEnt) throws SQLException{
        String sql = "insert into status" + " (nome, obs)" + " values (?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,staEnt.getNome());
        stmt.setString(2,staEnt.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            staEnt.setId(id);
        }
        stmt.close();
        return staEnt;
    }
    
    public Status alterar(Status staEnt) throws SQLException{
        String sql = "UPDATE status SET nome = ?, obs = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,staEnt.getNome());
        stmt.setString(2,staEnt.getObs());
        stmt.setInt(3,staEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return staEnt;
    }

    public Status excluir(Status staEnt) throws SQLException{
        String sql = "delete from status WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,staEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return staEnt;
    }
    
    public Status buscar(Status staEnt) throws SQLException{
        String sql = "select * from status WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,staEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Status staSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                staSaida = new Status(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return staSaida;
   }

   public List<Status> listar(Status staEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Status> stas = new ArrayList<>();
        
        String sql = "select * from status where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + staEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Status sta = new Status(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3));
            // adiciona o usu à lista de usus
            stas.add(sta);
        }
        
        rs.close();
        stmt.close();
        return stas;
   
   }
    
}
