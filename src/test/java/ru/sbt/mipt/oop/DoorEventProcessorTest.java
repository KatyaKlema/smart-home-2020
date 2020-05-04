package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import org.junit.Test;
import ru.sbt.mipt.oop.data_reader.JSONData;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.home_components.SmartHome;
import ru.sbt.mipt.oop.processors.DoorEventProcessor;

import java.io.IOException;

import static org.junit.Assert.*;

public class DoorEventProcessorTest {

    @Test
    public void processing() throws IOException {
        JSONData tempJSON = new JSONData("src/test/resources/sh_doors_open_lights_off.json");
        Gson gson = new Gson();
        SmartHome mainSmartHome = gson.fromJson(tempJSON.getData(), SmartHome.class);

        tempJSON.JSONLoader("src/test/resources/sh_doors_open_lights_off.json");
        SmartHome testSmartHome = gson.fromJson(tempJSON.getData(), SmartHome.class);

        tempJSON.JSONLoader("src/test/resources/unchanging_sensor_events.json");
        SensorEvent[] sensorEvents =  gson.fromJson(tempJSON.getData(), SensorEvent[].class);

        DoorEventProcessor doorEventProcessor = new DoorEventProcessor(testSmartHome);
        for (SensorEvent event : sensorEvents) {
            doorEventProcessor.processing(event);
        }
        assertEquals(testSmartHome, mainSmartHome);
    }
}