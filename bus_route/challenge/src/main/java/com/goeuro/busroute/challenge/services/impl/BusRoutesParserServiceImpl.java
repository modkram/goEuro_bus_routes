package com.goeuro.busroute.challenge.services.impl;

import com.goeuro.busroute.challenge.models.Route;
import com.goeuro.busroute.challenge.models.Station;
import com.goeuro.busroute.challenge.services.BusRoutesParserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@Log4j2
public class BusRoutesParserServiceImpl implements BusRoutesParserService {


    @Override
    public List<Route> parse(File file) {
        List<Route> routes;

        log.info("Parse file: {}",file.getAbsolutePath());

        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
            int busRoutesCount = Integer.parseInt(reader.readLine());

            routes = new ArrayList<>(busRoutesCount);

            while (busRoutesCount > 0) {
                String line = reader.readLine();
                routes.add(parseLine(line));
                busRoutesCount--;
            }

        } catch (Exception e) {
            log.error("Error while parsing file", e);
            throw new RuntimeException(e);
        }

        log.info("End parsing file, count of routes = {}", routes.size());

        return routes;
    }

    private Route parseLine(String line){
        Scanner scanner = new Scanner(line);
        int routeId = scanner.nextInt();
        log.info("Start parsing stations for route : {}", routeId);
        List<Station> stations = new ArrayList<>();

        while (scanner.hasNext()) {
            int station = scanner.nextInt();
            stations.add(new Station(station));
        }

        Route route = new Route(routeId, stations);
        log.info("End parsing route: {}", route);
        return route;
    }
}
