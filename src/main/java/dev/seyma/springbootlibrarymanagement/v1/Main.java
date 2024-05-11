package dev.seyma.springbootlibrarymanagement.v1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("librarymanagement");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

//    // Adding an author
//    Author author = new Author();
//        author.setName("Hermann Karl Hesse");
//        author.setCountry("Germany");
//        author.setBirthDate(LocalDate.of(1877, Month.JULY, 2));
//        entityManager.persist(author); // Persisting the author entity
//
//        transaction.commit();

}
}
