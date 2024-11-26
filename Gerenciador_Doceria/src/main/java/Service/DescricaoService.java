package Service;

import DAO.DescricaoDAO;
import DAO.ItemDAO;
import com.mycompany.model.Descricao;
import com.mycompany.model.Item;
import java.util.List;

public class DescricaoService {

    private DescricaoDAO dao = new DescricaoDAO();
    private ItemDAO itemDao = new ItemDAO();

    public int salvarDescricao(Descricao descricao) {

        if (!(verificarExistencia(descricao))) {
            dao.save(descricao);
            return descricao.getId_Descricao();
        } else {
            
            return retornarId(descricao.getNome_Item());

        }

    }

    public void deletarDescricao(int id) {

        if ((dao.findById(id) != null) && (verificarUso(id)) == false) {

            dao.delete(id);
        }

    }

    public Descricao buscarPorNome(String nome) {

        return dao.findByName(nome);
    }

    public List<Descricao> buscarTodasDescricoes() {

        return dao.findAll();

    }

    public boolean verificarExistencia(Descricao descricao) {

        Descricao desc = buscarPorNome(descricao.getNome_Item());
        return desc != null;
    }

    public int retornarId(String nome){
        
        Descricao descricao = buscarPorNome(nome);
        return descricao.getId_Descricao();
        
    }
    public boolean verificarUso(int id) {

        boolean uso = false;

        List<Item> itens = itemDao.findAll();
        for (int i = 0; i < itens.size(); i++) {

            if (itens.get(i).getDescricao().getId_Descricao() == id) {

                uso = true;
                break;
            } else {
                uso = false;
            }
        }
        return uso;
    }
}
