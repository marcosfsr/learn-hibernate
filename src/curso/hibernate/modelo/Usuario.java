package curso.hibernate.modelo;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Marcos
 */
@Entity
public class Usuario {
    
    private Integer id;
    private String nome;
    private Date dataNascimento;
    private Integer idade;
    private EstadoCivil estadoCivil;
    private Endereco endereco;
    private Endereco enderecoComercial;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="data_nascimento")
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Transient
    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="estado_civil")
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="logradouro", column = @Column(name="rua"))
    })
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="logradouro", column = @Column(name="log")),
        @AttributeOverride(name="cidade", column = @Column(name="cid")),
        @AttributeOverride(name="numero", column = @Column(name="num"))
    })
    public Endereco getEnderecoComercial() {
        return enderecoComercial;
    }

    public void setEnderecoComercial(Endereco enderecoComercial) {
        this.enderecoComercial = enderecoComercial;
    }
    
    
    
}
