package com.goeuro.busroute.challenge.data.impl;

import com.goeuro.busroute.challenge.data.BusRoutesDataRepository;
import com.goeuro.busroute.challenge.models.BusRoutes;
import com.goeuro.busroute.challenge.models.Route;
import com.goeuro.busroute.challenge.services.BusRoutesParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Service
public class BusRoutesDataRepositoryImpl implements BusRoutesDataRepository {

    private BusRoutes busRoutes;

    private BusRoutesParserService busRoutesParserService;

    @Autowired
    public BusRoutesDataRepositoryImpl(BusRoutesParserService busRoutesParserService){
        this.busRoutesParserService = busRoutesParserService;
        busRoutes = new BusRoutes(Collections.EMPTY_LIST);
    }


    @Override
    public void loadData(File file) {
        busRoutes = new BusRoutes(busRoutesParserService.parse(file));
    }

    @Override
    public List<Route> findAll() {
        return busRoutes.getRoutes();
    }
}
