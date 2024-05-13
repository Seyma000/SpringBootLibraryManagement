package dev.seyma.springbootlibrarymanagement.v1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bookBorrowing")
public class BookBorrowing {

    @Id
    @Column(name = "bookborrowing_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "borrower_Name", nullable = false)
    private String borrowerName;

    @Column(name = "borrowing_Date" ,nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate borrowingDate;


    @Column(name = "return_Date")
    @Temporal(TemporalType.DATE)
    private LocalDate returnDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "borrowing_book_id", referencedColumnName = "book_id")
    private Book book;


}
