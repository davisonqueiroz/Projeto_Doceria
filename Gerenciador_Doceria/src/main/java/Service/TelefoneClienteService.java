
package Service;

import DAO.ClienteDAO;
import DAO.TelefoneClienteDAO;
import com.mycompany.model.Cliente;
import com.mycompany.model.TelefoneCliente;
import java.util.List;

public class TelefoneClienteService {
    
    private TelefoneClienteDAO dao = new TelefoneClienteDAO();
    private ClienteDAO cliente = new ClienteDAO();

    public TelefoneClienteService() {
        
    }
    
    public void salvarTelefone(TelefoneCliente telefone){
        
        dao.save(telefone);
        
    }
    
    public boolean verificarUso(TelefoneCliente telefone){
        
        boolean uso = false;

        List<Cliente> clientes = cliente.findAll();
        for (int i = 0; i < clientes.size(); i++) {

            if (clientes.get(i).getTelefones().contains(telefone)) {

                uso = true;
                break;
            } else {
                uso = false;
            }
        }
        return uso;
    }
    
    public void deletarTelefone(TelefoneCliente telefone){
        
        if((dao.findById(telefone.getCod_Telefone())) != null && (verificarUso(telefone) == false) ){
            
            dao.delete(telefone.getCod_Telefone());
        }
    }
    
    public void atualizarTel(TelefoneCliente tel) {

        if (dao.findById(tel.getCod_Telefone()) != null) {

            dao.update(tel);

        }

    }
    
    public TelefoneCliente buscaPorId(int id) {

        return dao.findById(id);
    }
    
    public List<TelefoneCliente> buscarTodosTelefones() {

        return dao.findAll();

    }
}
