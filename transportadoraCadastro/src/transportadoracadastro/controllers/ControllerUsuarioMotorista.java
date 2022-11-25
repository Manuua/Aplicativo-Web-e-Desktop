/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadoracadastro.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import transportadoracadastro.models.beans.UsuarioMotorista;
import transportadoracadastro.models.daos.DaoUsuarioMotorista;
import transportadoracadastro.models.beans.Motorista;
import transportadoracadastro.models.beans.Usuario;

/**
 *
 * @author manoela.araujo
 */
public class ControllerUsuarioMotorista {
    
  static DaoUsuarioMotorista daoUsuDriver;
    static ControllerUsuario contUsu;
    static ControllerMotorista contDriver;
    
    public UsuarioMotorista inserir(UsuarioMotorista usudriverEnt) throws SQLException, ClassNotFoundException {
        daoUsuDriver = new DaoUsuarioMotorista(); 
        return daoUsuDriver.inserir(usudriverEnt);
    }
    
    public UsuarioMotorista alterar (UsuarioMotorista usudriverEnt) throws SQLException, ClassNotFoundException {
        daoUsuDriver = new DaoUsuarioMotorista(); 
        return daoUsuDriver.alterar(usudriverEnt);
    }

    public UsuarioMotorista excluir(UsuarioMotorista usudriverEnt) throws SQLException, ClassNotFoundException {
        daoUsuDriver = new DaoUsuarioMotorista(); 
        return daoUsuDriver.excluir(usudriverEnt);
    }

    public UsuarioMotorista buscar(UsuarioMotorista usudriverEnt) throws SQLException, ClassNotFoundException {
        daoUsuDriver = new DaoUsuarioMotorista(); 
        UsuarioMotorista usudriverSaida = daoUsuDriver.buscar(usudriverEnt);
        
        // Preciso popular o motoristas estou reutilizando o controllerUsuario
        // metodo buscar
        Motorista driverEnt = new Motorista(usudriverSaida.getIdMotorista());
        contDriver = new ControllerMotorista();
        usudriverSaida.setDriver(contDriver.buscar(driverEnt));
        
        // Preciso popular o usuario estou reutilizando o controllerUsuario
        // metodo buscar
        Usuario usuEnt = new Usuario(usudriverSaida.getIdUsuario());
        contUsu = new ControllerUsuario();
        usudriverSaida.setUsu(contUsu.buscar(usuEnt));
        return usudriverSaida;
    }

    public List<UsuarioMotorista> listar (UsuarioMotorista usuDriverEnt) throws SQLException, ClassNotFoundException {
        daoUsuDriver = new DaoUsuarioMotorista(); 
        // lista sendo carregada pela lista que foi carregada do banco
        List<UsuarioMotorista> listaUsuDriver = new ArrayList<>();
        // lista sendo carregada do banco de dados
        List<UsuarioMotorista> listaUsuDriverAux = daoUsuDriver.listar(usuDriverEnt);

        for(UsuarioMotorista usudriver : listaUsuDriverAux){
            listaUsuDriver.add(buscar(usudriver));
        }    

        return listaUsuDriver;
    }
   
    
    
    
}
