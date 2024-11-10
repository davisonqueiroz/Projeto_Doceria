
package Service;

import DAO.EmailFornecedorDAO;
import DAO.FornecedorDAO;
import com.mycompany.model.EmailFornecedor;
import com.mycompany.model.Fornecedor;
import java.util.List;

public class EmailFornecedorService {
    
    EmailFornecedorDAO dao = new EmailFornecedorDAO();
    FornecedorDAO fornDAO = new FornecedorDAO();

    public EmailFornecedorService() {
    }
    
    public void salvarEmail(EmailFornecedor emailFornecedor){
        
        dao.save(emailFornecedor);
    }
    
    public boolean verificarUso(EmailFornecedor email) {

        boolean uso = false;

        List<Fornecedor> fornecedores = fornDAO.findAll();
        for (int i = 0; i < fornecedores.size(); i++) {

            if (fornecedores.get(i).getEmails().contains(email)) {

                uso = true;
                break;
            } else {
                uso = false;
            }
        }
        return uso;
    }

    public void deletarEmail(EmailFornecedor email) {

        if ((dao.findById(email.getId_Email())) != null && (verificarUso(email) == false)) {

            dao.delete(email.getId_Email());
        }
    }

    public void atualizarEmail(EmailFornecedor email) {

        if (dao.findById(email.getId_Email()) != null) {

            dao.update(email);

        }

    }

    public EmailFornecedor buscaPorId(int id) {

        return dao.findById(id);
    }

    public List<EmailFornecedor> buscarTodosEmails() {

        return dao.findAll();

    }
}
