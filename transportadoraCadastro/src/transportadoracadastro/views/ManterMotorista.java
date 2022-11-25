/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadoracadastro.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import transportadoracadastro.controllers.ControllerMotorista;
import transportadoracadastro.models.beans.Motorista;

/**
 *
 * @author manoela.araujo
 */
public class ManterMotorista {
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
        String cpf = JOptionPane.showInputDialog("CPF");
        String idade = JOptionPane.showInputDialog("IDADE");
        String caminhao = JOptionPane.showInputDialog("CAMINHAO");
        String placa = JOptionPane.showInputDialog("PLACA");
        Motorista driver = new Motorista(nome,cpf,idade,caminhao,placa);
        ControllerMotorista contdriver = new ControllerMotorista();
        driver = contdriver.inserir(driver);
        JOptionPane.showMessageDialog(null,driver.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        String cpf = JOptionPane.showInputDialog("CPF");
        String idade = JOptionPane.showInputDialog("IDADE");
        String caminhao = JOptionPane.showInputDialog("CAMINHAO");
        String placa = JOptionPane.showInputDialog("PLACA");
        Motorista driver = new Motorista(id,nome,cpf,idade,caminhao,placa);
        ControllerMotorista contdriver = new ControllerMotorista();
        driver = contdriver.alterar(driver);
        JOptionPane.showMessageDialog(null,driver.toString());
    }
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Motorista driver = new Motorista(id);
        ControllerMotorista contdriver = new ControllerMotorista();
        driver = contdriver.buscar(driver);
        JOptionPane.showMessageDialog(null,driver.toString());
    }
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Motorista driver = new Motorista(id);
        ControllerMotorista contdriver = new ControllerMotorista();
        driver = contdriver.excluir(driver);
        JOptionPane.showMessageDialog(null,driver.toString());
    }
    public static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        Motorista driver = new Motorista(nome);
        ControllerMotorista contdriver = new ControllerMotorista();
        List<Motorista> listaDriver = contdriver.listar(driver);
        for(Motorista driverSaida : listaDriver) {
            JOptionPane.showMessageDialog(null,driverSaida.toString());
        }

    }
}
