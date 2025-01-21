package dev.matias.bookManagement.book;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.matias.bookManagement.book.validator.BookValidator;

@Service
public class BookService {

    private final BookValidator bookValidator;

    public BookService() {
        this.bookValidator = new BookValidator();
    }

    public List<String> validateBookFields(String[] fields, int[] maxLengths) {
        return bookValidator.validate(fields, maxLengths);
    }
}