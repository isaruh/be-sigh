package com.isaruh.sigh.entity;

import com.isaruh.sigh.model.response.UserResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity // define entity
@Table(name = "users") // set table name
@Getter @Setter // generate getter and setter
@NoArgsConstructor @AllArgsConstructor // set constructor
@Builder // generate builder
public class User extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column() // nullable
    private String name;

    public UserResponse toResponse() {
        return UserResponse.builder()
                .id(getId())
                .name(getName())
                .username(getUsername())
                .email(getEmail())
                .build();
    }
}
