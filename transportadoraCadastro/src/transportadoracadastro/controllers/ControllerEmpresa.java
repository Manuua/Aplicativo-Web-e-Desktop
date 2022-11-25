/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadoracadastro.controllers;

import java.sql.SQLException;
import java.util.List;
import transportadoracadastro.models.beans.Empresa;
import transportadoracadastro.models.daos.DaoEmpresa;
/**
 *
 * @author manoela.araujo
 */
public class ControllerEmpresa {

    static DaoEmpresa daoCompany;

  public Empresa inserir (Empresa company) throws SQLException, ClassNotFoundException {
        daoCompany = new DaoEmpresa(); 
        return daoCompany.inserir(company);
    }
    public Empresa alterar (Empresa company) throws SQLException, ClassNotFoundException {
        daoCompany = new DaoEmpresa(); 
        return daoCompany.alterar(company);
    }
    public List<Empresa> listar (Empresa company) throws SQLException, ClassNotFoundException {
        daoCompany = new DaoEmpresa(); 
        return daoCompany.listar(company); 
    }
    public Empresa excluir(Empresa company) throws SQLException, ClassNotFoundException {
        daoCompany = new DaoEmpresa(); 
        return daoCompany.excluir(company);
    }
    public Empresa buscar(Empresa company) throws SQLException, ClassNotFoundException {
        daoCompany = new DaoEmpresa(); 
        return daoCompany.buscar(company);
    }
   
}

