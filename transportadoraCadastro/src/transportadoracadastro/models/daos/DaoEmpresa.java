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
import transportadoracadastro.models.beans.Empresa;
import transportadoracadastro.utils.ConexaoBanco;

/**
 *
 * @author manoela.araujo
 */
public class DaoEmpresa {
    private final Connection c;

    public DaoEmpresa() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoBanco().getConnection();
    }
     
    public Empresa inserir(Empresa companyEnt) throws SQLException{
        String sql = "insert into empresas" + " (nome, local, cnpj)" + " values (?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,companyEnt.getNome());
        stmt.setString(2,companyEnt.getLocal());
        stmt.setString(3,companyEnt.getCnpj());
        
        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            companyEnt.setId(id);
        }
        stmt.close();
        return companyEnt;
    }
    
    public Empresa alterar(Empresa companyEnt) throws SQLException{
        String sql = "UPDATE empresa SET nome = ?, cpf = ?, idade = ?, caminhao = ?,placa = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        // seta os valores
        stmt.setString(1,companyEnt.getNome());
        stmt.setString(2,companyEnt.getLocal());
        stmt.setString(3,companyEnt.getCnpj());
        stmt.setInt(4,companyEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return companyEnt;
    }

    public Empresa excluir(Empresa companyEnt) throws SQLException{
        String sql = "delete from empresa WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,companyEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return companyEnt;
    }
    
    public Empresa buscar(Empresa companyEnt) throws SQLException{
        String sql = "select * from empresa WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,companyEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Empresa companySaida = null;
            while (rs.next()) {      
            // criando o objeto Empresa
                companySaida = new Empresa(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
                    
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return companySaida;
   }

   
   
   public List<Empresa> listar(Empresa companyEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Empresa> companies = new ArrayList<>();
        
        String sql = "select * from empresas where nomeEmpresa like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + companyEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Empresa company = new Empresa(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)
            );
            // adiciona o usu à lista de usus
            companies.add(company);
        }
        
        rs.close();
        stmt.close();
        return companies;
   
   }
}
