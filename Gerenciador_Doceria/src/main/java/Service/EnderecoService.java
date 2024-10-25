
package Service;

import Connection.ConnectFactory;
import Enums.Unidade_Da_Federacao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.model.Endereco;
import jakarta.persistence.EntityManager;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


public class EnderecoService {
    
    Endereco endereco = new Endereco();
    private EntityManager em;
    
    public Endereco getEndereco (String cep) throws IOException,InterruptedException {
        
        try {
            
            HttpClient client = HttpClient.newHttpClient();
            
            //Criação da requisição http
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("viacep.com.br/ws/" + cep + "/json/")).build();
            
            //Envia a requisição e seta o retorno como String
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            //Pega o retorno em json e transforma em um objeto java
            ObjectMapper mapper = new ObjectMapper();
            
            //transforma em um objeto Endereco
            endereco = mapper.readValue(response.body(), Endereco.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return endereco;
    }
    
    public Endereco preencherEndereco(String cep){
 
        Endereco end = new Endereco();
        
        try {
            
            end = getEndereco(cep);
           
            end.setUF(Unidade_Da_Federacao.DF);
            em.getTransaction().begin();
            em.persist(end);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        
        return end;
        
    }
    
    public void salvarEndereco (Endereco endereco){
        
        em = new ConnectFactory().getConnect();
        
        try {
            
            em.getTransaction().begin();
            em.persist(endereco);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            
            em.getTransaction().rollback();
            
        } finally {
            
            em.close();
            
        }
        
    }
    
    public void deletarEndereco(int id){
        
        em = new ConnectFactory().getConnect();

        try {

            Endereco endereco = em.find(Endereco.class, id);
            em.getTransaction().begin();
            em.remove(endereco);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }
    }
    
    public void update(Endereco endereco) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.merge(endereco);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }
    }
    
     public Endereco findById(int id) {

        em = new ConnectFactory().getConnect();
        Endereco endereco = null;
        try {
            endereco = em.find(Endereco.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }

        return endereco;
    }

    public List<Endereco> findAll() {

        em = new ConnectFactory().getConnect();
        List<Endereco> enderecos = null;

        try {
            enderecos = em.createQuery("from Endereco").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return enderecos;
    }

    
}
