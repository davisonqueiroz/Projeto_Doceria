package Service;

import DAO.ItemDAO;
import com.mycompany.model.Descricao;
import com.mycompany.model.Item;
import com.mycompany.model.Lote;
import java.time.LocalDate;
import java.util.List;

public class ItemService {

    private ItemDAO dao = new ItemDAO();
    private LoteService loteamento = new LoteService();
    private DescricaoService descService = new DescricaoService();

    public ItemService() {

    }

    public void salvarItem(Item item, LocalDate dtVencimento, Descricao descricao) {

        int codLote = loteamento.salvarLote(dtVencimento);
        int codDesc = descService.salvarDescricao(descricao);
        Lote lote = new Lote();
        Descricao desc = new Descricao();
        desc.setId_Descricao(codDesc);
        lote.setData_Vencimento(dtVencimento);
        lote.setId_Lote(codLote);
        item.setLote(lote);
        item.setDescricao(desc);
        dao.save(item);

    }

    public void deletarItem(Item item) {

        int qtd = loteamento.quantidadeDeUsos(item.getLote().getId_Lote());
        item.setDescricao(null);

        if (qtd > 1) {

            item.setLote(null);
            dao.save(item);

        } else {

            Lote loteDel = new Lote();
            loteDel.setId_Lote(item.getLote().getId_Lote());
            item.setLote(null);
            dao.save(item);
            loteamento.deletarLote(loteDel.getId_Lote());
        }

        dao.delete(item.getId_Item());
    }

    public Item buscarPorId(int id) {

        return dao.findById(id);
    }

    public List<Item> bucarTodosItens() {

        return dao.findAll();
    }
}
