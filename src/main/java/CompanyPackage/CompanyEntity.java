package CompanyPackage; /**
 * Created by Roman on 04.10.2017.
 */


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nick on 18.10.2015.
 */
//@Entity
@Table(name = "company")
public class CompanyEntity {
    private int id;
    private Integer year;

    private String name;
    private Set<EmployeeEntity> employeeSet = new HashSet<EmployeeEntity>();

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_company",
            joinColumns = @JoinColumn(name = "company_id"),
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

    @Column(name = "name")
    public String getName() {
        return name;
    }


    @Override
    public String toString(){
        return getName() + " " + getEmployeeSet();
    }


    public void addEmployee(EmployeeEntity employee) {
        employeeSet.add(employee);
     //   employee.getCompanys().add(this);
    }
}
