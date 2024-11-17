package Service;

import DAO.Item_PedidoDAO;
import com.mycompany.model.Item_Pedido;
import com.mycompany.model.ProdutoPedidoId;
import java.util.List;

public class Item_PedidoService {
    
    private Item_PedidoDAO dao = new Item_PedidoDAO();
    private PedidoService pedidoServ = new PedidoService();
    
    public void salvarItem_Pedido(Item_Pedido item_Ped){
        
        if(!(pedidoServ.verificarSeSalvo(item_Ped.getPedido()))){
            
            pedidoServ.salvarPedido(item_Ped.getPedido(), item_Ped.getPedido().getCliente().getNome(),item_Ped.getPedido().getPagamento());
        }
        
        dao.save(item_Ped);
        
    }
    
    public void deletarItem_Pedido(ProdutoPedidoId id){
        
        dao.delete(id);
        
    }
    
    public Item_Pedido buscarPorId(ProdutoPedidoId id){
        
        return dao.findById(id);
    }
    
    public List<Item_Pedido> buscarTodos(){
        
        return dao.findAll();
    }
}
