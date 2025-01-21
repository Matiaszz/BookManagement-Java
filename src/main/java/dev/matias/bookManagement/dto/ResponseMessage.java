package dev.matias.bookManagement.dto;

import java.util.List;

import lombok.Data;

@Data
public class ResponseMessage {
    private String message;
    private Object data;
    private List<String> errors;

    public ResponseMessage(String message, Object data, List<String> errors) {
        setMessage(message);
        setData(data);
        setErrors(errors);
    }

    public ResponseMessage(String message, Object data) {
        this(message, data, null);
    }
}
