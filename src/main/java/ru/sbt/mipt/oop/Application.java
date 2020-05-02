package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.ControlService;

import com.coolcompany.smarthome.events.SensorEventsManager;
import com.google.gson.Gson;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.data_reader.JSONData;
import ru.sbt.mipt.oop.home_components.SmartHome;
import ru.sbt.mipt.oop.home_readers.HomeReader;
import ru.sbt.mipt.oop.home_readers.JSONHomeReader;
import ru.sbt.mipt.oop.processors.*;

import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.remote.RemoteController;
import ru.sbt.mipt.oop.smart_home.SmartHomeHandler;

public class Application {
    public static HomeReader homeReader = new JSONHomeReader();
    private static ControlService controlService;
    public Application(ControlService controlService){
        this.controlService = controlService;
    }
    public static void main(String... args) throws IOException {
       AbstractApplicationContext context = new AnnotationConfigApplicationContext(SmartHomeConfig.class);
       SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);
       sensorEventsManager.start();
    }
}
