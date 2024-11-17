package Service;

import DAO.PagamentoDAO;
import com.mycompany.model.Pagamento;
import java.util.List;

public class PagamentoService {

    private PagamentoDAO dao = new PagamentoDAO();

    public void salvarPagamento(Pagamento pagamento) {

        dao.save(pagamento);

    }

    public void deletarPagamento(int id) {

        dao.delete(id);

    }

    public Pagamento buscaPorId(int id) {

        return dao.findById(id);
        
    }

    public List<Pagamento> buscarTodosPagamentos() {

        return dao.findAll();

    }
}
