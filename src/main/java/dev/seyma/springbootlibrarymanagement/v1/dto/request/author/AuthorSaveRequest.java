package dev.seyma.springbootlibrarymanagement.v1.dto.request.author;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class AuthorSaveRequest {
    @NotEmpty
    @NotNull
    private String name;

    @NotEmpty
    @NotNull
    private LocalDate year;

    @NotEmpty
    @NotNull
    private String country;
}
