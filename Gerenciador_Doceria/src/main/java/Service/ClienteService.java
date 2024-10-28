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

/**
 *
 * @author User
 */
public class ClienteService {
    
    private ClienteDAO dao = new ClienteDAO();
    private EmailClienteDAO email = new EmailClienteDAO();
    private TelefoneClienteDAO tel = new TelefoneClienteDAO();
    private EnderecoService endereco = new EnderecoService();
    
    public void salvarCliente(Cliente cliente, String tel, Tipo_Contato tipo_Contato){
        
        
        
    }
}
