package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.ControlService;

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
        List<Processor> processors = Arrays.asList(new TriggerAlarmEventProcessor(smartHome,
                                    Arrays.asList(new LightEventProcessor(smartHome), 
                                                  new DoorEventProcessor(smartHome),
                                                  new HallDoorEventProcessor(smartHome))));

        SmartHomeHandler smartHomeHandler = new SmartHomeHandler(smartHome, event, processors);
        smartHomeHandler.runCycleForEvent();

    }
}
