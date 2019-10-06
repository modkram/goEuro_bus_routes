package com.goeuro.busroute.challenge.web;

import com.goeuro.busroute.challenge.dto.ConnectionResponseDTO;
import com.goeuro.busroute.challenge.models.Station;
import com.goeuro.busroute.challenge.services.BusRouteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RouteController {

  private BusRouteService busRouteService;

  public RouteController(BusRouteService busRouteService) {
    this.busRouteService = busRouteService;
  }

  @GetMapping("/direct")
  public ConnectionResponseDTO findDirectConnection(@RequestParam("dep_sid") Integer from,
                                                    @RequestParam("arr_sid") Integer to) {

    boolean isConnected = busRouteService.isDirectConnection(new Station(from), new Station(to));

    return new ConnectionResponseDTO(from, to, isConnected);
  }
}
