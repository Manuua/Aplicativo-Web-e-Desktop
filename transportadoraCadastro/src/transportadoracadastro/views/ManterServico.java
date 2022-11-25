/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadoracadastro.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import transportadoracadastro.controllers.ControllerServico;
import transportadoracadastro.models.beans.Servico;

/**
 *
 * @author manoela.araujo
 */
public class ManterServico {
    
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
        String carga = JOptionPane.showInputDialog("CARGA");
        String localEntrega = JOptionPane.showInputDialog("LOCAL ENTREGA");
        String valor = JOptionPane.showInputDialog("VALOR");
        Servico service = new Servico(carga,localEntrega,valor);
        ControllerServico contservice = new ControllerServico();
        service = contservice.inserir(service);
        JOptionPane.showMessageDialog(null,service.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String carga = JOptionPane.showInputDialog("CARGA");
        String local = JOptionPane.showInputDialog("LOCAL");
        String valor = JOptionPane.showInputDialog("VALOR");
        Servico service = new Servico(id,carga,local,valor);
        ControllerServico contservice = new ControllerServico();
        service = contservice.alterar(service);
        JOptionPane.showMessageDialog(null,service.toString());
    }
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Servico service = new Servico(id);
        ControllerServico contservice = new ControllerServico();
        service = contservice.buscar(service);
        JOptionPane.showMessageDialog(null,service.toString());
    }
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Servico service = new Servico(id);
        ControllerServico contservice = new ControllerServico();
        service = contservice.excluir(service);
        JOptionPane.showMessageDialog(null,service.toString());
    }
    public static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        Servico service = new Servico(nome);
        ControllerServico contservice = new ControllerServico();
        List<Servico> listaService = contservice.listar(service);
        for(Servico serviceSaida : listaService) {
            JOptionPane.showMessageDialog(null,serviceSaida.toString());
        }

    }
    
}
