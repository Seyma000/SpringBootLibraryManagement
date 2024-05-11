package dev.seyma.springbootlibrarymanagement.v1.dto.request.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorUpdateRequest {
    private long id;
    private String name;
    private LocalDate year;
    private String country;
}
