/**
 * Created by Roman on 04.10.2017.
 */
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by Roman on 20.09.2017.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}