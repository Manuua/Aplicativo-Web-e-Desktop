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
import transportadoracadastro.models.beans.Motorista;
import transportadoracadastro.utils.ConexaoBanco;

/**
 *
 * @author manoela.araujo
 */
public class DaoMotorista {
    private final Connection c;

    public DaoMotorista() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoBanco().getConnection();
    }
     
    public Motorista inserir(Motorista driverEnt) throws SQLException{
        String sql = "insert into motoristas" + " (nome, cpf, idade,caminhao,placa)" + " values (?,?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,driverEnt.getNome());
        stmt.setString(2,driverEnt.getCpf());
        stmt.setString(3,driverEnt.getIdade());
        stmt.setString(4,driverEnt.getCaminhao());
        stmt.setString(5,driverEnt.getPlaca());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            driverEnt.setId(id);
        }
        stmt.close();
        return driverEnt;
    }
    
    public Motorista alterar(Motorista driverEnt) throws SQLException{
        String sql = "UPDATE motoristas SET nome = ?, cpf = ?, idade = ?, caminhao = ?,placa = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        // seta os valores
        stmt.setString(1,driverEnt.getNome());
        stmt.setString(2,driverEnt.getCpf());
        stmt.setString(3,driverEnt.getIdade());
        stmt.setString(4,driverEnt.getCaminhao());
        stmt.setString(5,driverEnt.getPlaca());
        stmt.setInt(5,driverEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return driverEnt;
    }

    public Motorista excluir(Motorista driverEnt) throws SQLException{
        String sql = "delete from motoristas WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,driverEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return driverEnt;
    }
    
    public Motorista buscar(Motorista driverEnt) throws SQLException{
        String sql = "select * from motoristas WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,driverEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Motorista driverSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                driverSaida = new Motorista(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return driverSaida;
   }

   public List<Motorista> listar(Motorista driverEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Motorista> drivers = new ArrayList<>();
        
        String sql = "select * from motoristas where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + driverEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Motorista driver = new Motorista(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6)
            );
            // adiciona o usu à lista de usus
            drivers.add(driver);
        }
        
        rs.close();
        stmt.close();
        return drivers;
   
   }
}
