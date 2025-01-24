package dev.matias.bookManagement.dto;

import java.util.UUID;

import dev.matias.bookManagement.book.BookModel;
import lombok.Data;

@Data
public class BookSummaryDTO {
    private UUID id;
    private String title;
    private String shortDescription;
    private String coverImgUrl;
    private String author;
    private Double averageRating;
    private String genre;

    public BookSummaryDTO(BookModel book) {
        setId(book.getId());
        setTitle(book.getTitle());
        setShortDescription(getShortDescription());
        setCoverImgUrl(book.getCoverImgUrl());
        setAuthor(book.getAuthor());
        setAverageRating(book.getAverageRating());
        setGenre(book.getGenre());
    }
}
