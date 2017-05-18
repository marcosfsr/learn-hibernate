package curso.hibernate.modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Veiculo implements Serializable{
    private static final long serialVersionUID = -796254196725498399L;
    
    private Integer id;
    private String modelo;
    private Integer ano;
    private Usuario usuario;

    public Veiculo(){
        
    }
    
    public Veiculo(String modelo, Integer ano) {
        super();
        this.modelo = modelo;
        this.ano = ano;
    }
    
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    //o atributo mappedBy evita que se crie uma chave estrangeira (de usuário) na tabela veiculo
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "veiculo") //o nome que está em mappedBy veio da nome definido na classe Usuario
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
        
}
