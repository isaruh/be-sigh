package com.isaruh.sigh.model.request;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class AuthRequest {
    private String username;
    private String email;
    private String password;
}
