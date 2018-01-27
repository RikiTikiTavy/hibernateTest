package CompanyPackage;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by roman on 10/9/17.
 */
public class Tester {

    private EntityManager entityManager = HibernateUtil.getEntityManager();

    private  CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

    public EntityManager getEntityManager(){
        return entityManager;
    }


    public void getEmployeeCompanysThroughCompany(String employeeName){

        CriteriaQuery<EmployeeEntity> criteriaQuery = criteriaBuilder
                .createQuery(EmployeeEntity.class);

        Root<CompanyEntity> root = criteriaQuery.from(CompanyEntity.class);

        Join<CompanyEntity, EmployeeEntity> takeJoin = root.join(CompanyEntity_.employeeSet);


        criteriaQuery.select(takeJoin)
                .where(criteriaBuilder.equal(takeJoin.get(EmployeeEntity_.firstName), employeeName));

        TypedQuery<EmployeeEntity> typedQuery = entityManager.createQuery(criteriaQuery);

        EmployeeEntity employee =  typedQuery.getSingleResult();

        System.out.println(employee.getCompanys());
    }

    public void getCompanyThroughEmployee(String employeeName){
        CriteriaQuery<CompanyEntity> criteriaQuery = criteriaBuilder
                .createQuery(CompanyEntity.class);

        Root<EmployeeEntity> root = criteriaQuery.from(EmployeeEntity.class);
        Join<EmployeeEntity, CompanyEntity> takeJoin = root.join(EmployeeEntity_.companys);
        criteriaQuery.select(takeJoin).where(criteriaBuilder.equal(root.get(EmployeeEntity_.firstName), employeeName));

        TypedQuery<CompanyEntity> typedQuery = entityManager.createQuery(criteriaQuery);

        List list =  typedQuery.getResultList();
        for(Object j: list){
            System.out.println(j);
        }
    }


    public void simpleQuery(){
        CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<CompanyEntity> companyRoot = criteriaQuery.from(CompanyEntity.class);
        criteriaQuery.select(companyRoot.get("id").as(String.class));
        criteriaQuery.where(criteriaBuilder.equal(companyRoot.get("name"), "Yamaha"));
        List<String> nameList = entityManager.createQuery(criteriaQuery).getResultList();
        for (String name : nameList) {
            System.out.println(name);
        }
    }

    public void getCompanyEmployee(){
        CriteriaQuery<EmployeeEntity> criteriaQuery = criteriaBuilder
                .createQuery(EmployeeEntity.class);

        Root<CompanyEntity> root = criteriaQuery.from(CompanyEntity.class);
        Join<CompanyEntity, EmployeeEntity> takeJoin = root.join(CompanyEntity_.employeeSet);
        criteriaQuery.select(takeJoin).where(criteriaBuilder.equal(root.get(CompanyEntity_.name), "Yamaha"));

        TypedQuery<EmployeeEntity> typedQuery = entityManager.createQuery(criteriaQuery);

        List list =  typedQuery.getResultList();
        for(Object j: list){
            System.out.println(j);
        }
    }



    public void queryForType(Type type){
        CriteriaQuery<EmployeeEntity> criteriaQuery = criteriaBuilder
                .createQuery(EmployeeEntity.class);

        Root<Type> root = criteriaQuery.from(Type.class);
        Join<Type, EmployeeEntity> takeJoin = root.join(Type_.employeeEntitySet);
        criteriaQuery.select(takeJoin).where(criteriaBuilder.equal(root.get(Type_.typeName), type.getTypeName()));

        TypedQuery<EmployeeEntity> typedQuery = entityManager.createQuery(criteriaQuery);

        List list =  typedQuery.getResultList();
        for(Object j: list){
            System.out.println(j);
        }
    }

    public void getObjectFromDB(){

        CriteriaQuery<Object[]> q = criteriaBuilder.createQuery(Object[].class);
        Root<EmployeeEntity> c = q.from(EmployeeEntity.class);
        q.select(criteriaBuilder.array(c.get(EmployeeEntity_.firstName), c.get(EmployeeEntity_.lastName)));
        List<Object[]> result = entityManager.createQuery(q).getResultList();

        for(Object[] o : result){
            for(Object s : o){
                System.out.println(s);
            }
        }
    }

}
