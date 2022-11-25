/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadoracadastro.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import transportadoracadastro.controllers.ControllerStatus;
import transportadoracadastro.models.beans.Status;

/**
 *
 * @author manoela.araujo
 */
public class ManterStatus {
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
        String nome = JOptionPane.showInputDialog("NOME");
        String obs = JOptionPane.showInputDialog("OBS");
        Status staEnt = new Status(nome,obs);
        ControllerStatus contStatus = new ControllerStatus();
        Status staSaida = contStatus.inserir(staEnt);
        JOptionPane.showMessageDialog(null,staSaida.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        String obs = JOptionPane.showInputDialog("OBS");
        Status staEnt = new Status(id,nome,obs);
        ControllerStatus contStatus = new ControllerStatus();
        Status staSaida = contStatus.alterar(staEnt);
        JOptionPane.showMessageDialog(null,staSaida.toString());
    }
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Status staEnt = new Status(id);
        ControllerStatus contStatus = new ControllerStatus();
        Status staSaida = contStatus.buscar(staEnt);
        JOptionPane.showMessageDialog(null,staSaida.toString());
    }
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Status staEnt = new Status(id);
        ControllerStatus contStatus = new ControllerStatus();
        Status staSaida = contStatus.excluir(staEnt);
        JOptionPane.showMessageDialog(null,staSaida.toString());
    }
    public static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        Status staEnt = new Status(nome);
        ControllerStatus contStatus = new ControllerStatus();
        List<Status> listaSta = contStatus.listar(staEnt);
        for (Status staSaida : listaSta) {
            JOptionPane.showMessageDialog(null,staSaida.toString());
        }
    }
}
