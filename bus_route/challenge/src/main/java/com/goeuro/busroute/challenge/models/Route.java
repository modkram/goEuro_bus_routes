package com.goeuro.busroute.challenge.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    private Integer id;
    private Collection<Station> stations;
}
