package transportadoracadastro.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import transportadoracadastro.controllers.ControllerEmpresa;
import transportadoracadastro.models.beans.Empresa;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author manoela.araujo
 */
public class ManterEmpresa {
    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                System.out.println("Opcao inválida");
        }
    }


    public static void inserir() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        String local = JOptionPane.showInputDialog("LOCAL");
        String cnpj = JOptionPane.showInputDialog("CNPJ");
        Empresa company = new Empresa(nome,local,cnpj);
        ControllerEmpresa contcompany = new ControllerEmpresa();
        company = contcompany.inserir(company);
        JOptionPane.showMessageDialog(null,company.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        String local = JOptionPane.showInputDialog("LOCAL");
        String cnpj = JOptionPane.showInputDialog("CNPJ");
        Empresa company = new Empresa(id,nome,local,cnpj);
        ControllerEmpresa contcompany = new ControllerEmpresa();
        company = contcompany.alterar(company);
        JOptionPane.showMessageDialog(null,company.toString());
    }
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Empresa company = new Empresa(id);
        ControllerEmpresa contcompany = new ControllerEmpresa();
        company = contcompany.buscar(company);
        JOptionPane.showMessageDialog(null,company.toString());
    }
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Empresa company = new Empresa(id);
        ControllerEmpresa contcompany = new ControllerEmpresa();
        company = contcompany.excluir(company);
        JOptionPane.showMessageDialog(null,company.toString());
    }
    public static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        Empresa company = new Empresa(nome);
        ControllerEmpresa contcompany = new ControllerEmpresa();
        List<Empresa> listaCompany = contcompany.listar(company);
        for(Empresa companySaida : listaCompany) {
            JOptionPane.showMessageDialog(null,companySaida.toString());
        }

    }
}
