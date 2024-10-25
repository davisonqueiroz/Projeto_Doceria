package DAO;

import Connection.ConnectFactory;
import com.mycompany.model.TelefoneFornecedor;
import jakarta.persistence.EntityManager;
import java.util.List;

public class TelefoneFornecedorDAO {

    private EntityManager em;

    public void save(TelefoneFornecedor telefoneFornecedor) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.persist(telefoneFornecedor);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
        } finally {

            em.close();

        }
    }

    public void delete(int cod_TelefoneFornecedor) {

        em = new ConnectFactory().getConnect();

        try {

            TelefoneFornecedor telefoneFornecedor = em.find(TelefoneFornecedor.class, cod_TelefoneFornecedor);
            em.getTransaction().begin();
            em.remove(telefoneFornecedor);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }

    }

    public TelefoneFornecedor findById(int id) {

        em = new ConnectFactory().getConnect();
        TelefoneFornecedor telefoneFornecedor = null;
        try {
            telefoneFornecedor = em.find(TelefoneFornecedor.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }

        return telefoneFornecedor;
    }

    public List<TelefoneFornecedor> findAll() {

        em = new ConnectFactory().getConnect();
        List<TelefoneFornecedor> telefoneFornecedores = null;

        try {
            telefoneFornecedores = em.createQuery("from TelefoneFornecedor").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return telefoneFornecedores;
    }

    public void update(TelefoneFornecedor telefoneFornecedor) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.merge(telefoneFornecedor);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }
    }

}
