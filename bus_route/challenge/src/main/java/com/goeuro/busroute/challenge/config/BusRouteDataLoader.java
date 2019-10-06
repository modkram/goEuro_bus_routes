package com.goeuro.busroute.challenge.config;

import com.goeuro.busroute.challenge.data.BusRoutesDataRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

@Component
@Log4j2
public class BusRouteDataLoader implements CommandLineRunner {

    private BusRoutesDataRepository busRoutesDataRepository;

    public BusRouteDataLoader(BusRoutesDataRepository busRoutesDataRepository){
        this.busRoutesDataRepository = busRoutesDataRepository;
    }

    @Override
    public void run(String... args) {
        if (Objects.isNull(args) || args.length == 0) {
            throw new RuntimeException("File path is not specified, please run application with correct path to file");
        }

        log.info("Loading data from: " + Arrays.toString(args));

        busRoutesDataRepository.loadData(new File(args[0]));
    }
}
