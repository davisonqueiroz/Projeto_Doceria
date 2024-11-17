
package Service;

import DAO.ClienteDAO;
import com.mycompany.model.Cliente;
import com.mycompany.model.Telefone;
import java.util.List;


public class ClienteService {

    private ClienteDAO dao = new ClienteDAO();
    private TelefoneService telService = new TelefoneService();

    public void salvarCliente(Cliente cliente, Telefone telefone) {
        
        telService.salvarTelefone(telefone);
        dao.save(cliente);

    }
    
    public void deletarCliente(Cliente cliente){
        
        telService.deletarTelefone(cliente.getTelefone().getId_Telefone());
        dao.delete(cliente.getId_Cliente());
 
    }
    
    public List<Cliente> buscarPorNome(String nome){
        
        return dao.findByName(nome);
    }
    
    public List<Cliente> buscarTodosClientes(){
        
        return dao.findAll();
        
    }
}
