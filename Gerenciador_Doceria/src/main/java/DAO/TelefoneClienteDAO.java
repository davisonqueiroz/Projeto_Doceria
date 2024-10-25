package DAO;

import Connection.ConnectFactory;
import com.mycompany.model.TelefoneCliente;
import jakarta.persistence.EntityManager;
import java.util.List;

public class TelefoneClienteDAO {

    private EntityManager em;

    public void save(TelefoneCliente telefoneCliente) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.persist(telefoneCliente);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
        } finally {

            em.close();

        }
    }

    public void delete(int cod_TelefoneCliente) {

        em = new ConnectFactory().getConnect();

        try {

            TelefoneCliente telefoneCliente = em.find(TelefoneCliente.class, cod_TelefoneCliente);
            em.getTransaction().begin();
            em.remove(telefoneCliente);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }

    }

    public TelefoneCliente findById(int id) {

        em = new ConnectFactory().getConnect();
        TelefoneCliente telefoneCliente = null;
        try {
            telefoneCliente = em.find(TelefoneCliente.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }

        return telefoneCliente;
    }

    public List<TelefoneCliente> findAll() {

        em = new ConnectFactory().getConnect();
        List<TelefoneCliente> telefoneClientes = null;

        try {
            telefoneClientes = em.createQuery("from TelefoneCliente").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return telefoneClientes;
    }

    public void update(TelefoneCliente telefoneCliente) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.merge(telefoneCliente);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }
    }
}
