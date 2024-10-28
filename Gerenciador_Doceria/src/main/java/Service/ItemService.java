package Service;

import DAO.ItemDAO;
import DAO.LoteDAO;
import com.mycompany.model.Item;
import com.mycompany.model.Lote;
import java.time.LocalDate;
import java.util.List;

public class ItemService {

    private ItemDAO dao = new ItemDAO();
    private LoteService lote = new LoteService();

    public ItemService() {

    }

    public void salvarItem(Item item, LocalDate dtVencimento) {

        int codLote = lote.salvarLote(dtVencimento);
        Lote lote = new Lote();
        lote.setData_Vencimento(dtVencimento);
        lote.setId_Lote(codLote);
        item.setLote(lote);
        dao.save(item);

    }

    public void deletarItem(Item item) {

        int qtd = lote.quantidadeDeUsos(item.getLote().getId_Lote());

        if (qtd > 1) {

            item.setLote(null);
            dao.save(item);
            
        } else {

            Lote loteDel = new Lote();
            loteDel.setId_Lote(item.getLote().getId_Lote());
            item.setLote(null);
            dao.save(item);
            lote.deletarLote(loteDel.getId_Lote());
        }

        dao.delete(item.getId_Item());
    }
    
    public List<Item> buscarPorNome(String nome){
        
        return dao.findByName(nome);
    }
    
    public List<Item> bucarTodosItens(){
        
        return dao.findAll();
    }
}
