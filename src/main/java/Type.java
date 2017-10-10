import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by roman on 10/4/17.
 */
@Entity
@Table(name = "Type")
public enum  Type {

    ADMIN("admin"),
    TESTER("tester"),
    SUPPORT("support");

    private Set<EmployeeEntity> employeeEntitySet = new HashSet<EmployeeEntity>();

    private int type_Id;
    private String typeName;

    @OneToMany(mappedBy = "type")
    public Set<EmployeeEntity> getEmployeeEntitySet() {
        return employeeEntitySet;
    }

    public void setEmployeeEntitySet(Set<EmployeeEntity> employeeEntitySet) {
        this.employeeEntitySet = employeeEntitySet;
    }

     Type(String typeName){
            this.typeName = typeName;
    }

     Type(){

    }

    @Id
    @GeneratedValue
    @Column(name = "TYPE_ID")
    public int getType_Id() {
        return type_Id;
    }

    public void setType_Id(int type_Id) {
        this.type_Id = type_Id;
    }

    @Column(name = "TYPE_NAME", nullable = false, length = 100)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return getTypeName();
    }
}
