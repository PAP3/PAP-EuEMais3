package br.com.euemais3.ejbproj.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "USUARIO_SEQ", sequenceName = "USUARIO_SEQ", initialValue = 1, allocationSize = 1)
@NamedQueries({
    @NamedQuery(name = "consultarTodos.Usuario", query = "select u from Usuario u")
})
public class Usuario implements Serializable{
    private static final long serialVersionUID = -8247634916452822541L;
    
    public Usuario() {
    }

    public Usuario(Long id, String usuario, String senha, String nome, String sobrenome, Date dataNasc, TipoConta tipoDeConta) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.tipoDeConta = tipoDeConta;
    }   
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "USUARIO_SEQ")
    private Long id;
    @Column(nullable = false)
    private String usuario;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false)
    private String nome;
    private String sobrenome;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoConta tipoDeConta;
    @ManyToMany(mappedBy = "usuarios")
    private List<Endereco> enderecoUsuario;

    public Long getId() {return id;}
    public String getUsuario() {return usuario;}
    public String getNome() {return nome;}
    public String getSobrenome() {return sobrenome;}
    public Date getDataNasc() {return dataNasc;}
    public TipoConta getTipoDeConta() {return tipoDeConta;}
    public String getSenha() {return senha;}    
    public List<Endereco> getEnderecoUsuario() {return enderecoUsuario;}
    
    public void setId(Long id) {this.id = id;}
    public void setUsuario(String usuario) {this.usuario = usuario;}
    public void setNome(String nome) {this.nome = nome;}
    public void setSobrenome(String sobrenome) {this.sobrenome = sobrenome;}
    public void setDataNasc(Date dataNasc) {this.dataNasc = dataNasc;}
    public void setTipoDeConta(TipoConta tipoDeConta) {this.tipoDeConta = tipoDeConta;}
    public void setSenha(String senha) {this.senha = senha;}
    public void setEnderecoUsuario(List<Endereco> enderecoUsuario) {this.enderecoUsuario = enderecoUsuario;}
}