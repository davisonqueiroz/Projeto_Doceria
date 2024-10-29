/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DAO.ClienteDAO;
import DAO.EmailClienteDAO;
import DAO.TelefoneClienteDAO;
import Enums.Tipo_Contato;
import com.mycompany.model.Cliente;
import com.mycompany.model.Endereco;
import com.mycompany.model.TelefoneCliente;
import java.util.List;

/**
 *
 * @author User
 */
public class ClienteService {

    private ClienteDAO dao = new ClienteDAO();
    private EmailClienteDAO email = new EmailClienteDAO();
    private TelefoneClienteDAO tel = new TelefoneClienteDAO();
    private EnderecoService endereco = new EnderecoService();

    public void salvarCliente(Cliente cliente, String telefone, Tipo_Contato tipo_Contato, String cep, String email) {

        if ((cliente.getNome() != null)) {

            dao.save(cliente);

            if (telefone != null) {

                TelefoneCliente telefoneCliente = new TelefoneCliente();
                telefoneCliente.setCliente(cliente);
                telefoneCliente.setNumero_Tel(telefone);
                telefoneCliente.setTipo_Contato(tipo_Contato);
                tel.save(telefoneCliente);
            }

            if (cep != null) {

                Endereco end = new Endereco();
                end.setCEP(cep);
                endereco.preencherEndereco(end.getCEP());
                endereco.salvarEndereco(end);

            }

        }

    }
    
    public void deletarCliente(Cliente cliente,Endereco end,TelefoneCliente telefone){
        
        dao.delete(cliente.getId_Cliente());
        endereco.deletarEndereco(end.getId_Endereco());
        tel.delete(telefone.getCod_Telefone());
        
    }
    
    public List<Cliente> buscarPorNome(String nome){
        
        return dao.findByName(nome);
    }
    
    public List<Cliente> buscarTodosClientes(){
        
        return dao.findAll();
        
    }
}
