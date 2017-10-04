import javax.persistence.*;

/**
 * Created by roman on 10/4/17.
 */
@Entity
@Table(name = "Type")
public class Type {

    public long type_Id;
    public String typeName;

    public Type(){

    }

    @Id
    @GeneratedValue
    @Column(name = "TYPE_ID")
    public long getTypeId() {
        return type_Id;
    }

    public void setTypeId(long typeId) {
        this.type_Id = typeId;
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
