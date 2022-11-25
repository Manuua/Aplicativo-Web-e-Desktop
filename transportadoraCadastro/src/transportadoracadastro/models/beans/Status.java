/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadoracadastro.models.beans;

/**
 *
 * @author manoela.araujo
 */
public class Status {
       private int id;
    private String nome;
    private String obs;

    public Status(int id) {
        this.id = id;
    }

    public Status(String nome) {
        this.nome = nome;
    }

    public Status(String nome, String obs) {
        this.nome = nome;
        this.obs = obs;
    }

    public Status(int id, String nome, String obs) {
        this.id = id;
        this.nome = nome;
        this.obs = obs;
    }

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

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "Status{" + "id=" + id + ", nome=" + nome + ", obs=" + obs + '}';
    }
    
}
