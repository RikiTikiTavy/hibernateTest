package testLinkTable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FileDirectory {

    @EmbeddedId
    private FileDirectoryId id;

    @ManyToOne
    @JoinColumn(name = "fk_file", insertable = false, updatable = false)
    private File file;

    @ManyToOne
    @JoinColumn(name = "fk_directory", insertable = false, updatable = false)
    private Directory directory;

    public FileDirectory(){

    }

    public FileDirectory(File file, Directory directory) {
        // create primary key
        this.id = new FileDirectoryId(file.getId(), directory.getId());


        this.file = file;
        this.directory = directory;

        // update relationships to assure referential integrity
        directory.getFiles().add(this);
        file.getFileDirectories().add(this);
    }

    @Embeddable
    public static class FileDirectoryId implements Serializable {

        @Column(name = "fk_file")
        protected Long fileId;

        @Column(name = "fk_directory")
        protected Long directoryId;

        public FileDirectoryId() {

        }

        public FileDirectoryId(Long fileId, Long directoryId) {
            this.fileId = fileId;
            this.directoryId = directoryId;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result
                    + ((fileId == null) ? 0 : fileId.hashCode());
            result = prime * result
                    + ((directoryId == null) ? 0 : directoryId.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;

            FileDirectoryId other = (FileDirectoryId) obj;

            if (fileId == null) {
                if (other.fileId != null)
                    return false;
            } else if (!fileId.equals(other.fileId))
                return false;

            if (directoryId == null) {
                if (other.directoryId != null)
                    return false;
            } else if (!directoryId.equals(other.directoryId))
                return false;

            return true;
        }
    }

}