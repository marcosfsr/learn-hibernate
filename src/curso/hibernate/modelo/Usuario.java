package curso.hibernate.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
@Entity
public class Usuario {
    
    private Integer id;
    private String nome;
    private Date dataNascimento;
    private Integer idade;
    private EstadoCivil estadoCivil;
    //private Endereco endereco;
    //private Endereco enderecoComercial;
    //private List <Endereco> enderecos = new ArrayList<>();
    private Veiculo veiculo;

    
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
    
    //como um usuário não necessariamente possui um veiculo, o correto seria manter essa notação (OneToOne) apenas na classe Veiculo
    @OneToOne(cascade = CascadeType.ALL) //usando essa opção cascade não preciso salver o veículo separadamente (session.save(veiculo);)
    @JoinColumn(name="id_veiculo") //essa notação @JoinColumn permite definir o nome da coluna onde o id (FK) será inserido (útil em caso de coluna já existente)
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
        
    /*@ElementCollection(fetch = FetchType.EAGER)
    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }*/
    
    /*@Embedded
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
    }*/
    
}
