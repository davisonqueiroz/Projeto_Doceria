package DAO;

import Connection.ConnectFactory;
import com.mycompany.model.Pedido;
import jakarta.persistence.EntityManager;
import java.util.List;

public class PedidoDAO {

    private EntityManager em;

    public void save(Pedido pedido) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.persist(pedido);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
        } finally {

            em.close();

        }
    }

    public void delete(int id) {

        em = new ConnectFactory().getConnect();

        try {

            Pedido pedido = em.find(Pedido.class, id);
            em.getTransaction().begin();
            em.remove(pedido);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }

    }

    public Pedido findById(int id) {

        em = new ConnectFactory().getConnect();
        Pedido pedido = null;
        try {
            pedido = em.find(Pedido.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }

        return pedido;
    }

    public List<Pedido> findAll() {

        em = new ConnectFactory().getConnect();
        List<Pedido> pedidos = null;

        try {
            pedidos = em.createQuery("from Pedido").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return pedidos;
    }

    public void update(Pedido pedido) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.merge(pedido);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }
    }
}
