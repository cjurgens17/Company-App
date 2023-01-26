package com.personPractice.command;

import com.personPractice.models.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegionCommand {
    private String regionName;
    private Country country;
}
