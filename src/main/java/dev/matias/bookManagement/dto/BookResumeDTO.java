package dev.matias.bookManagement.dto;

import dev.matias.bookManagement.book.BookModel;
import lombok.Data;

@Data
public class BookResumeDTO {
    private String title;
    private String shortDescription;
    private String coverImgUrl;
    private String author;
    private Double averageRating;

    public BookResumeDTO(BookModel book) {
        setTitle(book.getTitle());
        setShortDescription(getShortDescription());
        setCoverImgUrl(book.getCoverImgUrl());
        setAuthor(book.getAuthor());
        setAverageRating(book.getAverageRating());
    }
}
