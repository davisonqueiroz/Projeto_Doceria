package DAO;

import Connection.ConnectFactory;
import com.mycompany.model.Fornecedor;
import jakarta.persistence.EntityManager;
import java.util.List;

public class FornecedorDAO {

    private EntityManager em;

    public void save(Fornecedor fornecedor) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.persist(fornecedor);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
        } finally {

            em.close();

        }
    }

    public void delete(int cod_Fornecedor) {

        em = new ConnectFactory().getConnect();

        try {

            Fornecedor fornecedor = em.find(Fornecedor.class, cod_Fornecedor);
            em.getTransaction().begin();
            em.remove(fornecedor);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }

    }

    public List<Fornecedor> findByName(String nome) {

        em = new ConnectFactory().getConnect();
        List<Fornecedor> fornecedor = null;
        try {
            fornecedor = em.createQuery("Fornecedor f where f.nome_Fornecedor = :nome", Fornecedor.class).setParameter("nome", nome)
                    .getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }

        return fornecedor;
    }

    public List<Fornecedor> findAll() {

        em = new ConnectFactory().getConnect();
        List<Fornecedor> fornecedores = null;

        try {
            fornecedores = em.createQuery("from Fornecedor").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return fornecedores;
    }

    public void update(Fornecedor fornecedor) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.merge(fornecedor);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }
    }

}
