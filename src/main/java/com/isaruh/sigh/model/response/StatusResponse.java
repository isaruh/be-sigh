package com.isaruh.sigh.model.response;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class StatusResponse {
    private Integer code;
    private String description;
}
