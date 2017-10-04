/**
 * Created by Roman on 04.10.2017.
 */

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nick on 18.10.2015.
 */
@Entity
@Table(name = "cars")
public class CarsEntity {
    private int id;
    private Integer year;
    private String model;

    private Set<EmployeeEntity> employeeSet = new HashSet<EmployeeEntity>();
    @ManyToMany
    @JoinTable(name = "employee_car",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    public Set<EmployeeEntity> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<EmployeeEntity> employeeSet) {
        this.employeeSet = employeeSet;
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

    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }


    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
