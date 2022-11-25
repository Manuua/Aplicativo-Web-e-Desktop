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
import transportadoracadastro.models.beans.Servico;
import transportadoracadastro.utils.ConexaoBanco;

/**
 *
 * @author manoela.araujo
 */
public class DaoServico {

   private final Connection c;

    public DaoServico() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoBanco().getConnection();
    }
     
    public Servico inserir(Servico serviceEnt) throws SQLException{
        String sql = "insert into servicos" + " (carga, localEntrega, valor)" + " values (?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,serviceEnt.getCarga());
        stmt.setString(2,serviceEnt.getLocalEntrega());
        stmt.setString(3,serviceEnt.getValor());
        
        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            serviceEnt.setId(id);
        }
        stmt.close();
        return serviceEnt;
    }
    
    public Servico alterar(Servico serviceEnt) throws SQLException{
        String sql = "UPDATE servicos SET carga = ?, localEntrega = ?, valor = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        // seta os valores
        stmt.setString(1,serviceEnt.getCarga());
        stmt.setString(2,serviceEnt.getLocalEntrega());
        stmt.setString(3,serviceEnt.getValor());
        stmt.setInt(4,serviceEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return serviceEnt;
    }

    public Servico excluir(Servico serviceEnt) throws SQLException{
        String sql = "delete from servicos WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,serviceEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return serviceEnt;
    }
    
    public Servico buscar(Servico serviceEnt) throws SQLException{
        String sql = "select * from servicos WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,serviceEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Servico serviceSaida = null;
            while (rs.next()) {      
            // criando o objeto Servico
                serviceSaida = new Servico(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
                    
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return serviceSaida;
   }

   
   
   public List<Servico> listar(Servico serviceEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Servico> services = new ArrayList<>();
        
        String sql = "select * from servicos where carga like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + serviceEnt.getCarga() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Servico service = new Servico(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)
            );
            // adiciona o usu à lista de usus
            services.add(service);
        }
        
        rs.close();
        stmt.close();
        return services;
   
   }
    
}
