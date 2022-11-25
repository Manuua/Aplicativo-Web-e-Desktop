/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadoracadastro.models.beans;

/**
 *
 * @author manoela.araujo
 */
public class UsuarioMotorista {
    
    private int id;
    private int idMotorista;
    private int idUsuario;
    private String dtini;
    private String dtfim;
    private String observacao;
    private Usuario usu;
    private Motorista driver;

    public UsuarioMotorista(int id) {
        this.id = id;
    }

    public UsuarioMotorista(String observacao) {
        this.observacao = observacao;
    }

    public UsuarioMotorista(int idMotorista, int idUsuario, String dtini, String dtfim, String observacao) {
        this.idMotorista = idMotorista;
        this.idUsuario = idUsuario;
        this.dtini = dtini;
        this.dtfim = dtfim;
        this.observacao = observacao;
    }

    public UsuarioMotorista(int id, int idMotorista, int idUsuario, String dtini, String dtfim, String observacao) {
        this.id = id;
        this.idMotorista = idMotorista;
        this.idUsuario = idUsuario;
        this.dtini = dtini;
        this.dtfim = dtfim;
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(int idMotorista) {
        this.idMotorista = idMotorista;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDtini() {
        return dtini;
    }

    public void setDtini(String dtini) {
        this.dtini = dtini;
    }

    public String getDtfim() {
        return dtfim;
    }

    public void setDtfim(String dtfim) {
        this.dtfim = dtfim;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public Motorista getDriver() {
        return driver;
    }

    public void setDriver(Motorista driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "UsuarioMotorista{" + "id=" + id + ", idMotorista=" + idMotorista + ", idUsuario=" + idUsuario + ", dtini=" + dtini + ", dtfim=" + dtfim + ", observacao=" + observacao + '}';
    }

    

    
}
