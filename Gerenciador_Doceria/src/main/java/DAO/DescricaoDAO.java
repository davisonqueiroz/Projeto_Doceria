
package DAO;

import Connection.ConnectFactory;
import com.mycompany.model.Descricao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class DescricaoDAO {
    
    private EntityManager em;

    public DescricaoDAO() {
    }
    
    public void save(Descricao descricao) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.persist(descricao);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
        } finally {

            em.close();

        }
    }
    public void delete(int cod_Desc) {

        em = new ConnectFactory().getConnect();

        try {

            Descricao descricao = em.find(Descricao.class, cod_Desc);
            em.getTransaction().begin();
            em.remove(descricao);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }

    }
    
    public Descricao findById(int id) {

        em = new ConnectFactory().getConnect();
        Descricao descricao = null;
        try {
            descricao = em.find(Descricao.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }

        return descricao;
    }
    
    public Descricao findByName(String descricao) {

        em = new ConnectFactory().getConnect();
        Descricao desc = new Descricao();
        try {
            desc = em.createQuery("FROM Descricao d where d.nome_Item = :nome", Descricao.class).setParameter("nome", descricao)
                    .getSingleResult();

        } catch (NoResultException e) {
            return null;
        } finally {

            em.close();
        }

        return desc;
    }
    
    public List<Descricao> findAll() {

        em = new ConnectFactory().getConnect();
        List<Descricao> descricoes = null;

        try {
            descricoes = em.createQuery("from Descricao").getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return descricoes;
    }
    
    public void update(Descricao descricao) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.merge(descricao);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }
    }
}
