package dev.seyma.springbootlibrarymanagement.v1.dto.request.publisher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherUpdateRequest {
    private long id;
    private String name;
    private LocalDate year;
    private String address;
}
