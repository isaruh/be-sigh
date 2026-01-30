package com.isaruh.sigh.model.response;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ApiResponse<T> {
    private StatusResponse status;
    private T data;
    private PagingResponse paging;
}
