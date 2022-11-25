/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package transportadoracadastro;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import transportadoracadastro.views.ManterEmpresa;
import transportadoracadastro.views.ManterMotorista;
import transportadoracadastro.views.ManterServico;
import transportadoracadastro.views.ManterUsuario;
import transportadoracadastro.views.ManterUsuarioMotorista;

/**
 *
 * @author manoela.araujo
 */
public class TransportadoraCadastro {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if(ManterUsuario.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null,"Usuario Inválido");            
        }
}

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " Bem vindo \n 0 - Sair \n 1 - Usuario \n 2 - Motorista \n 3 - Empresa \n 4 - Serviços \n 5 - UsuarioMotorista";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 0:
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
                if (sair > 0) menu();
                break;
            case 1:
                ManterUsuario.menu();
                break;
            case 2:
                ManterMotorista.menu();
                break;
            case 3:
                ManterEmpresa.menu();
                break;
            case 4: 
                ManterServico.menu();
                break;
            case 5:
                ManterUsuarioMotorista.menu();
                break;
            default:
                System.out.println("Opção inválida");
        }
    }
    
}
