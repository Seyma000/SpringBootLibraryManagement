package dev.seyma.springbootlibrarymanagement.v1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "category_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int İd;

    @Column(name = "category_name", nullable = false)
    private String name;

    @Column(name = "category_description", nullable = false)
    private String description;

    @ManyToMany(mappedBy = "categories" , fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Book> bookList;


}
