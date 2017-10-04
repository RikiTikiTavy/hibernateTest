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
            employee.setFirstName("Oleg");
            employee.setLastName("Veshii");

            //add first car to employee
            CompanyEntity company = new CompanyEntity();
            company.setName("vaz21099");
            company.setYear(1991);
            employee.addCompany(company);

            //add second car to employee
            company = new CompanyEntity();
            company.setName("calina");
            company.setYear(2015);
            employee.addCompany(company);

            entityManager.persist(employee);
            entityManager.flush();

            entityManager.getTransaction().commit();

        } catch (HibernateException e) {

            e.printStackTrace();
        }




        CriteriaBuilder builder = HibernateUtil.getCriteriaBuilder();
        EntityManager em = HibernateUtil.getEntityManager();
        CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);
        Root<CompanyEntity> carsRoot = criteriaQuery.from(CompanyEntity.class);
        criteriaQuery.select(carsRoot.get("id").as(String.class));
        criteriaQuery.where(builder.equal(carsRoot.get("model"), "calina"));
        List<String> nameList = em.createQuery(criteriaQuery).getResultList();
        for (String name : nameList) {
            System.out.println(name);
        }

    }
}
