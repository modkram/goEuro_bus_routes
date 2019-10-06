package com.goeuro.busroute.challenge.services.impl;

import com.goeuro.busroute.challenge.data.BusRoutesDataRepository;
import com.goeuro.busroute.challenge.models.Route;
import com.goeuro.busroute.challenge.models.Station;
import com.goeuro.busroute.challenge.services.BusRouteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Log4j2
public class BusRouteServiceImpl implements BusRouteService {

    private BusRoutesDataRepository busRoutesDataRepository;

    @Autowired
    public BusRouteServiceImpl(BusRoutesDataRepository busRoutesDataRepository){
        this.busRoutesDataRepository = busRoutesDataRepository;
    }

    @Override
    public boolean isDirectConnection(Station from, Station to) {
        log.info("Start finding directions for {}, {} stations", from, to);
        List<Route> routes = busRoutesDataRepository.findAll();
        List<Station> stations = Arrays.asList(from, to);
        if(routes != null){
             return routes.stream().anyMatch(el -> el.getStations().containsAll(stations));
        }
        return false;
    }
}
