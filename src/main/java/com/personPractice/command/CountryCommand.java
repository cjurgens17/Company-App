package com.personPractice.command;


import com.personPractice.models.Location;
import com.personPractice.models.Region;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CountryCommand {
    private String countryName;
    private Location location;
    private Region region;
}
