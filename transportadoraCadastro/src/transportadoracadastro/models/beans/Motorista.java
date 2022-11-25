/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadoracadastro.models.beans;

/**
 *
 * @author manoela.araujo
 */
public class Motorista {
        
    private int id;
    private String nome;
    private String cpf;
    private String idade;
    private String caminhao;
    private String placa;

    // buscar/excluir usuario pela chave pk
    public Motorista (int id) {
        this.id = id;
    }
    // listar motoristas por nome
    public Motorista (String nome) {
        this.nome = nome;
    }
    // para inserir Motorista

    public Motorista(String nome, String cpf, String idade, String caminhao, String placa) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.caminhao = caminhao;
        this.placa = placa;
    }

    
 
    // para alterar dados de motoristas
    public Motorista(int id, String nome, String cpf, String idade, String caminhao, String placa) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.caminhao = caminhao;
        this.placa = placa;
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


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
    
      public String getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(String caminhao) {
        this.caminhao = caminhao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

  
    
    
    
    // para impressao
    @Override
    public String toString() {
        return "Motorista{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", caminhao=" + caminhao + ",placa=" + placa + '}';
    }


    
}
