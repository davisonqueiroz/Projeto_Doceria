
package Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.model.Endereco;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class EnderecoService {
    Endereco endereco = new Endereco();
    
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
    
}
