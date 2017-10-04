/**
 * Created by Roman on 04.10.2017.
 */
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class AppMain {

   static EntityManager entityManager = HibernateUtil.getEntityManager();

    public static void main(String[] args) {

        try {

            entityManager.getTransaction().begin();
            entityManager.setFlushMode(FlushModeType.COMMIT);



            EmployeeEntity employee1 = new EmployeeEntity();
            employee1.setFirstName("Marina");
            employee1.setLastName("Solceva");

            EmployeeEntity employee2 = new EmployeeEntity();
            employee2.setFirstName("Evgenia");
            employee2.setLastName("Jelomnkina");


            EmployeeEntity employee3 = new EmployeeEntity();
            employee3.setFirstName("Oleg");
            employee3.setLastName("Molodec");

            EmployeeEntity employee4 = new EmployeeEntity();
            employee4.setFirstName("Oleg");
            employee4.setLastName("Veshii");



            CompanyEntity company1 = new CompanyEntity();
            company1.setName("Yamaha");
            company1.setYear(1991);


            CompanyEntity  company2 = new CompanyEntity();
            company2.setName("Gazprom");
            company2.setYear(2015);

            CompanyEntity  company3 = new CompanyEntity();
            company3.setName("TrumpIncorporated");
            company3.setYear(2001);



            employee1.addCompany(company1);
            employee1.addCompany(company2);

            employee2.addCompany(company1);

            employee1.addCompany(company1);
            employee3.addCompany(company2);
            employee3.addCompany(company3);


            entityManager.persist(employee1);
            entityManager.persist(employee2);
            entityManager.persist(employee3);

            entityManager.flush();

            entityManager.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        //Company Query

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EmployeeEntity> criteriaQuery = criteriaBuilder
                .createQuery(EmployeeEntity.class);
//
//        Root<EmployeeEntity> companyRoot = criteriaQuery.from(EmployeeEntity.class);
//
//        Join<EmployeeEntity, CompanyEntity> takeJoin = companyRoot.join(EmployeeEntity_.companys);
//
//       // criteriaQuery.where(criteriaBuilder.equal(companyRoot.get(EmployeeEntity_.firstName), "Oleg"));
//
//        TypedQuery<EmployeeEntity> typedQuery = entityManager.createQuery(criteriaQuery);
//
//       List list =  typedQuery.getResultList();
//        for(Object j: list){
//            System.out.println(j);
//        }





//        Root<EmployeeEntity> root = criteriaQuery.from(EmployeeEntity.class);
//        Join<EmployeeEntity, CompanyEntity> takeJoin = root.join(EmployeeEntity_.companys);
//        criteriaQuery.where(criteriaBuilder.equal(root.get(EmployeeEntity_.firstName), "Oleg"));
//
//
//        TypedQuery<EmployeeEntity> typedQuery = entityManager.createQuery(criteriaQuery);
//
//
//                List list =  typedQuery.getResultList();
//        for(Object j: list){
//            System.out.println(j);
//        }




//        Root<EmployeeEntity> root = criteriaQuery.from(EmployeeEntity.class);
//        Join<EmployeeEntity, CompanyEntity> takeJoin = root.join(EmployeeEntity_.companys);
//        criteriaQuery.where(criteriaBuilder.equal(root.get(EmployeeEntity_.firstName), "Oleg"));
//
//
//        TypedQuery<EmployeeEntity> typedQuery = entityManager.createQuery(criteriaQuery);
//
//
//        List list =  typedQuery.getResultList();
//        for(Object j: list){
//            System.out.println(j);
//        }



//        Root<CompanyEntity> root = criteriaQuery.from(CompanyEntity.class);
//        Join<CompanyEntity, EmployeeEntity> takeJoin = root.join(CompanyEntity_.employeeSet);
//        criteriaQuery.where(criteriaBuilder.equal(root.get(CompanyEntity_.name), "Yamaha"));
//
//
//        TypedQuery<EmployeeEntity> typedQuery = entityManager.createQuery(criteriaQuery);
//
//        List list =  typedQuery.getResultList();
//        for(Object j: list){
//            System.out.println(j);
//        }

        // Show tables

//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<CompanyEntity> criteriaQuery = criteriaBuilder
//                .createQuery(CompanyEntity.class);
//
//        Root<CompanyEntity> companyRoot = criteriaQuery.from(CompanyEntity.class);
//
//        Join<CompanyEntity, EmployeeEntity> takeJoin = companyRoot.join(CompanyEntity_.employeeSet);
//
//         criteriaQuery.where(criteriaBuilder.equal(companyRoot.get(CompanyEntity_.name), "TrumpIncorporated"));
//
//
//
//        TypedQuery<CompanyEntity> typedQuery = entityManager.createQuery(criteriaQuery);
//
//        List list =  typedQuery.getResultList();
//        for(Object j: list){
//            System.out.println(j);
//        }



            //Simple query

//        CriteriaBuilder builder = HibernateUtil.getCriteriaBuilder();
//        EntityManager em = HibernateUtil.getEntityManager();
//        CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);
//        Root<CompanyEntity> companyRoot = criteriaQuery.from(CompanyEntity.class);
//        criteriaQuery.select(companyRoot.get("id").as(String.class));
//        criteriaQuery.where(builder.equal(companyRoot.get("name"), "Yamaha"));
//        List<String> nameList = em.createQuery(criteriaQuery).getResultList();
//        for (String name : nameList) {
//            System.out.println(name);
//        }

    }
}
