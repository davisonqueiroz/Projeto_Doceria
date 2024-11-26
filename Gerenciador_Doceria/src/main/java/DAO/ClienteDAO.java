package DAO;

import Connection.ConnectFactory;
import com.mycompany.model.Cliente;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ClienteDAO {

    public ClienteDAO() {
    }

    private EntityManager em;

    public void save(Cliente cliente) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
        } finally {

            em.close();

        }
    }

    public void delete(int cod_Cliente) {

        em = new ConnectFactory().getConnect();

        try {

            Cliente cliente = em.find(Cliente.class, cod_Cliente);
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }

    }
    
    public Cliente findById(int id) {

        em = new ConnectFactory().getConnect();
        Cliente cliente = null;
        try {
            cliente = em.find(Cliente.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }

        return cliente;
    }

    public Cliente findByName(String nome) {

        em = new ConnectFactory().getConnect();
        Cliente cliente = null;
        try {
            cliente = em.createQuery("from Cliente c where c.nome = :nome", Cliente.class).setParameter("nome", nome)
                    .getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }

        return cliente;
    }

    public List<Cliente> findAll() {

        em = new ConnectFactory().getConnect();
        List<Cliente> clientes = null;

        try {
            clientes = em.createQuery("from Cliente").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return clientes;
    }

    public void update(Cliente cliente) {

        em = new ConnectFactory().getConnect();

        try {

            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

        } finally {

            em.close();
        }
    }
    
    public boolean verificarDuplicidade(String nome){
        
        int ocorrencias = 0;
        boolean duplicidade = false;
        List<Cliente> clientes = findAll();
        
        for(int i = 0; i < clientes.size(); i++){
            
            if(clientes.get(i).getNome().equals(nome)){
                
                ocorrencias++;
            }
        }
        
        if(ocorrencias > 1){
            
            duplicidade = true;
        }
        
        return duplicidade;
    }
}
