/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadoracadastro.controllers;

import java.sql.SQLException;
import java.util.List;
import transportadoracadastro.models.beans.Status;
import transportadoracadastro.models.daos.DaoStatus;

/**
 *
 * @author manoela.araujo
 */
public class ControllerStatus {
    static DaoStatus daoSta;
    
    public Status inserir (Status staEnt) throws SQLException, ClassNotFoundException {
        daoSta = new DaoStatus(); 
        return daoSta.inserir(staEnt);
    }
    public Status alterar (Status staEnt) throws SQLException, ClassNotFoundException {
        daoSta = new DaoStatus(); 
        return daoSta.alterar(staEnt);
    }
    public List<Status> listar (Status staEnt) throws SQLException, ClassNotFoundException {
        daoSta = new DaoStatus(); 
        return daoSta.listar(staEnt);
    }
    public Status excluir(Status staEnt) throws SQLException, ClassNotFoundException {
        daoSta = new DaoStatus(); 
        return daoSta.excluir(staEnt);
    }

    public Status buscar(Status staEnt) throws SQLException, ClassNotFoundException {
        daoSta = new DaoStatus(); 
        return daoSta.buscar(staEnt);
    }
    
}
