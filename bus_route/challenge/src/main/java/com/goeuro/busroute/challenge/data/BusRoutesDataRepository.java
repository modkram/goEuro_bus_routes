package com.goeuro.busroute.challenge.data;

import com.goeuro.busroute.challenge.models.Route;

import java.io.File;
import java.util.List;

public interface BusRoutesDataRepository {

    void loadData(File file);

    List<Route> findAll();

}
