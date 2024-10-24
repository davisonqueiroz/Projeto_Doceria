
package Connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectFactory {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("DoceriaPU");
    
    public EntityManager getConnect(){
        
        return emf.createEntityManager();
        
    }
    
}
