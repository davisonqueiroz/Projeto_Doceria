
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

    public int salvarFornecedor(Fornecedor fornecedor, Telefone telefone) {
        
        if(!(verificarRegistroSalvo(fornecedor.getNome_Fornecedor()))){
            telDAO.save(telefone);
            fornecedor.setTelefone(telefone);
            dao.save(fornecedor);
            return fornecedor.getId_Fornecedor();
        }
        return fornecedor.getId_Fornecedor();
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
    
    public boolean verificarRegistroSalvo(String nome){
        
        List<Fornecedor> forns = dao.findAll();
        for(Fornecedor fornecedor : forns){
            
            if(fornecedor.getNome_Fornecedor().equals(nome)){
                return true;
            }
        }
        return false;
    }
}
