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
            employee4.setFirstName("Dmitry");
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


            Type type1 = new Type();
            type1.setTypeName("admin");

            Type type2 = new Type();
            type2.setTypeName("tester");

            Type type3 = new Type();
            type3.setTypeName("programmer");


            employee1.addCompany(company1);
            employee1.addCompany(company2);
            employee1.setType(type1);

            employee2.addCompany(company1);
            employee2.setType(type3);


            employee3.addCompany(company2);
            employee3.addCompany(company3);
            employee3.setType(type3);


            entityManager.persist(employee1);
            entityManager.persist(employee2);
            entityManager.persist(employee3);

            entityManager.flush();

            entityManager.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

//
//        CriteriaQuery<Object[]> q = criteriaBuilder.createQuery(Object[].class);
//        Root<EmployeeEntity> c = q.from(EmployeeEntity.class);
//        q.select(criteriaBuilder.array(c.get(EmployeeEntity_.firstName), c.get(EmployeeEntity_.lastName)));
//        List<Object[]> result = entityManager.createQuery(q).getResultList();
//
//        for(Object[] o : result){
//            for(Object s : o){
//                System.out.println(s);
//            }
//        }


        // Query For type

        CriteriaQuery<EmployeeEntity> criteriaQuery = criteriaBuilder
                .createQuery(EmployeeEntity.class);

        Root<Type> root = criteriaQuery.from(Type.class);
        Join<Type, EmployeeEntity> takeJoin = root.join(Type_.employeeEntitySet);
        criteriaQuery.select(takeJoin).where(criteriaBuilder.equal(root.get("typeName"), "programmer"));

        TypedQuery<EmployeeEntity> typedQuery = entityManager.createQuery(criteriaQuery);

        List list =  typedQuery.getResultList();
        for(Object j: list){
            System.out.println(j);
        }



        //Query for employee

//        CriteriaQuery<CompanyEntity> criteriaQuery = criteriaBuilder
//                .createQuery(CompanyEntity.class);
//
//        Root<EmployeeEntity> root = criteriaQuery.from(EmployeeEntity.class);
//        Join<EmployeeEntity, CompanyEntity> takeJoin = root.join(EmployeeEntity_.companys);
//        criteriaQuery.select(takeJoin).where(criteriaBuilder.equal(root.get("firstName"), "Marina"));
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
