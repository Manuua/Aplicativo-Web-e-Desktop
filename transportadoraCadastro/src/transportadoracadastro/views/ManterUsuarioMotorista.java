/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadoracadastro.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import transportadoracadastro.controllers.ControllerUsuarioMotorista;
import transportadoracadastro.models.beans.UsuarioMotorista;

/**
 *
 * @author manoela.araujo
 */
public class ManterUsuarioMotorista {
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
                System.out.println("Opcao inválido");
        }
    }
    
    public static void inserir() throws SQLException, ClassNotFoundException {
        int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("IDUSUARIO"));
        int idMotorista = Integer.parseInt(JOptionPane.showInputDialog("IDMOTORISTA"));
        String dtini = JOptionPane.showInputDialog("DT_INI");
        String dtfim = JOptionPane.showInputDialog("DT_FIM");
        String obs = JOptionPane.showInputDialog("OBS");
         UsuarioMotorista usudriverEnt = new  UsuarioMotorista(idMotorista, idUsuario, dtini, dtfim, obs);
         ControllerUsuarioMotorista contusudriver = new ControllerUsuarioMotorista();
         UsuarioMotorista usudriverSaida = contusudriver.inserir(usudriverEnt);
        JOptionPane.showMessageDialog(null,usudriverSaida.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("IDUSUARIO"));
        int idMotorista = Integer.parseInt(JOptionPane.showInputDialog("IDMOTORISTA"));
        String dtini = JOptionPane.showInputDialog("DT_INI");
        String dtfim = JOptionPane.showInputDialog("DT_FIM");
        String obs = JOptionPane.showInputDialog("OBS");
        UsuarioMotorista usudriverEnt = new  UsuarioMotorista(id,idMotorista, idUsuario, dtini, dtfim, obs);
        ControllerUsuarioMotorista contusudriver = new ControllerUsuarioMotorista();
        UsuarioMotorista usudriverSaida = contusudriver.alterar(usudriverEnt);
        JOptionPane.showMessageDialog(null,usudriverSaida.toString());
    }
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuarioMotorista usudriverEnt = new UsuarioMotorista(id);
        ControllerUsuarioMotorista contusudriver = new ControllerUsuarioMotorista();
        UsuarioMotorista usudriverSaida = contusudriver.buscar(usudriverEnt);
        JOptionPane.showMessageDialog(null,usudriverSaida.toString());
    }
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuarioMotorista usudriverEnt = new  UsuarioMotorista(id);
        ControllerUsuarioMotorista contusudriver = new ControllerUsuarioMotorista();
         UsuarioMotorista usudriverSaida = contusudriver.excluir(usudriverEnt);
        JOptionPane.showMessageDialog(null,usudriverSaida.toString());
    }
    public static void listar() throws SQLException, ClassNotFoundException {
        String obs = JOptionPane.showInputDialog("OBS");
        UsuarioMotorista usudriverEnt = new  UsuarioMotorista(obs);
        ControllerUsuarioMotorista contusudriver = new ControllerUsuarioMotorista();
        List< UsuarioMotorista> listaUPSaida = contusudriver.listar(usudriverEnt);
        for( UsuarioMotorista usuDriver: listaUPSaida) {
            JOptionPane.showMessageDialog(null,usuDriver.toString());
            JOptionPane.showMessageDialog(null,usuDriver.getDriver().toString());
            JOptionPane.showMessageDialog(null,usuDriver.getUsu().toString());
        }
    }
}
