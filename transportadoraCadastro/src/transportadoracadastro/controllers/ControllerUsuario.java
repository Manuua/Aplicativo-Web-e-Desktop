/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadoracadastro.controllers;

import java.sql.SQLException;
import java.util.List;
import transportadoracadastro.models.beans.Usuario;
import transportadoracadastro.models.daos.DaoUsuario;

/**
 *
 * @author manoela.araujo
 */
public class ControllerUsuario {
    
        static DaoUsuario daoUsu;
    
    public Usuario inserir (Usuario usu) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario(); 
        return daoUsu.inserir(usu);
    }
    public Usuario alterar (Usuario usu) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario(); 
        return daoUsu.alterar(usu);
    }
    public List<Usuario> listar (Usuario usu) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario(); 
        return daoUsu.listar(usu);
    }
    public Usuario excluir(Usuario usu) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario(); 
        return daoUsu.excluir(usu);
    }
    public Usuario validarWeb(Usuario usu) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario(); 
        return daoUsu.validar(usu);
    }

    public Boolean validarDeskTop(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        boolean retorno = false;
        daoUsu = new DaoUsuario(); 
        Usuario usuSaida = daoUsu.validar(usuEnt);
        if(usuSaida != null) retorno = true;
        return retorno;
    }

    public Usuario buscar(Usuario usu) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario(); 
        return daoUsu.buscar(usu);
    }
}
