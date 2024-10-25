package DAO;

import Connection.ConnectFactory;
import com.mycompany.model.EmailCliente;
import jakarta.persistence.EntityManager;
import java.util.List;

public class EmailClienteDAO {

    private EntityManager em;

    public void save(EmailCliente emailCliente) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.persist(emailCliente);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
        } finally {

            em.close();

        }
    }

    public void delete(int cod_EmailCliente) {

        em = new ConnectFactory().getConnect();

        try {

            EmailCliente emailCliente = em.find(EmailCliente.class, cod_EmailCliente);
            em.getTransaction().begin();
            em.remove(emailCliente);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }

    }

    public EmailCliente findById(int id) {

        em = new ConnectFactory().getConnect();
        EmailCliente emailCliente = null;
        try {
            emailCliente = em.find(EmailCliente.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }

        return emailCliente;
    }

    public List<EmailCliente> findAll() {

        em = new ConnectFactory().getConnect();
        List<EmailCliente> emailClientes = null;

        try {
            emailClientes = em.createQuery("from EmailCliente").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return emailClientes;
    }

    public void update(EmailCliente emailCliente) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.merge(emailCliente);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }
    }
}
