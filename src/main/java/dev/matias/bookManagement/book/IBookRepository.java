package dev.matias.bookManagement.book;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<BookModel, UUID> {
    BookModel findByTitle(String title);

}
