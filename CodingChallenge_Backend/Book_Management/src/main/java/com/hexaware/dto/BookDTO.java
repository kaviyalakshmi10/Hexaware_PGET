package com.hexaware.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
}
