package com.goeuro.busroute.challenge.services;

import com.goeuro.busroute.challenge.models.Station;

public interface BusRouteService {

    boolean isDirectConnection(Station from, Station to);
}
