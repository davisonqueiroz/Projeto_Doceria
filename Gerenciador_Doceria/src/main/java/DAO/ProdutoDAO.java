package DAO;

import Connection.ConnectFactory;
import com.mycompany.model.Produto;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ProdutoDAO {

    private EntityManager em;

    public void save(Produto produto) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
        } finally {

            em.close();

        }
    }

    public void delete(int cod_Produto) {

        em = new ConnectFactory().getConnect();

        try {

            Produto produto = em.find(Produto.class, cod_Produto);
            em.getTransaction().begin();
            em.remove(produto);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }

    }

    public List<Produto> findByName(String nome) {

        em = new ConnectFactory().getConnect();
        List<Produto> produto = null;
        try {
            produto = em.createQuery("Produto pr where pr.nome_Produto = :nome", Produto.class).setParameter("nome", nome)
                    .getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }

        return produto;
    }

    public List<Produto> findAll() {

        em = new ConnectFactory().getConnect();
        List<Produto> produtos = null;

        try {
            produtos = em.createQuery("from Produto").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return produtos;
    }

    public void update(Produto produto) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.merge(produto);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }
    }
}
