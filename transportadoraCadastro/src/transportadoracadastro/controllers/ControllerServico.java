package transportadoracadastro.controllers;

import java.sql.SQLException;
import java.util.List;
import transportadoracadastro.models.beans.Servico;
import transportadoracadastro.models.daos.DaoServico;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author manoela.araujo
 */
public class ControllerServico {


    static DaoServico daoService;

  public Servico inserir (Servico service) throws SQLException, ClassNotFoundException {
        daoService = new DaoServico(); 
        return daoService.inserir(service);
    }
    public Servico alterar (Servico service) throws SQLException, ClassNotFoundException {
        daoService = new DaoServico(); 
        return daoService.alterar(service);
    }
    public List<Servico> listar (Servico service) throws SQLException, ClassNotFoundException {
        daoService = new DaoServico(); 
        return daoService.listar(service); 
    }
    public Servico excluir(Servico service) throws SQLException, ClassNotFoundException {
        daoService = new DaoServico(); 
        return daoService.excluir(service);
    }
    public Servico buscar(Servico service) throws SQLException, ClassNotFoundException {
        daoService = new DaoServico(); 
        return daoService.buscar(service);
    }
   
}

