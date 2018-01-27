package testLinkTable;

import CompanyPackage.Tester;

import javax.persistence.EntityManager;

public class MainLinkTest {


    public static void main(String[] args) {

        Tester tester = new Tester();

        EntityManager entityManager =  tester.getEntityManager();


        entityManager.getTransaction().begin();

        File file1 = new File();
        file1.setTitle("My File");
        entityManager.persist(file1);


        Directory directory1 = new Directory();
        directory1.setName("My Directory1");
        directory1.setTypeOfDirectory(TypeOfDirectory.NEW);
        entityManager.persist(directory1);

        Directory directory2 = new Directory();
        directory2.setName("My Directory2");
        directory2.setTypeOfDirectory(TypeOfDirectory.OLD);
        entityManager.persist(directory2);

        FileDirectory fileDirectory1 = new FileDirectory(file1, directory1);
        entityManager.persist(fileDirectory1);

        FileDirectory fileDirectory2 = new FileDirectory(file1, directory2);
        entityManager.persist(fileDirectory2);

        entityManager.getTransaction().commit();

        //NEW Transaction
//        entityManager.getTransaction().begin();
//
//        entityManager.getTransaction().commit();


        entityManager.close();
    }
}
