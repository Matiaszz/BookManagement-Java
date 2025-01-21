package dev.matias.bookManagement.validators;

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

    public List<String> validateBookFields(String[] fields, int[] maxLengths) {
        List<String> errors = new ArrayList<>();
        for (int i = 0; i < fields.length; i++) {
            String fieldValue = fields[i];
            String fieldName = fieldNames[i];

            if (fieldValue == null || fieldValue.isEmpty()) {
                errors.add(fieldName + " is required.");
            } else if (fieldValue.length() > maxLengths[i]) {
                errors.add(fieldName + " can't have more than " + maxLengths[i] + " characters.");
            }
        }
        return errors;
    }
}