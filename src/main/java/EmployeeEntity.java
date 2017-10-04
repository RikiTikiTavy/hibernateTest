/**
 * Created by Roman on 04.10.2017.
 */

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
    private int id;
    private String firstName;
    private String lastName;

    private Set<CarsEntity> cars = new HashSet<CarsEntity>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_car",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    public Set<CarsEntity> getCars () {
        return cars;
    }

    public void setCars(Set<CarsEntity> cars) {
        this.cars = cars;
    }

    public void addCar(CarsEntity car) {
        cars.add(car);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}