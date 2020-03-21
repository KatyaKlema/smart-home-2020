package ru.sbt.mipt.oop;

import com.google.gson.Gson;
import org.junit.Test;
import java.io.IOException;

import static org.junit.Assert.*;

public class LightEventProcessorTest {

    @Test
    public void processing() throws IOException{
        JSON tempJSON = new JSON("src/test/resources/sh_doors_open_lights_off.json");
        Gson gson = new Gson();
        SmartHome mainSmartHome = gson.fromJson(tempJSON.getData(), SmartHome.class);

        tempJSON.JSONLoader("src/test/resources/sh_doors_open_lights_off.json");
        SmartHome testSmartHome = gson.fromJson(tempJSON.getData(), SmartHome.class);

        tempJSON.JSONLoader("src/test/resources/unchanging_sensor_events.json");
        SensorEvent[] sensorEvents =  gson.fromJson(tempJSON.getData(), SensorEvent[].class);

        LightIterator lightIterator = new LightIterator(testSmartHome);
        LightEventProcessor lightEventProcessor = new LightEventProcessor(testSmartHome);
        for (SensorEvent event : sensorEvents) {
            lightEventProcessor.processing(new Event(event));
        }
        assertEquals(testSmartHome, mainSmartHome);
    }
}