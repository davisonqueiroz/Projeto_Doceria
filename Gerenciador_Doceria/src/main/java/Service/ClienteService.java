
package Service;

import DAO.ClienteDAO;
import DAO.TelefoneDAO;

import Enums.Tipo_Contato;
import com.mycompany.model.Cliente;
import com.mycompany.model.Telefone;
import java.util.List;


public class ClienteService {

    private ClienteDAO dao = new ClienteDAO();
    private TelefoneDAO telDAO = new TelefoneDAO();

    public void salvarCliente(Cliente cliente, Telefone telefone) {
        
        telDAO.save(telefone);
        dao.save(cliente);

    }
    
    public void deletarCliente(Cliente cliente){
        
        telDAO.delete(cliente.getTelefone().getId_Telefone());
        dao.delete(cliente.getId_Cliente());
 
    }
    
    public List<Cliente> buscarPorNome(String nome){
        
        return dao.findByName(nome);
    }
    
    public List<Cliente> buscarTodosClientes(){
        
        return dao.findAll();
        
    }
}
