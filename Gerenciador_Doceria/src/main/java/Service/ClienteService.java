
package Service;

import DAO.ClienteDAO;

import Enums.Tipo_Contato;
import com.mycompany.model.Cliente;
import java.util.List;


public class ClienteService {

    private ClienteDAO dao = new ClienteDAO();


    public void salvarCliente() {



    }
    
    public void deletarCliente(){
        
 
    }
    
    public List<Cliente> buscarPorNome(String nome){
        
        return dao.findByName(nome);
    }
    
    public List<Cliente> buscarTodosClientes(){
        
        return dao.findAll();
        
    }
}
