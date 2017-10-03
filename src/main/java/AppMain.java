/**
 * Created by Roman on 04.10.2017.
 */
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

public class AppMain {

    public static void main(String[] args) {
        System.out.println("Hibernate tutorial start");

        Session session = HibernateUtil.getSessionFactory().openSession();


        Transaction tx = session.beginTransaction();

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

        session.save(employee);

        tx.commit();
        session.close();
    }

}
