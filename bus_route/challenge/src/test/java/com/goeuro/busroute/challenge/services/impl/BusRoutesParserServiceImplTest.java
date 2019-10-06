package com.goeuro.busroute.challenge.services.impl;

import com.goeuro.busroute.challenge.models.Route;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class BusRoutesParserServiceImplTest {

    private BusRoutesParserServiceImpl busRoutesParserService;

    @Before
    public void setup() {
        busRoutesParserService = new BusRoutesParserServiceImpl();
    }

    @Test
    public void testParse() {
        List<Route> routes = busRoutesParserService.parse(getResource("route-data-test"));
        Assert.assertEquals(3, routes.size());
    }

    @Test(expected = RuntimeException.class)
    public void testFileNotFound() {
        busRoutesParserService.parse(new File("wrong file path"));
    }

    @Test(expected = RuntimeException.class)
    public void testParseBadFile() {
        busRoutesParserService.parse(getResource("route-data-bad"));
    }


    private File getResource(String resourceName) {
        ClassLoader classLoader = BusRoutesParserServiceImplTest.class.getClassLoader();
        return new File(classLoader.getResource(resourceName).getFile());
    }
}
