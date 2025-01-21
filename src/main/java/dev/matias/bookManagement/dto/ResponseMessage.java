package dev.matias.bookManagement.dto;

import lombok.Data;

@Data
public class ResponseMessage {
    private String message;
    private Object data;

    public ResponseMessage(String message, Object data) {
        setMessage(message);
        setData(data);
    }
}
