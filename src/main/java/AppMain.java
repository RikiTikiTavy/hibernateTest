/**
 * Created by Roman on 04.10.2017.
 */
import org.hibernate.HibernateException;


import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AppMain {

   static EntityManager entityManager = HibernateUtil.getEntityManager();

    public static void main(String[] args) {

        try {

            entityManager.getTransaction().begin();
            entityManager.setFlushMode(FlushModeType.COMMIT);

            EmployeeEntity employee = new EmployeeEntity();
            employee.setFirstName("FirstName");
            employee.setLastName("LastName");

            //add first car to employee
            CarsEntity car = new CarsEntity();
            car.setModel("vaz21099");
            car.setYear(1991);
            employee.addCar(car);

            //add second car to employee
            car = new CarsEntity();
            car.setModel("calina");
            car.setYear(2015);
            employee.addCar(car);

            entityManager.persist(employee);
            entityManager.flush();

            entityManager.getTransaction().commit();

        } catch (HibernateException e) {

            e.printStackTrace();
        }




        CriteriaBuilder builder = HibernateUtil.getCriteriaBuilder();
        EntityManager em = HibernateUtil.getEntityManager();
        CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);
        Root<CarsEntity> carsRoot = criteriaQuery.from(CarsEntity.class);
        criteriaQuery.select(carsRoot.get("id").as(String.class));
        criteriaQuery.where(builder.equal(carsRoot.get("model"), "calina"));
        List<String> nameList = em.createQuery(criteriaQuery).getResultList();
        for (String name : nameList) {
            System.out.println(name);
        }

    }
}
