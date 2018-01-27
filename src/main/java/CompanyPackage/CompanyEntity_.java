package CompanyPackage;


import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CompanyEntity.class)
public abstract class CompanyEntity_ {

	public static volatile SingularAttribute<CompanyEntity, Integer> year;
	public static volatile SingularAttribute<CompanyEntity, String> name;
	public static volatile SingularAttribute<CompanyEntity, Integer> id;
	public static volatile SetAttribute<CompanyEntity, EmployeeEntity> employeeSet;

}

