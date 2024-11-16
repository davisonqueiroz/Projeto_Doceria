
package Service;

import DAO.ProdutoDAO;
import com.mycompany.model.Produto;
import java.util.List;


public class ProdutoService {
    
    private ProdutoDAO dao = new ProdutoDAO();
    
     public void salvarProduto(Produto produto) {
        

        dao.save(produto);

    }
    
    public void deletarCliente(Produto produto){
        

        dao.delete(produto.getId_Produto());
 
    }
    
    public List<Produto> buscarPorNome(String nome){
        
        return dao.findByName(nome);
    }
    
    public List<Produto> buscarTodosProdutos(){
        
        return dao.findAll();
        
    }
}
