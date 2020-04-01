package ru.sbt.mipt.oop;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.data_reader.JSONData;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.home_components.Room;
import ru.sbt.mipt.oop.home_components.SmartHome;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LoaderForTest {
    public static  SensorEvent[] loadEvents (String path ) throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(path)));
        return  gson.fromJson(json, SensorEvent[].class);
    }

    public static SmartHome addAlarm (SmartHome smartHomeWithoutAlert, Integer activationCode ) {
        Alarm alarm = new Alarm(activationCode);
        smartHomeWithoutAlert.setAlarm(alarm);
        return smartHomeWithoutAlert;
    }

    public static SmartHome JSONLoadSmartHome ( String path ) throws IOException {
        JSONData tempJSON = new JSONData(path);
        Gson gson = new Gson();
        return gson.fromJson(tempJSON.getData(), SmartHome.class);
    }

    public static Room JSONloadSRoom(String path) throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(path)));
        return  gson.fromJson(json, Room.class);
    }


}
