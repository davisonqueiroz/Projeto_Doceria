package DAO;

import Connection.ConnectFactory;
import com.mycompany.model.Item;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ItemDAO {

    private EntityManager em;

    public void save(Item item) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
        } finally {

            em.close();

        }
    }

    public void delete(int cod_Item) {

        em = new ConnectFactory().getConnect();

        try {

            Item item = em.find(Item.class, cod_Item);
            em.getTransaction().begin();
            em.remove(item);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }

    }

    public List<Item> findByName(String nome) {

        em = new ConnectFactory().getConnect();
        List<Item> item = null;
        try {
            item = em.createQuery("Item i where i.nome_Item = :nome", Item.class).setParameter("nome", nome)
                    .getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }

        return item;
    }

    public List<Item> findAll() {

        em = new ConnectFactory().getConnect();
        List<Item> itens = null;

        try {
            itens = em.createQuery("from Item").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return itens;
    }

    public void update(Item item) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.merge(item);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }
    }
}
