package com.isaruh.sigh.model.request;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UserRequest {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String name;
}
