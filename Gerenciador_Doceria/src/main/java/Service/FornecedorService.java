
package Service;

import DAO.EmailFornecedorDAO;
import DAO.FornecedorDAO;
import DAO.TelefoneFornecedorDAO;
import com.mycompany.model.EmailFornecedor;
import com.mycompany.model.Fornecedor;
import com.mycompany.model.TelefoneFornecedor;

public class FornecedorService {
    
    FornecedorDAO dao = new FornecedorDAO();
    TelefoneFornecedorDAO telDAO = new TelefoneFornecedorDAO();
    EmailFornecedorDAO emailDAO = new EmailFornecedorDAO();

    public FornecedorService() {
    }
    
    public void salvarFornecedor(Fornecedor fornecedor,TelefoneFornecedor telefone, EmailFornecedor email){
        
        
    }
}
