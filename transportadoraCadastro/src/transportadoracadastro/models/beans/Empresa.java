/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadoracadastro.models.beans;

/**
 *
 * @author manoela.araujo
 */
public class Empresa {
    
    private int id;
    private String nome;
    private String local;
    private String cnpj;
    

    // buscar/excluir usuario pela chave pk
    public Empresa (int id) {
        this.id = id;
    }
    // listar Empresa por nome
    public Empresa (String nome) {
        this.nome = nome;
    }
    // para inserir Empresa

    public Empresa(String nome, String local, String cnpj) {
        this.nome = nome;
        this.local = local;
        this.cnpj = cnpj;
       
    }

    
 
    // para alterar dados de Empresa
    public Empresa(int id, String nome, String local, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.cnpj = cnpj;
       
    }

    // get e set para valorização de variaveis
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
    // para impressao
    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", nome=" + nome + ", local=" + local + ", cnpj=" + cnpj + '}';
    }

}
