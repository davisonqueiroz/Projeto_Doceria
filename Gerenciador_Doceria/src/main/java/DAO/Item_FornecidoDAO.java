package DAO;

import Connection.ConnectFactory;
import com.mycompany.model.FornecedorItemId;
import com.mycompany.model.Item_Fornecido;
import jakarta.persistence.EntityManager;
import java.util.List;

public class Item_FornecidoDAO {

    private EntityManager em;

    public void save(Item_Fornecido item_Fornecido) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.persist(item_Fornecido);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
        } finally {

            em.close();

        }
    }

    public void delete(FornecedorItemId id) {

        em = new ConnectFactory().getConnect();

        try {

            Item_Fornecido item_Fornecido = em.find(Item_Fornecido.class, id);
            em.getTransaction().begin();
            em.remove(item_Fornecido);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }

    }

    public Item_Fornecido findById(FornecedorItemId id) {

        em = new ConnectFactory().getConnect();
        Item_Fornecido item_Fornecido = null;
        try {
            item_Fornecido = em.find(Item_Fornecido.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }

        return item_Fornecido;
    }

    public List<Item_Fornecido> findAll() {

        em = new ConnectFactory().getConnect();
        List<Item_Fornecido> itens_Fornecidos = null;

        try {
            itens_Fornecidos = em.createQuery("from Item_Fornecido").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return itens_Fornecidos;
    }

    public void update(Item_Fornecido item_Fornecido) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.merge(item_Fornecido);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }
    }
}
