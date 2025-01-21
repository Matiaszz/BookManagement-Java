package dev.matias.bookManagement.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    public List<String> validateBookFields(BookModel bookModel) {

        String[] fields = {
                bookModel.getTitle(),
                bookModel.getShortDescription(),
                bookModel.getLongDescription(),
                bookModel.getCoverImgUrl(),
                bookModel.getPublisher(),
                bookModel.getGenre(),
                bookModel.getAuthor(),

        };

        int[] maxLengths = { 50, 500, 5000, 500, 50, 50, 50 };

        String[] fieldNames = {
                "Title",
                "Short description",
                "Long description",
                "Cover image URL",
                "Publisher",
                "Genre",
                "Author"
        };

        List<String> errors = new ArrayList<>();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i] == null || fields[i].isEmpty()) {
                errors.add(fieldNames[i] + " is required.");
            } else if (fields[i].length() > maxLengths[i]) {
                errors.add(fieldNames[i] + " can't have more than " + maxLengths[i] + " characters.");
            }
        }
        return errors;
    }
}
