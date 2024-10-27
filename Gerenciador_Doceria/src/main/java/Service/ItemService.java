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
    
    public void deletarItem(Item item){
        
        item.setLote(null);
        dao.delete(item.getId_Item());
        
    }
}
