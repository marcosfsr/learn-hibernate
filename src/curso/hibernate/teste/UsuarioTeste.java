package curso.hibernate.teste;

import curso.hibernate.modelo.Endereco;
import curso.hibernate.modelo.EstadoCivil;
import curso.hibernate.modelo.Usuario;
import java.util.Date;
import java.util.List;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Marcos
 */
public class UsuarioTeste {

    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        //usuario.setId(2);
        usuario.setNome("Usuario Teste 4");
        usuario.setDataNascimento(new Date());
        usuario.setIdade(30);
        usuario.setEstadoCivil(EstadoCivil.DIVORCIADO);
        
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua Teste");
        endereco.setNumero(123);
        endereco.setCidade("Cidade Teste");
        
        //usuario.setEndereco(endereco);
        usuario.getEnderecos().add(endereco);
        
        Endereco enderecoComercial = new Endereco();
        enderecoComercial.setLogradouro("Rua Teste Comercial");
        enderecoComercial.setNumero(1234);
        enderecoComercial.setCidade("Cidade Teste  Comercial");
        
        //usuario.setEnderecoComercial(enderecoComercial);
        usuario.getEnderecos().add(enderecoComercial);
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        
        //session.save(usuario);
        
        session.getTransaction().commit();
        
        Usuario usuarioBanco = (Usuario) session.get(Usuario.class, 3);
        session.close();
        
        System.out.println("Buscou tudo no banco");
        
        System.out.println("Nome: "+ usuarioBanco.getNome());
        List<Endereco> enderecos =  usuarioBanco.getEnderecos();
        System.out.println("Endereço: " + enderecos.get(0).getLogradouro());
        
    }

}
