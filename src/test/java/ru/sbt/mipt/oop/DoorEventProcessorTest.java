package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.SensorEventTypeDoor.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventTypeDoor.DOOR_OPEN;

public class DoorEventProcessorTest {

    @Test
    public void processing() throws IOException {
        JSON tempJSON = new JSON("src/test/resources/sh_doors_open_lights_off.json");
        Gson gson = new Gson();
        SmartHome mainSmartHome = gson.fromJson(tempJSON.getData(), SmartHome.class);

        tempJSON.JSONLoader("src/test/resources/sh_doors_open_lights_off.json");
        SmartHome testSmartHome = gson.fromJson(tempJSON.getData(), SmartHome.class);

        tempJSON.JSONLoader("src/test/resources/unchanging_sensor_events.json");
        SensorEvent[] sensorEvents =  gson.fromJson(tempJSON.getData(), SensorEvent[].class);

        DoorIterator doorIterator = new DoorIterator(testSmartHome);
        DoorEventProcessor doorEventProcessor = new DoorEventProcessor(testSmartHome);
        for (SensorEvent event : sensorEvents) {
            doorEventProcessor.processing(new Event(event));
        }
        assertEquals(testSmartHome, mainSmartHome);
    }
}