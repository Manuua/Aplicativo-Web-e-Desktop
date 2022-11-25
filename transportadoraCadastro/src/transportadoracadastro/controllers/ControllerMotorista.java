package transportadoracadastro.controllers;

import java.sql.SQLException;
import java.util.List;
import transportadoracadastro.models.beans.Motorista;
import transportadoracadastro.models.daos.DaoMotorista;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author manoela.araujo
 */
public class ControllerMotorista {
    
    
    static DaoMotorista daoDriver;

  public Motorista inserir (Motorista driver) throws SQLException, ClassNotFoundException {
        daoDriver = new DaoMotorista(); 
        return daoDriver.inserir(driver);
    }
    public Motorista alterar (Motorista driver) throws SQLException, ClassNotFoundException {
        daoDriver = new DaoMotorista(); 
        return daoDriver.alterar(driver);
    }
    public List<Motorista> listar (Motorista driver) throws SQLException, ClassNotFoundException {
        daoDriver = new DaoMotorista(); 
        return daoDriver.listar(driver); 
    }
    public Motorista excluir(Motorista driver) throws SQLException, ClassNotFoundException {
        daoDriver = new DaoMotorista(); 
        return daoDriver.excluir(driver);
    }
    public Motorista buscar(Motorista driver) throws SQLException, ClassNotFoundException {
        daoDriver = new DaoMotorista(); 
        return daoDriver.buscar(driver);
    }
   
}
