package DAO;

import Connection.ConnectFactory;
import com.mycompany.model.Item_Pedido;
import com.mycompany.model.ProdutoPedidoId;
import jakarta.persistence.EntityManager;
import java.util.List;

public class Item_PedidoDAO {

    private EntityManager em;

    public void save(Item_Pedido item_Pedido) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.persist(item_Pedido);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
        } finally {

            em.close();

        }
    }

    public void delete(ProdutoPedidoId id) {

        em = new ConnectFactory().getConnect();

        try {

            Item_Pedido item_Pedido = em.find(Item_Pedido.class, id);
            em.getTransaction().begin();
            em.remove(item_Pedido);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }

    }

    public Item_Pedido findById(ProdutoPedidoId id) {

        em = new ConnectFactory().getConnect();
        Item_Pedido item_Pedido = null;
        try {
            item_Pedido = em.find(Item_Pedido.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }

        return item_Pedido;
    }

    public List<Item_Pedido> findAll() {

        em = new ConnectFactory().getConnect();
        List<Item_Pedido> itens_Pedido = null;

        try {
            itens_Pedido = em.createQuery("from Item_Pedido").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return itens_Pedido;
    }

    public void update(Item_Pedido item_Pedido) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.merge(item_Pedido);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }
    }
}
