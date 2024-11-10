package Service;

import DAO.FornecedorDAO;
import DAO.TelefoneFornecedorDAO;
import com.mycompany.model.Fornecedor;
import com.mycompany.model.TelefoneFornecedor;
import java.util.List;

public class TelefoneFornecedorService {

    private TelefoneFornecedorDAO dao = new TelefoneFornecedorDAO();
    private FornecedorDAO fornecedor = new FornecedorDAO();

    public TelefoneFornecedorService() {
    }

    public void salvarTelefone(TelefoneFornecedor telefone) {

        dao.save(telefone);

    }

    public boolean verificarUso(TelefoneFornecedor telefone) {

        boolean uso = false;

        List<Fornecedor> fornecedores = fornecedor.findAll();
        for (int i = 0; i < fornecedores.size(); i++) {

            if (fornecedores.get(i).getTelefones().contains(telefone)) {

                uso = true;
                break;
            } else {
                uso = false;
            }
        }
        return uso;
    }

    public void deletarTelefone(TelefoneFornecedor telefone) {

        if ((dao.findById(telefone.getCod_Telefone())) != null && (verificarUso(telefone) == false)) {

            dao.delete(telefone.getCod_Telefone());
        }
    }

    public void atualizarTel(TelefoneFornecedor tel) {

        if (dao.findById(tel.getCod_Telefone()) != null) {

            dao.update(tel);

        }

    }

    public TelefoneFornecedor buscaPorId(int id) {

        return dao.findById(id);
    }

    public List<TelefoneFornecedor> buscarTodosTelefones() {

        return dao.findAll();

    }
}
