package com.userservice.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private String hotelId;
    private String hotelName;
    private String hotelAddress;
    private String hotelPhone;
    private String hotelAbout;

}
