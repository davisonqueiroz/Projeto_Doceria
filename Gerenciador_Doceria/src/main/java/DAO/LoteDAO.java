package DAO;

import Connection.ConnectFactory;
import com.mycompany.model.Lote;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class LoteDAO {

    private EntityManager em;

    public void save(Lote lote) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.persist(lote);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
        } finally {

            em.close();

        }
    }

    public void delete(int cod_Lote) {

        em = new ConnectFactory().getConnect();

        try {

            Lote lote = em.find(Lote.class, cod_Lote);
            em.getTransaction().begin();
            em.remove(lote);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }

    }

    public Lote findById(int id) {

        em = new ConnectFactory().getConnect();
        Lote lote = null;
        try {
            lote = em.find(Lote.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }

        return lote;
    }
    public Lote findByDate(LocalDate data){
        
       List<Lote> lotes = findAll();
       for(Lote lote : lotes){
           
           if(lote.getData_Vencimento().equals(data)){
               
               return lote;
           }
       }
        return null;
    }

    public List<Lote> findAll() {

        em = new ConnectFactory().getConnect();
        List<Lote> lotes = null;

        try {
            lotes = em.createQuery("from Lote").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return lotes;
    }

    public void update(Lote lote) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.merge(lote);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }
    }
}
