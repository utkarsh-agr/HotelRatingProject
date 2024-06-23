package com.hotelservices.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {

    @Id
    private String hotelId;
    private String hotelName;
    private String hotelAddress;
    private String hotelPhone;
    private String hotelAbout;
}
