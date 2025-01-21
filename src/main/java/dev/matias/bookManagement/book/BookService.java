package dev.matias.bookManagement.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.matias.bookManagement.validators.BookValidator;

@Service
public class BookService {

    private final BookValidator bookValidator;

    @Autowired
    public BookService() {
        this.bookValidator = new BookValidator();
    }

    public List<String> validateBookFields(String[] fields, int[] maxLengths) {
        return bookValidator.validateBookFields(fields, maxLengths);
    }
}