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
        // считываем состояние дома из файла
        SmartHome smartHome = homeReader.read("smart-home-1.js");
        smartHome.setAlarm(new Alarm(2));

        // начинаем цикл обработки событий
        SensorEvent event = new SensorEvent();
        List<Processor> processors = Arrays.asList(new LightEventProcessor(smartHome), new DoorEventProcessor(smartHome),
                                    new HallDoorEventProcessor(smartHome), new TriggerAlarmEventProcessor(smartHome,
                                    Arrays.asList(new LightEventProcessor(smartHome), new DoorEventProcessor(smartHome))));

        SmartHomeHandler smartHomeHandler = new SmartHomeHandler(smartHome, event, processors);
        smartHomeHandler.runCycleForEvent();

        RemoteController remoteController1 = new RemoteController("1");
        RemoteController remoteController2 = new RemoteController("2");

        controlService.registerAdaptController(remoteController1, new Integer(remoteController1.getId()).toString());
        controlService.registerAdaptController(remoteController2, new Integer(remoteController2.getId()).toString());

//        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SmartHomeConfig.class);
//        SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);
//        sensorEventsManager.start();

    }
}