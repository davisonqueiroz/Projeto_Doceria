
package DAO;

import Connection.ConnectFactory;
import com.mycompany.model.Telefone;
import jakarta.persistence.EntityManager;
import java.util.List;


public class TelefoneDAO {
    
    private EntityManager em;

    public TelefoneDAO() {
    }
    
    public void save(Telefone telefone) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.persist(telefone);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
        } finally {

            em.close();

        }
    }
    public void delete(int cod_Telefone) {

        em = new ConnectFactory().getConnect();

        try {

            Telefone telefone = em.find(Telefone.class, cod_Telefone);
            em.getTransaction().begin();
            em.remove(telefone);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }

    }
    
    public Telefone findById(int id) {

        em = new ConnectFactory().getConnect();
        Telefone telefone = null;
        try {
            telefone = em.find(Telefone.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }

        return telefone;
    }
    
    public Telefone findByName(String telefone) {

        em = new ConnectFactory().getConnect();
        Telefone tel = new Telefone();
        try {
            tel = em.createQuery("Telefone t where t.nome = :nome", Telefone.class).setParameter("nome", telefone)
                    .getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }

        return tel;
    }
    
    public List<Telefone> findAll() {

        em = new ConnectFactory().getConnect();
        List<Telefone> telefones = null;

        try {
            telefones = em.createQuery("from Telefone").getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return telefones;
    }
    
    public void update(Telefone telefone) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.merge(telefone);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }
    }
}
