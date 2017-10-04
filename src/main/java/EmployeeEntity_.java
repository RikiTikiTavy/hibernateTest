import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by roman on 10/4/17.
 */
@StaticMetamodel(EmployeeEntity.class)
public class EmployeeEntity_ {
    public static volatile SingularAttribute<EmployeeEntity,Integer> id;
    public static volatile SingularAttribute<EmployeeEntity,String> firstname;
    public static volatile SingularAttribute<EmployeeEntity,String> lastname;
    public static volatile SingularAttribute<EmployeeEntity,EmployeeEntity> companys;
}
