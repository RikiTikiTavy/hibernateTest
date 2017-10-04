import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by roman on 10/4/17.
 */
@StaticMetamodel(CompanyEntity.class)
public class CompanyEntity_ {

    public static volatile SingularAttribute<CompanyEntity,Integer> id;
    public static volatile SingularAttribute<CompanyEntity,String> name;
    public static volatile SingularAttribute<CompanyEntity,Integer> year;
    public static volatile SingularAttribute<CompanyEntity,EmployeeEntity> employeeSet;
}
