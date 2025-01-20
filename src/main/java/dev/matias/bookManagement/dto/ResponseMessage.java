package dev.matias.bookManagement.dto;

import lombok.Data;

@Data
public class ResponseMessage {
    private String message;
    private Object data;
    private Integer statusCode;

    public ResponseMessage(String message, Object data, Integer statusCode) {
        setMessage(message);
        setData(data);
        setStatusCode(statusCode);
    }
}
