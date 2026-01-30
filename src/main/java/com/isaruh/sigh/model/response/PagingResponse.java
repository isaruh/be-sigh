package com.isaruh.sigh.model.response;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class PagingResponse {
    private Integer page;
    private Integer rowsPerPage;
    private Long totalRows;
    private Integer totalPages;
    private boolean hasNext;
    private boolean hasPrevious;
}
