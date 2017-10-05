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


    private Type type;

    private Set<CompanyEntity> companys = new HashSet<CompanyEntity>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_company",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    public Set<CompanyEntity> getCompanys() {
        return companys;
    }

    public void setCompanys(Set<CompanyEntity> companys) {
        this.companys = companys;
    }

    public void addCompany(CompanyEntity car) {
        companys.add(car);
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



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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