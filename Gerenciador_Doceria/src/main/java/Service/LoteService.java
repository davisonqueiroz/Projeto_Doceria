package Service;

import DAO.ItemDAO;
import DAO.LoteDAO;
import com.mycompany.model.Item;
import com.mycompany.model.Lote;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoteService {

    private LoteDAO dao = new LoteDAO();
    private ItemDAO itemDao = new ItemDAO();

    public LoteService() {

    }

    public boolean verificarDuplicidade(LocalDate dtVencimento) {

        List<Lote> lotes = dao.findAll();
        for (Lote lote : lotes) {
            if (lote.getData_Vencimento().equals(dtVencimento)) {
                return true;
            }
        }
        return false;
    }

    public int salvarLote(LocalDate data) {

        if (!verificarDuplicidade(data)) {

            Lote lote = new Lote();
            lote.setData_Vencimento(data);
            dao.save(lote);

            return dao.findByDate(data).getId_Lote();

        } else {

            return dao.findByDate(data).getId_Lote();

        }

    }

    public boolean verificarUso(int id) {

        boolean uso = false;

        List<Item> itens = itemDao.findAll();
        for (int i = 0; i < itens.size(); i++) {

            if (itens.get(i).getLote().getId_Lote() == id) {

                uso = true;
                break;
            } else {
                uso = false;
            }
        }
        return uso;
    }

    public void deletarLote(int id_lote) {

        if ((dao.findById(id_lote) != null) && (verificarUso(id_lote) == false)) {

            dao.delete(id_lote);
            
        }
    }

    public void atualizarLote(Lote lote) {

        if (dao.findById(lote.getId_Lote()) != null) {

            dao.update(lote);

        }

    }

    public Lote buscaPorId(int id) {

        return dao.findById(id);
    }

    public List<Lote> buscarTodosLotes() {

        return dao.findAll();

    }

    public int quantidadeDeUsos(int id) {

        int cont = 0;
        List<Item> itens = itemDao.findAll();
        
        for (int i = 0; i < itens.size(); i++) {

            if (itens.get(i).getLote().getId_Lote() == id) {

                cont++;
            }
        }
        return cont;
    }
}
