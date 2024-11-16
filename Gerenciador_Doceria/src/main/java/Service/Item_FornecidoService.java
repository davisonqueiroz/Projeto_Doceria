package Service;

import DAO.Item_FornecidoDAO;
import com.mycompany.model.Fornecedor;
import com.mycompany.model.FornecedorItemId;
import com.mycompany.model.Item_Fornecido;
import java.util.List;

public class Item_FornecidoService {

    private Item_FornecidoDAO dao = new Item_FornecidoDAO();
    private FornecedorService forn = new FornecedorService();

    public void salvarItem_Fornecido(Item_Fornecido item_forn) {

        int idForn = forn.salvarFornecedor(item_forn.getFornecedor(), item_forn.getFornecedor().getTelefone());
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId_Fornecedor(idForn);
        item_forn.setFornecedor(fornecedor);
        dao.save(item_forn);
    }

    public void deletarItem_Fornecido(FornecedorItemId id) {

        if(verificarQuantosFornece(id.getFornecedorId()) == 1){
            dao.delete(id);
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId_Fornecedor(id.getFornecedorId());
            forn.deletarFornecedor(fornecedor);
        }else{
            dao.delete(id);
        }
        
    }
    
    public Item_Fornecido buscarPorId(FornecedorItemId id){
        
        return dao.findById(id);
    }
    
    public List<Item_Fornecido> buscarTodos(){
        
        return dao.findAll();
    }

    public int verificarQuantosFornece(int id) {

        int cont = 0;
        List<Item_Fornecido> fornece = dao.findAll();

        for (int i = 0; i < fornece.size(); i++) {

            if (fornece.get(i).getFornecedor().getId_Fornecedor() == id) {

                cont++;
            }
        }
        return cont;
    }
}
