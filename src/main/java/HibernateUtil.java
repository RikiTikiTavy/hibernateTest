
/**
 * Created by Roman on 20.09.2017.
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;


/**
 * Created by Roman on 20.09.2017.
 */
public class HibernateUtil {


    private static final EntityManagerFactory emFactory;
    static {
        emFactory = Persistence.createEntityManagerFactory("company");
    }
    public static CriteriaBuilder getCriteriaBuilder(){
        CriteriaBuilder builder = emFactory.getCriteriaBuilder();
        return  builder;
    }

    public static EntityManager getEntityManager(){
        return emFactory.createEntityManager();
    }
}