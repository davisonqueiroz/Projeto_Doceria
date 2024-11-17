package Service;

import DAO.PedidoDAO;
import com.mycompany.model.Cliente;
import com.mycompany.model.Pagamento;
import com.mycompany.model.Pedido;
import java.util.List;

public class PedidoService {

    private PedidoDAO dao = new PedidoDAO();
    private PagamentoService pagService = new PagamentoService();
    private ClienteService cliService = new ClienteService();

    public void salvarPedido(Pedido pedido, String nome_cliente, Pagamento pagamento) {

        Cliente cliente = cliService.buscarPorNome(nome_cliente);
        pedido.setCliente(cliente);
        pagService.salvarPagamento(pagamento);
        pedido.setPagamento(pagamento);
        dao.save(pedido);

    }

    public void deletarPedido(Pedido pedido) {

        Pagamento pagamento = pagService.buscaPorId(pedido.getPagamento().getId_Pagamento());
        pedido.setPagamento(null);
        pagService.deletarPagamento(pagamento.getId_Pagamento());
        pedido.setCliente(null);
        dao.delete(pedido.getId_Pedido());

    }

    public Pedido buscaPorId(int id) {

        return dao.findById(id);
    }

    public List<Pedido> buscarTodosPedido() {

        return dao.findAll();

    }

    public boolean verificarSeSalvo(Pedido ped) {

        List<Pedido> pedidos = dao.findAll();

        for (Pedido pedido : pedidos) {

            if (pedido.getId_Pedido() == ped.getId_Pedido()) {
                return true;
            }
        }
        return false;
    }

}
