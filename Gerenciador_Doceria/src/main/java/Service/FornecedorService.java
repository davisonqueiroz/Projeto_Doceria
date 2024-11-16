
package Service;

import DAO.FornecedorDAO;
import DAO.TelefoneDAO;

import com.mycompany.model.Fornecedor;
import com.mycompany.model.Telefone;
import java.util.List;


public class FornecedorService {
    
    private FornecedorDAO dao = new FornecedorDAO();
    private TelefoneDAO telDAO = new TelefoneDAO();

    public FornecedorService() {
    }

    public void salvarFornecedor(Fornecedor fornecedor, Telefone telefone) {
        
        telDAO.save(telefone);
        dao.save(fornecedor);

    }
    
    public void deletarFornecedor(Fornecedor fornecedor){
        
        telDAO.delete(fornecedor.getTelefone().getId_Telefone());
        dao.delete(fornecedor.getId_Fornecedor());
 
    }
    
    public List<Fornecedor> buscarPorNome(String nome){
        
        return dao.findByName(nome);
    }
    
    public List<Fornecedor> buscarTodosClientes(){
        
        return dao.findAll();
        
    }
}
