package testLinkTable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;




    @Column
    private String title;

    @OneToMany(mappedBy = "file")
    private Set<FileDirectory> fileDirectories = new HashSet<FileDirectory>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<FileDirectory> getFileDirectories() {
        return fileDirectories;
    }

    public void setFileDirectories(Set<FileDirectory> fileDirectories) {
        this.fileDirectories = fileDirectories;
    }


}
