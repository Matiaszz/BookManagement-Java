package dev.matias.bookManagement.book.validator;

import java.util.ArrayList;
import java.util.List;

public class BookValidator {

    private static final String[] fieldNames = {
            "Title",
            "Short description",
            "Long description",
            "Cover image URL",
            "Publisher",
            "Genre",
            "Author"
    };

    public List<String> validate(String[] fields, int[] maxLengths) {
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
