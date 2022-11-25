/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadoracadastro.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import transportadoracadastro.controllers.ControllerUsuario;
import transportadoracadastro.models.beans.Usuario;

/**
 *
 * @author manoela.araujo
 */
public class ManterUsuario {
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
    
    public static boolean validar() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        Usuario usuEnt = new Usuario(login, senha);
        ControllerUsuario contusu = new ControllerUsuario();
        return contusu.validarDeskTop(usuEnt);
    }

    public static void inserir() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        String status = JOptionPane.showInputDialog("STATUS");
        String tipo = JOptionPane.showInputDialog("TIPO");
        Usuario usu = new Usuario(login, senha, status, tipo);
        ControllerUsuario contusu = new ControllerUsuario();
        usu = contusu.inserir(usu);
        JOptionPane.showMessageDialog(null,usu.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        String status = JOptionPane.showInputDialog("STATUS");
        String tipo = JOptionPane.showInputDialog("TIPO");
        Usuario usu = new Usuario(id,login, senha, status, tipo);
        ControllerUsuario contusu = new ControllerUsuario();
        usu = contusu.alterar(usu);
        JOptionPane.showMessageDialog(null,usu.toString());
    }
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Usuario usu = new Usuario(id);
        ControllerUsuario contusu = new ControllerUsuario();
        usu = contusu.buscar(usu);
        JOptionPane.showMessageDialog(null,usu.toString());
    }
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Usuario usu = new Usuario(id);
        ControllerUsuario contusu = new ControllerUsuario();
        usu = contusu.excluir(usu);
        JOptionPane.showMessageDialog(null,usu.toString());
    }
    public static void listar() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("LOGIN");
        Usuario usuEnt = new Usuario(login);
        ControllerUsuario contusu = new ControllerUsuario();
        List<Usuario> listaUsu = contusu.listar(usuEnt);
        for (Usuario usuSaida : listaUsu) {
            JOptionPane.showMessageDialog(null,usuSaida.toString());
        }
    }
}
