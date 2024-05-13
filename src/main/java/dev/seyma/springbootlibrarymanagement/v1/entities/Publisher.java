package dev.seyma.springbootlibrarymanagement.v1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "publisher")
public class Publisher {
    @Id
    @Column(name = "publisher_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "publisher_name", nullable = false)
    private String name;

    @Column(name = "publisher_establishmentYear")
    @Temporal(TemporalType.DATE)
    private LocalDate establishmentYear;

    @Column(name = "publisher_address")
    private String adress;


    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    private List<Book> bookList ;


}
