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


            CompanyEntity company = new CompanyEntity();
            company.setName("Yamaha");

            company.setYear(1991);
            employee.addCompany(company);


            company = new CompanyEntity();
            company.setName("Gazprom");
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
        Root<CompanyEntity> companyRoot = criteriaQuery.from(CompanyEntity.class);
        criteriaQuery.select(companyRoot.get("id").as(String.class));
        criteriaQuery.where(builder.equal(companyRoot.get("name"), "Yamaha"));
        List<String> nameList = em.createQuery(criteriaQuery).getResultList();
        for (String name : nameList) {
            System.out.println(name);
        }

    }
}
