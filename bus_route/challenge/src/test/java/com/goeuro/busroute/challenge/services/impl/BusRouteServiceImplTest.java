package com.goeuro.busroute.challenge.services.impl;

import com.goeuro.busroute.challenge.data.BusRoutesDataRepository;
import com.goeuro.busroute.challenge.models.Route;
import com.goeuro.busroute.challenge.models.Station;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BusRouteServiceImplTest {

    private BusRouteServiceImpl busRouteService;
    private BusRoutesDataRepository busRoutesDataRepository;

    @Before
    public void setup() {
        busRoutesDataRepository = mock(BusRoutesDataRepository.class);
        busRouteService = new BusRouteServiceImpl(busRoutesDataRepository);
        when(busRoutesDataRepository.findAll()).thenReturn(getRoutes());
    }

    @Test
    public void testIsConnectedReturnTrue() {
        boolean directConnection = busRouteService.isDirectConnection(new Station(3), new Station(6));
        Assert.assertTrue(directConnection);
    }

    @Test
    public void testIsConnectedReturnFalse() {
        boolean directConnection = busRouteService.isDirectConnection(new Station(2), new Station(6));
        Assert.assertFalse(directConnection);
    }

    private List<Route> getRoutes() {
        List<Route> routes = new ArrayList<>();
        routes.add(new Route(0, getStations(0, 1, 2, 3, 4)));
        routes.add(new Route(1, getStations(3, 1, 6, 5)));
        routes.add(new Route(2, getStations(0, 6, 4)));
        return routes;
    }

    private List<Station> getStations(Integer... stationIds) {
        List<Station> stations = new ArrayList<>();
        for (Integer id : stationIds) {
            stations.add(new Station(id));
        }
        return stations;
    }
}
