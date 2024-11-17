package Service;

import DAO.TelefoneDAO;
import com.mycompany.model.Telefone;
import java.util.List;


public class TelefoneService {
    
    private TelefoneDAO dao = new TelefoneDAO();
    
    public void salvarTelefone(Telefone telefone) {
        
        dao.save(telefone);

    }
    
    public void deletarTelefone(int id){
        
        dao.delete(id);
 
    }
    
    public Telefone buscarPorNumero(String telefone){
        
        return dao.findByName(telefone);
        
    }
    
    public List<Telefone> buscarTodosTelefones(){
        
        return dao.findAll();
        
    }
}
