package dev.matias.bookManagement.book;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "books")
public class BookModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(nullable = false)
    private String description, coverImgUrl, publisher, genre, author;

    @Column(nullable = false)
    private Double averageRating;

    @CreatedDate
    private LocalDateTime createdAt;

    @CurrentTimestamp
    private LocalDateTime updatedAt;
}
