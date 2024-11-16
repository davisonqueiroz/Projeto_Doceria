
package Service;

import DAO.DescricaoDAO;
import DAO.ItemDAO;
import com.mycompany.model.Descricao;
import com.mycompany.model.Item;
import java.util.List;


public class DescricaoService {
    
    private DescricaoDAO dao = new DescricaoDAO();
    private ItemDAO itemDao = new ItemDAO();
    
    public int salvarDescricao(Descricao descricao){
        
        if(!(verificarDuplicidade(descricao))){
            dao.save(descricao);
            return descricao.getId_Descricao();
        }
            
            return descricao.getId_Descricao();
            
    }
    
    public void deletarDescricao( int id){
        
       if((dao.findById(id) != null) && (verificarUso(id)) == false){
           
           dao.delete(id);
       }
 
    }
    
    
    
    public Descricao buscarPorNome(String nome){
        
        return dao.findByName(nome);
    }
    
    public List<Descricao> buscarTodasDescricoes(){
        
        return dao.findAll();
        
    }
    
    public boolean verificarDuplicidade(Descricao descricao){
        
        List<Descricao> descs = dao.findAll();
        for(Descricao desc: descs){
            
            if((desc.getNome_Item().equals(descricao.getNome_Item()))&& (desc.getPeso() == descricao.getPeso())){
                
                return true;
            }
        }
        
        return false;
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
