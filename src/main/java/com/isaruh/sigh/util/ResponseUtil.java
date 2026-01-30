package com.isaruh.sigh.util;

import com.isaruh.sigh.model.response.ApiResponse;
import com.isaruh.sigh.model.response.StatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static <T> ResponseEntity<ApiResponse<T>> buildSingleResponse(
            HttpStatus httpStatus,
            String message,
            T data
    ) {
        StatusResponse status = StatusResponse.builder()
                .code(httpStatus.value())
                .description(message)
                .build();

        ApiResponse<T> response = ApiResponse.<T>builder()
                .status(status)
                .data(data)
                .build();

        return ResponseEntity.status(httpStatus).body(response);
    }
}
