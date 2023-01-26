package com.personPractice.command;


import com.personPractice.models.Country;
import com.personPractice.models.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocationCommand {
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private Department department;
    private Country country;
}
