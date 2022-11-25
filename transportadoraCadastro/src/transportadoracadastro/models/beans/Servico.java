/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadoracadastro.models.beans;

/**
 *
 * @author manoela.araujo
 */
public class Servico {
    private int id;
    private String carga;
    private String localEntrega;
    private String valor;
    

    // buscar/excluir usuario pela chave pk
    public Servico (int id) {
        this.id = id;
    }
    // listar Empresa por nome
    public Servico (String carga) {
        this.carga = carga;
    }
    // para inserir Empresa

    public Servico(String carga, String localEntrega, String valor) {
        this.carga = carga;
        this.localEntrega = localEntrega;
        this.valor = valor;
       
    }

    
 
    // para alterar dados de Empresa
    public Servico(int id, String carga, String localEntrega, String valor) {
        this.id = id;
        this.carga = carga;
        this.localEntrega = localEntrega;
        this.valor = valor;
       
    }

    // get e set para valorização de variaveis
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarga() {
        return carga;
    }

    public void setCarga(String carga) {
        this.carga = carga;
    }


    public String getLocalEntrega() {
        return localEntrega;
    }

    public void setLocalEntrega(String localEntrega) {
        this.localEntrega = localEntrega;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
    // para impressao
    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", carga=" + carga + ", localEntrega=" + localEntrega + ", valor=" + valor + '}';
    }
}
