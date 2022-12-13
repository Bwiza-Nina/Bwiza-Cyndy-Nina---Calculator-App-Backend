package com.example.softwaretestingtermone.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private Boolean passed;
    private String message;
    private Object data;

    public Response(Boolean passed, String message) {
        this.passed = passed;
        this.message = message;
    }

    public Response(Boolean passed, Object data) {
        this.passed = passed;
        this.data = data;
    }

    public static Response success(Object data) {
        return new Response(true, data);
    }

    public static Response fail(Object data) {
        return new Response(false, data);
    }

    public static Response success(String message) {
        return new Response(true, message);
    }

    public static Response fail(String message) {
        return new Response(false, message);
    }
}
