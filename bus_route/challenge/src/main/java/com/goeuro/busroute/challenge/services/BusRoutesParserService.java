package com.goeuro.busroute.challenge.services;

import com.goeuro.busroute.challenge.models.Route;

import java.io.File;
import java.util.List;

public interface BusRoutesParserService {

    List<Route> parse(File file);

}
