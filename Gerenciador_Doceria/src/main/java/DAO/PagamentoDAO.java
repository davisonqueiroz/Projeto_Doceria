package DAO;

import Connection.ConnectFactory;
import com.mycompany.model.Pagamento;
import jakarta.persistence.EntityManager;
import java.util.List;

public class PagamentoDAO {

    private EntityManager em;

    public void save(Pagamento pagamento) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.persist(pagamento);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
        } finally {

            em.close();

        }
    }

    public void delete(int cod_Pagamento) {

        em = new ConnectFactory().getConnect();

        try {

            Pagamento pagamento = em.find(Pagamento.class, cod_Pagamento);
            em.getTransaction().begin();
            em.remove(pagamento);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }

    }

    public Pagamento findById(int id) {

        em = new ConnectFactory().getConnect();
        Pagamento pagamento = null;
        try {
            pagamento = em.find(Pagamento.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }

        return pagamento;
    }

    public List<Pagamento> findAll() {

        em = new ConnectFactory().getConnect();
        List<Pagamento> pagamentos = null;

        try {
            pagamentos = em.createQuery("from Pagamento").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return pagamentos;
    }

    public void update(Pagamento pagamento) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.merge(pagamento);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }
    }
}
