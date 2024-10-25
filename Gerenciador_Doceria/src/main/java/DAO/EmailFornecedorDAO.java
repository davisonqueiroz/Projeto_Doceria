package DAO;

import Connection.ConnectFactory;
import com.mycompany.model.EmailFornecedor;
import jakarta.persistence.EntityManager;
import java.util.List;

public class EmailFornecedorDAO {

    private EntityManager em;

    public void save(EmailFornecedor emailFornecedor) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.persist(emailFornecedor);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
        } finally {

            em.close();

        }
    }

    public void delete(int cod_EmailFornecedor) {

        em = new ConnectFactory().getConnect();

        try {

            EmailFornecedor emailFornecedor = em.find(EmailFornecedor.class, cod_EmailFornecedor);
            em.getTransaction().begin();
            em.remove(emailFornecedor);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }

    }

    public EmailFornecedor findById(int id) {

        em = new ConnectFactory().getConnect();
        EmailFornecedor emailFornecedor = null;
        try {
            emailFornecedor = em.find(EmailFornecedor.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }

        return emailFornecedor;
    }

    public List<EmailFornecedor> findAll() {

        em = new ConnectFactory().getConnect();
        List<EmailFornecedor> emailFornecedores = null;

        try {
            emailFornecedores = em.createQuery("from EmailFornecedor").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return emailFornecedores;
    }

    public void update(EmailFornecedor emailFornecedor) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.merge(emailFornecedor);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }
    }
}
