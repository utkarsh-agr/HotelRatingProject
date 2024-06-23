package com.userservice.entities;

import com.userservice.payloads.Rating.Rating;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "micro_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String about;

    @Transient
    private List<Rating> ratings= new ArrayList<>();
}
