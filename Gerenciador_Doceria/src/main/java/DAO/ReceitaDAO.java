package DAO;

import Connection.ConnectFactory;
import com.mycompany.model.ItemProdutoId;
import com.mycompany.model.Receita;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ReceitaDAO {

    private EntityManager em;

    public void save(Receita receita) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.persist(receita);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
        } finally {

            em.close();

        }
    }

    public void delete(ItemProdutoId id) {

        em = new ConnectFactory().getConnect();

        try {

            Receita receita = em.find(Receita.class, id);
            em.getTransaction().begin();
            em.remove(receita);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }

    }

    public Receita findById(ItemProdutoId id) {

        em = new ConnectFactory().getConnect();
        Receita receita = null;
        try {
            receita = em.find(Receita.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }

        return receita;
    }

    public List<Receita> findAll() {

        em = new ConnectFactory().getConnect();
        List<Receita> receitas = null;

        try {
            receitas = em.createQuery("from Receita").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return receitas;
    }

    public void update(Receita receita) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.merge(receita);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }
    }
}
