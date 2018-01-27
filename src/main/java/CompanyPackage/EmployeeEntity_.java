package CompanyPackage;


import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmployeeEntity.class)
public abstract class EmployeeEntity_ {

	public static volatile SingularAttribute<EmployeeEntity, String> firstName;
	public static volatile SingularAttribute<EmployeeEntity, String> lastName;
	public static volatile SetAttribute<EmployeeEntity, CompanyEntity> companys;
	public static volatile SingularAttribute<EmployeeEntity, Integer> id;

}

