package testLinkTable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Directory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;


    @Column
    private String name;

    @OneToMany(mappedBy = "directory")
    private Set<FileDirectory> fileDirectory = new HashSet<FileDirectory>();



    @Enumerated(EnumType.STRING)
    private TypeOfDirectory typeOfDirectory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<FileDirectory> getFiles() {
        return fileDirectory;
    }

    public void setFileDirectory(Set<FileDirectory> fileDirectory) {
        this.fileDirectory = fileDirectory;
    }

    public Set<FileDirectory> getFileDirectory() {
        return fileDirectory;
    }

    public TypeOfDirectory getTypeOfDirectory() {
        return typeOfDirectory;
    }

    public void setTypeOfDirectory(TypeOfDirectory typeOfDirectory) {
        this.typeOfDirectory = typeOfDirectory;
    }
}