package CompanyPackage; /**
 * Created by Roman on 04.10.2017.
 */
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;

public class AppMain {



    public static void main(String[] args) {


        Tester tester = new Tester();

          EntityManager entityManager =  tester.getEntityManager();

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

            CompanyEntity company2 = new CompanyEntity();
            company2.setName("Gazprom");
            company2.setYear(2015);

            CompanyEntity company3 = new CompanyEntity();
            company3.setName("TrumpIncorporated");
            company3.setYear(2001);



            employee1.addCompany(company1);
            employee1.addCompany(company3);
            employee1.setType(Type.SUPPORT);

            employee2.addCompany(company1);
            employee2.setType(Type.ADMIN);

            employee3.addCompany(company1);
            employee3.addCompany(company2);
            employee3.setType(Type.ADMIN);

            employee4.addCompany(company2);
            employee4.setType(Type.TESTER);

            entityManager.persist(employee1);
            entityManager.persist(employee2);
            entityManager.persist(employee3);

//            company1.addEmployee(employee1);
//            company1.addEmployee(employee2);
//            company2.addEmployee(employee1);
//            company2.addEmployee(employee3);
//
//            entityManager.persist(company1);
//            entityManager.persist(company2);
//            entityManager.persist(company3);

            entityManager.flush();

            entityManager.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        tester.getEmployeeCompanysThroughCompany("Oleg");

//        tester.queryForType(Type.ADMIN);

//            tester.getCompanyEmployee();
//            tester.getCompanyThroughEmployee("Oleg");
    }
}
